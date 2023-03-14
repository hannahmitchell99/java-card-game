import java.util.Scanner;

public class Snap extends CardGame{
    public Snap(String name) {
        super(name);
    }

    public void userTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Press enter to begin!");
        String input = scanner.nextLine();
        if (input.equals("")) {
            System.out.println("Enter key pressed.");
            System.out.println("Let's begin!");
        } else {
            while (!input.isEmpty()) {
                System.out.println("Press enter to begin.");
                input = scanner.nextLine();
                if (input.equals("")) {
                    System.out.println("Enter key pressed.");
                    System.out.println("Let's begin!");
                }
            }
        }
    }
}
