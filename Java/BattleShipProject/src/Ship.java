
public class Ship {
	private String boatName;  
	private int numHoles; 
	private int countOfHoles; 
	private char boatStatus; 
	char[] IDarray;
	char shipID;
	
	
	public Ship(String boatName,int numHoles, char shipID){
	   this.boatName = boatName; 
	   this.numHoles = numHoles; 
	   this.countOfHoles = numHoles;
	   this.boatStatus = 'U' ; 
	   this.shipID = shipID;
	   IDarray = new char[this.numHoles]; 
	   
	   for(int i = 0; i<this.numHoles; i++  ){
		   IDarray[i] = this.shipID;
	   }
	   
	}

	public int getNumHoles(){
		return numHoles;
	}
	
	public void getHit(){
		countOfHoles--;
	}
	
	public int getHolesLeft(){
		return countOfHoles; 
	}
	
	public String getBoatname(){
		return boatName;
	}

		
	public void checkboatStatus(){
		if(countOfHoles == numHoles ){
			boatStatus = 'U';
		}else 
			if(countOfHoles < numHoles) {
			boatStatus = 'H';
			}
			if(countOfHoles == 0) {
			  boatStatus = 'S';
			}
	}
	
	public char getBoatStatus(){
		return boatStatus; 
	}
	
	public void setShipID(char shipID){
		this.shipID = shipID;
	 for(int i = 0; i<this.numHoles; i++  ){
			 IDarray[i] = this.shipID;
		 }
		
	}
	
	public char getShipID() {
		return shipID; 
	}
	
	
	
}