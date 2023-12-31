import java.util.Scanner;

/**
 * The main class for the text-based adventure game.
 */
public class Main {
    private static Player player;

    /**
     * The main entry point of the game.
     * Initializes the game and starts the game loop.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        GameEngine game = initializeGame();
        playGame(game);
    }

    /**
     * Initializes the game by creating locations and items.
     *
     * @return The initialized GameEngine.
     */
    private static GameEngine initializeGame() {
        // Initialize locations, items, etc.
        Location start = new Location("Bedroom.");
        Location weaponRoom = new Location("Weapon store. Having multiple types of weapons.");
        Location cameraRoom = new Location("Media room. Having multiple types of media instruments to capture or record.");
        Location battleField = new Location("BattleField. Where the real crime happens");

        start.setExit(Direction.WEST, weaponRoom);
        start.setExit(Direction.EAST, cameraRoom);

        weaponRoom.setExit(Direction.SOUTH, battleField);
        cameraRoom.setExit(Direction.SOUTH, battleField);

        // Create items
        Item gun = new Item("Gun", "A powerful firearm");
        Item sword = new Item("Sword", "A sharp blade for close combat");
        Item rifle = new Item("Rifle", "A long-range weapon");
        Item iphone = new Item("IPhone", "A cellular device to connect to internet");
        Item camera = new Item("Camera", "A long-range video capturing instrument");
        Item tripod = new Item("Tripod", "A camera stand");
        Item mic = new Item("Mic", "A long-range audio listener");
        Item bag = new Item("Bag", "An Item keeper");

        weaponRoom.addItem(gun);
        weaponRoom.addItem(sword);
        weaponRoom.addItem(rifle);

        cameraRoom.addItem(iphone);
        cameraRoom.addItem(camera);
        cameraRoom.addItem(tripod);
        cameraRoom.addItem(mic);
        cameraRoom.addItem(bag);

        player = new Player(start);
        return new GameEngine(player);
    }

    /**
     * Starts the game loop, taking and processing user commands.
     *
     * @param game The GameEngine instance to play.
     */
    private static void playGame(GameEngine game) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Talha's war Adventure Game!");
        System.out.println("You wake up in your bedroom, and the town is under attack by the enemy. You have Two options and limited time to chose one of them. You have a weapon store on your west and Media room on the east. Good luck!");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            game.processCommand(input);
        }
    }
}
