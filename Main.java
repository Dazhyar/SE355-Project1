import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter paragraph: ");

        String userInput = sc.nextLine();
        System.out.println(userInput);         

        String[] words = userInput.split(" ");
    }
}