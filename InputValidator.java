import java.util.Scanner;

public class InputValidator {
    public static int getIntInput(Scanner scanner) {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer. Please try again:");
            return getIntInput(scanner);
        }
    }
}
