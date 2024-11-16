import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.util.Arrays;
import com.google.protobuf.Message;


public class Main {
    static int[] vectorClock = {0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter paragraph: ");

        String userInput = sc.nextLine();
        System.out.println(userInput);   
        
        String[] words = userInput.split(" ");

        for (String word : words) {
            try (Socket socket = new Socket("localhost", 8000)) {
                OutputStream out = socket.getOutputStream();
    
                vectorClock[0]++;

                List<Integer> vectorClockList = Arrays.stream(vectorClock).boxed().toList();

                Message msg = Message.newBuilder()
                    .setWord(word)
                    .addAllVectorClock(vectorClockList)
                    .build();

                msg.writeDelimitedTo(out);
                out.flush();
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}