
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket; 

public class Server2 implements Role {
k
	private ServerSocket server; 
	private Socket socket;
	private PrintWriter out;
	private BufferedReader reader;
	private int port;
	public Server2(int port) {
	this.port = port;
	}
	
	public void setup()throws IOException{
		server = new ServerSocket(port);
		socket = server.accept();
		out = new PrintWriter(socket.getOutputStream(), true);
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public String recieveInfo() throws IOException{
		
	String line = reader.readLine();
	return line;
	}
	
	public void sendInfo(String msg) throws IOException {
       out.println(msg);
       
    }
	
	public void closeConnection() throws IOException{
		reader.close();
		out.close();
		server.close();
	}
}
