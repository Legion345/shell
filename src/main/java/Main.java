import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            String arguments = input.substring(5);
            String builtInCommands = input.substring(5);

            // exit command
            if (input.equals("exit 0"))
                break;
            // echo command
            if (input.startsWith("echo")) {
                System.out.println(arguments);
                continue;
            }
            if (builtInCommands.contains(arguments)) {
                System.out.println(arguments + " is a shell builtin");
                continue;
            } else if (input.startsWith("type")) {
                arguments = arguments.trim();
                if (arguments.isEmpty()) {
                    System.out.println(": not found");
                    continue;
                } else {
                    System.out.println(input + ": command not found");
                }
            }
        }
    }
}
