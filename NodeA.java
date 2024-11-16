import java.net.*;
import java.io.*;
import com.google.protobuf.Message;
import java.util.Arrays;


public class NodeA {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket()) {
            while (true) {
                Socket client = server.accept();
                InputStream in = client.getInputStream();
                Message msg = Message.parseDelimitedFrom(in);

                System.out.println();
                System.out.println(msg.getWord());
                System.out.println(msg.getVectorClockList());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
