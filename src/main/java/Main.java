import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();

            // exit command
            if (input.equals("exit 0")) {
                break;
            }
            // echo command
            if (input.startsWith("echo")) {
                String arguments = input.substring(5);
                System.out.println(arguments);
                continue;
            }
            if (input.startsWith("type")) {
                String arguments = input.substring(5).trim();

                if (arguments.isEmpty()) {
                    System.out.println(": not found");
                    continue;
                }

                String[] builtInCommands = { "echo", "type", "exit" };
                boolean isBuiltIn = false;

                for (String command : builtInCommands) {
                    if (command.equals(arguments)) {
                        isBuiltIn = true;
                        break;
                    }
                }

                if (isBuiltIn) {
                    System.out.println(arguments + " is a shell builtin");
                } else {
                    System.out.println(arguments + ": not found");
                }
                continue;
            }
            System.out.println(input + ": command not found");
        }
        scanner.close();
    }
}
