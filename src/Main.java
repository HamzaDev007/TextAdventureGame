import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        // Initialize game elements, locations, items, etc.
        // Start the game loop
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Text Adventure Game!");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            game.processUserInput(input);
        }
    }
}
