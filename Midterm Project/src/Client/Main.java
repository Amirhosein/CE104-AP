package Client;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author Amir Iravanimanesh
 * @date 5/25/2021
 */

// Client class
class Client {

    // driver code
    public static void main(String[] args) {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 1234)) {

            // writing to server
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            // reading from server
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line = null;

            while (!"exit".equalsIgnoreCase(line)) {

                // reading from user
                line = sc.nextLine();

                // sending the user input to server
                out.println(line);
                out.flush();

                // displaying server reply
                System.out.println("[SERVER] "
                        + in.readLine());
            }

            // closing the scanner object
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

