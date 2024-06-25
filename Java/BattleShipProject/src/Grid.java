
public class Grid {
private char[][] grid;
String name;

public Grid() {
	grid = createGrid(); 
	name = " ";
}

public Grid(String s) {
	grid = createGrid();
	name = s;
}

public char[][] createGrid(){
	char grid[][] = new char[10][10]; 
	for(int i = 0; i < 10; i++) {
		for(int j = 0; j < 10; j++) {
			grid[i][j] = '~'; 
		}
	}
	 return grid; 
}

public void displayGrid(){
	if(name != " ")
	System.out.println("      " + name);
	System.out.println("  A B C D E F G H I J");
	for(int i = 0; i < 10; i++ ) {
		System.out.print(i + " ");
		for(int j = 0; j < 10; j++){
			System.out.print(grid[i][j]+" ");
		}
		System.out.println(); 
	}
}

public void setGrid(char[][] grid){
	this.grid = grid; 
}

public char[][] getGrid(){
	return grid; 
}

public char getPoint(int x, int y) {
	return grid[x][y];
}

public void addShipPoint(int x, int y, char c) {
	grid[x][y]= c;
}

public void insertHitPoint(int x, int y) {
	grid[x][y] = 'H';
}

public void addMissPoint(int x, int y) {
	grid[x][y] = 'M';
}

public char getPointChar(int x, int y) {
	return grid[x][y];
}

}

