import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Server {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        try (ServerSocket welcomingSocket = new ServerSocket(5757)) {
            System.out.print("Server started.\nWaiting for a client ... ");
            try (Socket connectionSocket = welcomingSocket.accept()) {
                System.out.println("client accepted!");
                OutputStream out = connectionSocket.getOutputStream();
                InputStream in = connectionSocket.getInputStream();
                byte[] buffer = new byte[2048];
                for (int i = 0; i < 3; i++) {
                    int read = in.read(buffer);
                    String input = new String(buffer, 0, read);
                    System.out.println("RECV: " + input);
                    strings.add(input);
                    String msg = strings.stream().collect(Collectors.joining(" "));
                    if (i == 2)
                        msg = msg.concat(" over");
                    out.write(msg.getBytes());
                    System.out.println("SENT: " + msg);
                }
                System.out.print("All messages sent.\nClosing client ... ");
            } catch (IOException ex) {
                System.err.println(ex);
            }
            System.out.print("done.\nClosing server ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }
}