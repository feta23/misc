
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client2 implements Role {
 
	private Socket socket;
	private PrintWriter out;
	private BufferedReader reader;
	private InetAddress host;
	private String address; 
	private int port; 
	
	public Client2(int port, String address){
		this.port = port; 
		this.address = address; 
		if(this.address.isEmpty()) {
			this.address = "localhost";
		}
	}
	
	public void setup() throws IOException {
			host = InetAddress.getByName(address); 
			socket = new Socket(host,port);
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
		socket.close();
	}
		
	}
	
	

