import java.net.*;
import java.io.*;

public class DateClient {
    public static void main(String[] args) {
        String hostname = "172.16.41.148"; // Localhost
        int port = 6013;

        try (Socket socket = new Socket(hostname, port)) {
            // Setup input stream to receive data
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Read the date sent by the server
            String time = reader.readLine();

            System.out.println("Server date/time is: " + time);

        } catch (UnknownHostException e) {
            System.out.println("Server not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}