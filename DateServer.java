import java.net.*;
import java.io.*;
import java.util.Date;

public class DateServer {
    public static void main(String[] args) {
        int port = 6013;
        String ipAddress = "172.16.41.148";

        try {
            // Binding to a specific IP address
            InetAddress bindAddr = InetAddress.getByName(ipAddress);
           
            try (ServerSocket sock = new ServerSocket(port, 50, bindAddr)) {
                System.out.println("Server started on IP " );

                while (true) {
                    Socket client = sock.accept();
                    System.out.println("Client connected: " + client.getInetAddress());

                    PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                    pout.println(new Date().toString());

                    client.close();
                }
            }
        } catch (IOException ioe) {
            System.err.println("Server error: " + ioe.getMessage());
        }
    }
}
