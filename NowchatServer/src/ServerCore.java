import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 */

/**
 * @author Calle
 *
 */
public class ServerCore {
	
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
			    ServerSocket serverSocket = new ServerSocket(PORT);
			    Socket clientSocket = serverSocket.accept();
			    PrintWriter out =
			        new PrintWriter(clientSocket.getOutputStream(), true);
			    BufferedReader in = new BufferedReader(
			        new InputStreamReader(clientSocket.getInputStream()));
			) 
			{
				String inputLine, outputLine;
	            
			    // Initiate conversation with client
			    //KnockKnockProtocol kkp = new KnockKnockProtocol();
				//outputLine = kkp.processInput(null);
				outputLine = "teststräng";
			    out.println(outputLine);
	
			    while ((inputLine = in.readLine()) != null) {
			        outputLine = "teststrängiloop";
			        out.println(outputLine);
			        if (outputLine.equals("Bye.")){
			        	break;
			        }
				}
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
