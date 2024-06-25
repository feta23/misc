
import java.io.IOException;
import java.util.Scanner; 
public class ServerTest {

	public static void main(String[] args) throws IOException {
		Controller server1 = new Controller("Server",4022,"localhost");
		server1.setup();
		server1.setShips();
		if(server1.checkReady()==true){
			System.out.println("game is ready");
			while(true) {
			server1.takeShot();
			server1.recieveVerdict();
			server1.display();
			server1.getShot();
			server1.display();
			server1.checkWinner(); 
			server1.getWinner();
			}
		}
   }

}
