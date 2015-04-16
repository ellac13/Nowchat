import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 */

/**
 * @author Calle
 *
 */
public class ClientCore {
	
	
	//Internet address to connect to
	private static final String INET_ADDRESS = "192.168.1.96";
		
	//Port to connect to
	private static final int PORT = 8080;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (
			    Socket kkSocket = new Socket(INET_ADDRESS, PORT);
			    PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
			    BufferedReader in = new BufferedReader(
			        new InputStreamReader(kkSocket.getInputStream()));
			){
			
			String fromServer,fromUser;
			
			while ((fromServer = in.readLine()) != null) {
			    System.out.println("Server: " + fromServer);
			    if (fromServer.equals("Bye."))
			        break;

			    fromUser = Integer.toString(System.in.read());
			    if (fromUser != null) {
			        System.out.println("Client: " + fromUser);
			        out.println(fromUser);
			    }
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
