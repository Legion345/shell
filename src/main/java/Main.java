import java.util.Scanner;
import java.io.File;

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

                String[] builtInCommands = { "echo", "type", "exit", "ls" };
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
                    // Check for executables in PATH
                    String path = System.getenv("PATH");
                    String[] directories = path.split(":");
                    boolean found = false;

                    for (String dir : directories) {
                        File file = new File(dir, arguments);
                        if (file.exists() && file.isFile() && file.canExecute()) {
                            System.out.println(arguments + " is" + file.getAbsolutePath());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println(arguments + ": not found");
                    }
                }
                continue;
            }
            System.out.println(input + ": command not found");
        }
        scanner.close();
    }
}
