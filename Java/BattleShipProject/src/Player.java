

public class Player {
	private Ship[] ships; 
	private int numberOfShips;
	private Grid topgrid; 
	private Grid bottomgrid;
	public Player(){
		ships = new Ship[5];
		
		ships[0] = new Ship("CARRIER",5,'%');
		ships[1] = new Ship("BATTLESHIP",4,'#'); 
		ships[2] = new Ship("CRUISER",3,'&');
		ships[3] = new Ship("SUBMARINE",3,'!');
		ships[4] = new Ship("DESTROYER",2,'?'); 
		
		numberOfShips = 5; 
		
		topgrid = new Grid("Top Grid"); 
		bottomgrid = new Grid("Bottom Grid"); 
		
		
	}
	
	public void getHit(int shipIndex){
		ships[shipIndex].getHit();
	}
	public void setShip(int i,Ship ship){
		this.ships[i] = ship;
	}
	
	public Ship[] getShip(){
		return ships;
	}
	
	public void setTopGrid(Grid topgrid){
		this.topgrid = topgrid; 
	}
	
	public Grid getTopGrid(){
		return topgrid;
	}
	
	public void setBottomGrid(Grid bottomgrid){
		this.bottomgrid = bottomgrid; 
	}
	
	public Grid getBottomGrid(){
		return bottomgrid;
	}
	
	public void setNumberOfShips(int num){
		this.numberOfShips = num; 
	}
	
	public int getNumberOfShips(){
	  return numberOfShips;
	}
	
	//returns the character at the given point in the bottom grid
	public char getPointChar(int x, int y) {
		return this.bottomgrid.getPoint(x, y);
	}
	
}