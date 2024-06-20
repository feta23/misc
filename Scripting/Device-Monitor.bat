@echo off
setlocal enabledelayedexpansion

:: Initialize variables
call :initializeVariables

:: Collect static device information
call :getStaticDeviceInfo

:: Continuous loop to collect CPU, Memory, and Disk usage
call :collectUsageData

:: Calculate and output statistics
call :calculateStatistics

exit

:initializeVariables
    set DeviceName=%COMPUTERNAME%
    set MaxIterations=10
    set Iteration=0
    set TotalCPUUsage=0
    set TotalMemoryUsage=0
    set TotalDiskUsage=0
    set DiskType=""
    set CPUSlots=0
    set SlotCount=0
    set MinCPUUsage=100
    set MinMemoryUsage=100
    set MinDiskUsage=100
    set MaxCPUUsage=0
    set MaxMemoryUsage=0
    set MaxDiskUsage=0
    set drive=C:
    exit /b

:getStaticDeviceInfo 
    :: Get device name
    echo Device Name: %DeviceName%

    :: Get OS name
    for /f "tokens=2 delims==" %%A in ('wmic os get Caption /value') do set OSName=%%A
    echo OS Name: %OSName%

    :: Get processor
    for /f "tokens=2 delims==" %%A in ('wmic cpu get Name /value') do set CPUName=%%A
    echo Processor: %CPUName%  

    :: Get RAM
    for /f "tokens=4 delims= " %%a in ('systeminfo ^| findstr /C:"Total Physical Memory"') do set totalMemoryMB=%%a
    set totalMemoryMB=%totalMemoryMB:,=%
    for /f %%G in ('powershell -Command "[math]::Round([decimal](%totalMemoryMB%) / 1024, 1)"') do set totalMemoryGB=%%G
    for /f %%A in ('powershell "(Get-WmiObject -Class Win32_PhysicalMemory | Measure-Object -Property Capacity -Sum).Sum / 1GB"') do set TotalRAMGB=%%A
    echo Installed RAM: %TotalRAMGB% GB (%totalMemoryGB% GB usable)

    call :getMemorySlots
    call :getCPUSlots
    call :getNumberOfDisks
    call :getDiskType
    call :getDiskSpace
    exit /b

:getMemorySlots
    set "totalSlots=0"
    for /F "skip=1 tokens=1,2" %%a in ('wmic memphysical get MaxCapacity^, MemoryDevices') do (
        if "%%b" neq "" (
            set /a "totalSlots=%%b"
        )
    )
    set total=0
    set in_use=0
    for /f "skip=1" %%i in ('wmic memorychip get devicelocator') do (
        set /a total+=1
    )
    set /a in_use = total - 1
    echo RAM Slots Used: %in_use% of %totalSlots%
    exit /b

:getCPUSlots
    for /f %%A in ('wmic CPU get SocketDesignation /format:list ^| find /c "SocketDesignation"') do set TotalCPUSlots=%%A
    for /f "tokens=1,2 delims==" %%a in ('wmic cpu get NumberOfCores^,NumberOfLogicalProcessors /value ^| findstr "="') do (
        if "%%a"=="NumberOfCores" (
            set cores=%%b
        ) else if "%%a"=="NumberOfLogicalProcessors" (
            set logical_processors=%%b
        )
    )
    echo CPU Stats: Sockets = %TotalCPUSlots%   Cores = %cores%   Logical Processors = %logical_processors%
    exit /b

:getNumberOfDisks
    powershell -Command ^
    "$diskCount = Get-PhysicalDisk | Measure-Object | Select-Object -ExpandProperty Count; " ^
    "Write-Output ('Number of Disks: ' + $diskCount)"
     exit /b

:getDiskType
    for /f %%t in ('powershell -command "Get-PhysicalDisk | Where-Object { $_.DeviceID -eq '0' } | Select-Object MediaType"') do (
        set DiskType=%%t
    )
    echo Disk Type: %DiskType%
    exit /b

:getDiskSpace
    for /f "usebackq tokens=1,2 delims=:" %%a in (`powershell -command "$total = [math]::Round((Get-WmiObject Win32_LogicalDisk | Where-Object DeviceID -eq '%drive%').Size / 1GB); $free = [math]::Round((Get-WmiObject Win32_LogicalDisk | Where-Object DeviceID -eq '%drive%').FreeSpace / 1GB); Write-Output $total':'$free"`) do (
        set "total=%%a"
        set "free=%%b"
    )
    echo Disk Space: %free% GB free of %total% GB
    exit /b

:collectUsageData
    :loop
        set "CPUUsage="
        set "FreePhysicalMemory="
        set "TotalVisibleMemorySize="
        set "DiskUsage="

        :: Get CPU usage
        for /f "skip=1" %%p in ('wmic cpu get loadpercentage') do (
            set CPUUsage=%%p
            if !CPUUsage! lss !MinCPUUsage! set MinCPUUsage=!CPUUsage!
            if !CPUUsage! gtr !MaxCPUUsage! set MaxCPUUsage=!CPUUsage!
            goto gotCPU
        )
        :gotCPU
        :: Get memory usage
        for /f "tokens=2 delims==" %%A in ('wmic OS get FreePhysicalMemory^,TotalVisibleMemorySize /Format:List ^| findstr "="') do (
            if "%%A" neq "" (
                if not defined FreePhysicalMemory (
                    set FreePhysicalMemory=%%A
                ) else (
                    set TotalVisibleMemorySize=%%A
                )
            )
        )
        if defined FreePhysicalMemory if defined TotalVisibleMemorySize (
            set /A UsedMemory=TotalVisibleMemorySize-FreePhysicalMemory
            if %TotalVisibleMemorySize% gtr 0 (
                set /A MemoryUsagePercent=UsedMemory*100/TotalVisibleMemorySize
            ) else (
                set MemoryUsagePercent=0
            )
            if !MemoryUsagePercent! lss 0 set MemoryUsagePercent=0
        ) else (
            set MemoryUsagePercent=0
        )
        if !MemoryUsagePercent! lss !MinMemoryUsage! set MinMemoryUsage=!MemoryUsagePercent!
        if !MemoryUsagePercent! gtr !MaxMemoryUsage! set MaxMemoryUsage=!MemoryUsagePercent!

        :: Get disk usage
        for /f %%d in ('powershell -command "Get-WmiObject Win32_PerfFormattedData_PerfDisk_LogicalDisk | Where-Object { $_.Name -eq 'C:' } | Select-Object -ExpandProperty PercentDiskTime"') do (
            set /A DiskUsage=%%d
            if !DiskUsage! lss 0 set DiskUsage=0
            if !DiskUsage! gtr 100 set DiskUsage=100
            if !DiskUsage! lss !MinDiskUsage! set MinDiskUsage=!DiskUsage!
            if !DiskUsage! gtr !MaxDiskUsage! set MaxDiskUsage=!DiskUsage!
        )

        :: Increment iteration counter
        set /A Iteration+=1

        :: Sum up CPU, memory, and disk usage
        set /A TotalCPUUsage+=CPUUsage
        set /A TotalMemoryUsage+=MemoryUsagePercent
        set /A TotalDiskUsage+=DiskUsage

        :: Check if the maximum iterations reached, if yes, exit the loop
        if !Iteration! equ %MaxIterations% goto endLoop

        :: Wait for a short time before next iteration
        timeout /t 1 /nobreak >nul

        goto loop

    :endLoop
    exit /b

:calculateStatistics
    :: Calculate average CPU, memory, and disk usage
    set /A AvgCPUUsage=TotalCPUUsage/MaxIterations
    set /A AvgMemoryUsage=TotalMemoryUsage/MaxIterations
    set /A AvgDiskUsage=TotalDiskUsage/MaxIterations

    :: Check if averages are higher than specified amount and set warnings accordingly
    set AvgCPUWarning=
    if %AvgCPUUsage% geq 80 set AvgCPUWarning=WARNING^^!
    set AvgMemoryWarning=
    if %AvgMemoryUsage% geq 80 set AvgMemoryWarning=WARNING^^!
    set AvgDiskWarning=
    if %AvgDiskUsage% geq 80 set AvgDiskWarning=WARNING^^!

    echo.

    :: Ensure MinCPUUsage is set correctly
    if "%MinCPUUsage%"=="" set MinCPUUsage=0

    :: Output CPU usage
    echo Minimum CPU Utilization: %MinCPUUsage%%%
    echo Maximum CPU Utilization: %MaxCPUUsage%%%
    echo Average CPU Utilization: %AvgCPUUsage%%% %^!AvgCPUWarning^!

    echo.

    :: Ensure MinMemoryUsage is set correctly
    if "%MinMemoryUsage%"=="" set MinMemoryUsage=0

    :: Output memory usage
    echo Minimum Memory Usage: %MinMemoryUsage%%%
    echo Maximum Memory Usage: %MaxMemoryUsage%%%
    echo Average Memory Usage: %AvgMemoryUsage%%% %^!AvgMemoryWarning^!

    echo.

    :: Ensure MinDiskUsage is set correctly
    if "%MinDiskUsage%"=="" set MinDiskUsage=0

    :: Output disk usage
    echo Minimum Disk Active Time: %MinDiskUsage%%%
    echo Maximum Disk Active Time: %MaxDiskUsage%%%
    echo Average Disk Active Time: %AvgDiskUsage%%% %^!AvgDiskWarning^!

    exit /b
