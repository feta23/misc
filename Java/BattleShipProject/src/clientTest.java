
import java.io.IOException;
import java.util.Scanner;

public class clientTest {

	public static void main(String[] args) throws IOException {
		Controller client1 = new Controller("Client",4022,"localhost");
		client1.setup();
		client1.setShips();
		if(client1.checkReady()==true){
			System.out.println("game is ready");
			while(true) {
			client1.getShot();
			client1.display();
			client1.takeShot();
			client1.recieveVerdict();
			client1.display();
			client1.checkWinner(); 
			client1.getWinner();
			}
		}
	}
	
	}

