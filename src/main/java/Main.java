import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {

            System.out.print("$ ");
            input = scanner.nextLine();

            // Check for the exit command
            if (input.equals("exit")) {
                System.out.println("$ exit 0");
                break;
            }

            System.out.println(input + ": command not found");

        } while (true);

        scanner.close();

    }
}
