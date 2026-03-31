import java.util.Scanner;

public class Chatbot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input;

        System.out.println("🤖 Chatbot: Hello! Type 'exit' to end chat.");

        do {
            System.out.print("You: ");
            input = sc.nextLine().toLowerCase();

            if (input.contains("hello") || input.contains("hi")) {
                System.out.println("🤖 Chatbot: Hello! How can I help you?");
            } 
            else if (input.contains("how are you")) {
                System.out.println("🤖 Chatbot: I'm just a program, but I'm doing great!");
            } 
            else if (input.contains("your name")) {
                System.out.println("🤖 Chatbot: I am a simple Java Chatbot.");
            } 
            else if (input.contains("bye")) {
                System.out.println("🤖 Chatbot: Goodbye! Have a nice day.");
            } 
            else if (input.contains("help")) {
                System.out.println("🤖 Chatbot: You can greet me or ask basic questions.");
            } 
            else if (!input.equals("exit")) {
                System.out.println("🤖 Chatbot: Sorry, I don't understand that.");
            }

        } while (!input.equals("exit"));

        System.out.println("🤖 Chatbot: Chat ended.");
        sc.close();
    }
}