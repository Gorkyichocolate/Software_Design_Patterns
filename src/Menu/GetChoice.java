package Menu;

import java.util.Scanner;

public class GetChoice {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("enter number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
