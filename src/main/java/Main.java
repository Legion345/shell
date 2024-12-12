import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");

            String input = scanner.nextLine();

            // exit command
            if (input.equals("exit 0"))
                break;
            // echo command
            if (input.startsWith("echo")) {
                String arguments = input.substring(5);
                System.out.println(arguments);
                continue;
            }

            System.out.println(input + ": command not found");
        }
    }
}
