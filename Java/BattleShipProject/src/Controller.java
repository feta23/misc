
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
	private Player player; 
	private Role role1; 
	private int xShot;
	private int yShot;
	private int port;
	private int enemyShipsLeft = 5;
	Scanner keyboard = new Scanner(System.in); 
	
	//constructor for the controller 
	public Controller(String choice, int port, String address){
		//creates a new player model object
		player = new Player(); 
		//depending on the choice for the role, the role will be initialized to either a Client or a Server
		if(choice.equalsIgnoreCase("Server")){
			role1 = new Server2(port); 
		}else {
			role1 = new Client2(port,address);
		}
		
	}
	
	//function that used the getBottomGrid function to get the most current bottom grid and displays it
	public void displayBottomGrid(){
		Grid tempGrid = player.getBottomGrid(); 
		tempGrid.displayGrid();
	}
	//function that used the getTopGrid function to get the most current top grid and displays it
	public void displayTopGrid() {
		Grid tempGrid = player.getTopGrid();
		tempGrid.displayGrid();
	}
	//display function that calls the displayTopGrid, displayBottomGrid and displayShips function 
	public void display(){
		displayTopGrid(); 
		displayBottomGrid(); 
		displayShips(); 
	}
	//set Ships function. just sets the ships 
	public void setShips() throws IOException{
		String letter; //letter stores player input for which letter column 
		String direction; //direction stores player input for which direction ship will be oriented
		char c;  //c will be used to convert the letter column into an integer value 
		int row; 
		int Originalrow = -1; 
		int Originalcolumn = -1; 
		int column = -1;
		
		int size; 
		String name = " "; 
		char id; 
		//getting the array of ships
		Ship[] tempShips = player.getShip();
		
		//loop to increment through the array of ships to be placed
		for(int j = 0; j < player.getNumberOfShips();j++){
			size = tempShips[j].getNumHoles(); 
			name = tempShips[j].getBoatname(); 
			id = tempShips[j].getShipID(); 
			//calls the displayTopGrid function and the displayBottomGrid function for each time a ship is placed
			displayTopGrid();	
			displayBottomGrid(); 
			
			//getting user input for which letter column to shoot at.
			System.out.println("ENTER A COLUMN TO PLACE "+name+" (size: "+size+")"); 
			do {
				letter = keyboard.next(); 
				c = letter.charAt(0); 
				Originalcolumn = coordinateConvert(c); //using a function to convert the letter coordinate into an integer value
				if(Originalcolumn == -1) { //if a letter that is not in the range, is entered a -1 is returned 
					System.out.println("ENTER A VALID COLUMN LETTER");
				}
			}while((Originalcolumn == -1)); //do while loop that will keep going until an accepted value is entered
			System.out.println("ENTER A ROW "); //getting row number from user 
			do {
				try {
				Originalrow = keyboard.nextInt();
				
				
				}catch(InputMismatchException e){ //input check, value > 9 or value < 0 will not be accepted 
					System.out.println("Please enter a valid number"); 
				    keyboard.next();
				    Originalrow = keyboard.nextInt();
				}
				
				
			}while((Originalrow > 9 || Originalrow < 0));
		
		    while(true) { //getting which way the ship will be placed, horizontal or vertical
			System.out.println("ENTER ORIENTATION. V for VERTICAL or H for Horizontal"); 
			direction = keyboard.next(); 
			c = direction.charAt(0);  
			if(c == 'V' || c=='H' || c=='h'|| c=='v'){
				break;
			}
			
		    }
			if(c=='V' || c =='v'){ //if a ship is being placed vertically, the row will increase or decrease 
				row = Originalrow;
				for(int i = 0; i < size; ++i ){
					if(row > 9){ //if the ship is too big to place and will go out of bounds, it will go as far as it can and then print from the opposite side
						row = Originalrow - (size - i);
					}
					insertShipPoint(row,Originalcolumn,tempShips[j].getShipID()); //inserting a ship character point 
					
						row++; //increasing row to insert vertically
					
				}
				
			}
			if(c=='H' || c=='h') { //if a ship is being placed horizontally, then the columns will increase 
				column = Originalcolumn;
				for(int i = 0; i < size; ++i ){
					if(column > 9){ //if the ship is too big to place and will go out of bounds, it will go as far as it can and then print from the opposite side
						column = Originalcolumn - (size - i);
					}
					insertShipPoint(Originalrow,column,tempShips[j].getShipID()); //inserting a ship character point
					 
				    column++; //increasing column to insert horizontally 
					
				}
				
			}
			
			
		}
		this.setReady(); //once all ships are placed, the player is ready
	}
	
	//function that will insert a ship character point. Parameters are an x and y value and a character for 
	// whichever ship that is being inserted 
	public void insertShipPoint(int x, int y, char c){
		char[][] tempGrid = player.getBottomGrid().getGrid();
		tempGrid[x][y] = c;
		player.getBottomGrid().setGrid(tempGrid);
	}
	
	//function that will convert a character to integer. 
	public int coordinateConvert(char c) {
		if(c == 'A' || c == 'a')
			return 0;
		if(c == 'B' || c =='b')
			return 1;
		if(c == 'C' || c =='c')
			return 2;
		if(c == 'D' || c =='d')
			return 3;
		if(c == 'E' || c == 'e')
			return 4;
		if(c == 'F' || c == 'f')
			return 5;
		if(c == 'G' || c == 'g')
			return 6;
		if(c == 'H' || c == 'h')
			return 7;
		if(c == 'I' || c=='i')
			return 8;
		if(c == 'J' || c =='j')
			return 9;
		else 
			return -1; //if a character that is not in this list is entered, -1 will be returned
	}

	//function to check if a shot is a hit on a ship
public boolean checkShot(int x, int y) throws IOException { //Opposing player  
	Ship[] tempShip = player.getShip(); 
	if(player.getBottomGrid().getPoint(y, x) == 'H') { //if that point was already hit, the user will be told it was already shot
		System.out.println("Point already used ..");
		return true; 
	}
		for(int i = 0; i < 5; i++) { //if it is a ship point that has not been hit, then getHit() function is called to make that ship hit
		if(player.getBottomGrid().getPoint(y, x) == tempShip[i].getShipID()) {
			tempShip[i].getHit();
			return true; //returns true if it is a hit
		}
		
	}
		
		return false; //returns false if not a hit
}

public void getShot() throws IOException{
	System.out.println("WAITING FOR OTHER PLAYERS SHOT...");
	//Receives info from the other player
	String shot = role1.recieveInfo();
	//algorithm to parse the message, and to get the separate x and y coordinates 
	int shotIntForm = Integer.parseInt(shot);
	int y = shotIntForm % 10; 
	shotIntForm = shotIntForm - y; 
	int x = shotIntForm / 10;
	//if the function check shot is true then it is a hit and a hit point is inserted, false is a miss and a miss point is inserted
	if(checkShot(x,y)==true) {
		System.out.println("ITS A HIT");
		role1.sendInfo("H");
		player.getBottomGrid().insertHitPoint(y, x);
	}else {
		System.out.println("ITS A MISS"); 
		role1.sendInfo("M");
		player.getBottomGrid().addMissPoint(y, x);
	}
}

//function that determines whether the shot you took is a hit or miss
public void recieveVerdict() throws IOException{
	String shot = role1.recieveInfo(); 
	char c = shot.charAt(0); 
	if(c =='H') {
		System.out.println("YOU HIT A SHIP"); 
		player.getTopGrid().insertHitPoint(this.getYshot(), this.getXshot()); //if the shot is a hit, an H is placed on top board to track player hits
	}
	if(c=='M') {
		System.out.println("YOU MISSED");
		player.getTopGrid().addMissPoint(this.getYshot(), this.getXshot()); //if the shot is a miss, an M is placed on top board to track player misses
	}
	setXshot(-1); 
	setYshot(-1);
	
}

//function that lets user take a shot at the other players board
public void takeShot() throws IOException{
	int x = -1;
	int y = -1;
	System.out.println("YOUR TURN");
	while(x == -1) {
	System.out.println("please enter the column your are firing into");
	String row = keyboard.next();
	char c = row.charAt(0); 
     x = coordinateConvert(c);
     if(x==-1){
    	 System.out.println("please print a valid column number");
     }
	}
	do {
	System.out.println("please enter the row you are firing");
	try {
	y = keyboard.nextInt(); 
	}catch(InputMismatchException e){
		System.out.println("Please enter a valid row number");
		keyboard.next();
		y = keyboard.nextInt();
	}
	}while(y < 0 || y > 9);
	this.setXshot(x);
	this.setYshot(y); 
	
	String message = x +""+y;
	role1.sendInfo(message);
}


//set the value of the x coordinate of the shot about to be taken
public void setXshot(int x){
	this.xShot = x; 
}

//returns the current x coordinate of the shot about to be taken
public int getXshot(){
	return xShot;
}

//sets the value of the y coordinate of the shot about to be taken
public void setYshot(int y){
	this.yShot = y;
}

//returns the current y coordinate of the shot about to be taken
public int getYshot() {
	return yShot;
}

//sets the current amount of enemy ships left
public void setEnemyShipsLeft(int enemyShipsLeft){
	this.enemyShipsLeft = enemyShipsLeft;
}

//returns the amount of enemy ships left
public int getEnemyShips(){
	return enemyShipsLeft;
}

//sends a message "ready", used when a player is done placing ships and is ready to start taking shots 
public void setReady() throws IOException{
	String mess = "Ready";
	role1.sendInfo(mess);
}

//checks if a player is ready to know when to start shooting between players
public boolean checkReady() throws IOException{
	String mess = role1.recieveInfo();
	if(mess.equalsIgnoreCase("Ready")) {
		return true;
	}else
		return false;
}

//checks how many ships are left 
public void checkWinner() throws IOException {
	String message = " "; 
	int sunkCount = 5; 
	Ship[] tempShips = player.getShip();
	for(int i = 0; i < 5; i++){
		if(tempShips[i].getBoatStatus()=='S') {
			sunkCount--; //sunk count gets decremented for every time it finds a ship that is sunk. Once to zero, all ships have been sunk
		}
	}
   
	if(sunkCount == 0) { //if sunk count is zero then all of your ships have sunk and you lost
		message = "LOSER";
		role1.sendInfo(message); //sends message that you have lost
		System.out.println("YOU LOST :( ");
		 role1.closeConnection();
    	 System.exit(-1);
	}else{
		player.setNumberOfShips(sunkCount); 
		message =sunkCount +""; //needed to become a string
		role1.sendInfo(message); //sends the amount of ships left 
	}
	   
}

//receives message from checkWinner function
//if message received is not equal to LOSER then you are the winner
public void getWinner() throws IOException{
     String message = role1.recieveInfo(); 
     if(message.equalsIgnoreCase("LOSER")) {
    	 System.out.println("YOU ARE A WINNER");
    	 role1.closeConnection();
    	 System.exit(-1); //once a winner is declared, the program terminates
    	 
     }else { //if not winner is declared yet then enemy ships get updated
    	 int enemyShip = Integer.parseInt(message);  
    	 setEnemyShipsLeft(enemyShip);	
     }
}

//sets up a role for the player to use
public void setup() throws IOException{
	role1.setup();
}

//closes connection to network
public void closeConnection() throws IOException{
	role1.closeConnection();
}

//function to display that status of players ships
public void displayShips() {
	Ship[] tempShip = player.getShip();
	
	int originalVal[] = new int[5]; 
	
	for(int i = 0; i < player.getNumberOfShips(); ++i) {
		originalVal[i] = tempShip[i].getNumHoles();
	}
	
	System.out.println("Enemy Ships Left:"+getEnemyShips());
	System.out.println("_____________________");
	System.out.println("    SHIP STATUS                           Cole Nussear and George Fotiou");
	System.out.println("_____________________");
	 for(int i = 0; i < 5; ++i) {
			 
		 System.out.print(tempShip[i].getBoatname() + "(" +tempShip[i].getShipID() + "): ");
		 
		 if(tempShip[i].getHolesLeft() == 0) {
			 System.out.print("SUNKED"); //will display sunk if the amount of holes left of a ship is 0
		 }else { 
			 
		 	for(int j = 0; j < tempShip[i].getHolesLeft(); ++j) { //displays a solid heart for the remaining hit points of a ship
		 		System.out.print("\u2665 ");
		 	}
		 	
		 	
		 	for(int h = 0; h < (originalVal[i] - tempShip[i].getHolesLeft()); ++h) { //displays an outlined heart for every time a ship was hit
		 		if(originalVal[i] > tempShip[i].getHolesLeft()) {
		 			System.out.print("\u2661 ");
		 		}
		 	}
		 }	
		 	System.out.println();
		 	System.out.println("_____________________");
	 }
}








	

}

