
import java.io.IOException;

public interface Role {
public void setup() throws IOException; 
public void sendInfo(String Mess)throws IOException; 
public String recieveInfo() throws IOException;
public void closeConnection() throws IOException; 

}
