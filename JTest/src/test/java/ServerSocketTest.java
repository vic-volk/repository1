import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 08.12.14
 * Time: 12:24
 * To change this template use File | Settings | File Templates.
 */
public class ServerSocketTest extends TestCase {

    public void testSocket(){

        try {
            ServerSocket serverSocket = new ServerSocket(8090);
            Socket clientSocket = serverSocket.accept();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in;

            while (true){
                Thread.sleep(200);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println(in.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }


}
