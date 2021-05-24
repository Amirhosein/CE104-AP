
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try (Socket client = new Socket("127.0.0.1", 5757)) {
            System.out.println("Connected to server.");
            OutputStream out = client.getOutputStream();
            InputStream in = client.getInputStream();
            byte[] buffer = new byte[2048];
            while (true) {
                String msg = input.nextLine();
                out.write(msg.getBytes());
                System.out.println("SENT: " + msg);
                int read = in.read(buffer);
                String income = new String(buffer, 0, read);
                System.out.println("RECV: " + income);
                if (income.contains("over"))
                    break;
            }
            System.out.print("All messages sent.\nClosing ... ");
        } catch (IOException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
        System.out.println("done.");
    }
}
