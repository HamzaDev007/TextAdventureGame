import java.util.*;



/**
 * Represents the main game logic and interactions.
 */
public class Game {
    private Location currentLocation;
    private List<Item> inventory;
    private CommandProcessor commandProcessor;


    /**
     * Constructs the text adventure game.
     */
    public Game() {
        // Initialize locations, characters, and items
        // Example:
        commandProcessor = new CommandProcessor();
        Location start = new Location("You are at the starting point.");
        Location secondRoom = new Location("You are in the second room.");
        Item sword = new Item("Sword");
        start.addItem(sword);
        start.setExit(Direction.NORTH, secondRoom);
        secondRoom.setExit(Direction.SOUTH, start);

        currentLocation = start;
        // Initialize inventory with starting items
        inventory = new ArrayList<>();
    }

    /**
     * Processes the user command.
     *
     * @param command The command entered by the user.
     */
    public void processUserInput(String input) {
        commandProcessor.processCommand(this, input);
    }
    public void processCommand(String command) {
        String[] parts = command.toLowerCase().split(" ");
        String action = parts[0];

        switch (action) {
            case "go":
                if (parts.length > 1) {
                    String direction = parts[1];
                    move(direction);
                } else {
                    System.out.println("Go where?");
                }
                break;
            case "look":
                System.out.println(currentLocation.getDescription());
                // Add logic to describe items, characters, etc. in the location
                break;
            case "inventory":
                displayInventory();
                break;
            case "take":
                if (parts.length > 1) {
                    String itemName = parts[1];
                    takeItem(itemName);
                } else {
                    System.out.println("Take what?");
                }
                break;
            case "drop":
                if (parts.length > 1) {
                    String itemName = parts[1];
                    dropItem(itemName);
                } else {
                    System.out.println("Drop what?");
                }
                break;
            case "help":
                displayHelp();
                break;
            default:
                System.out.println("Invalid command. Type 'help' for instructions.");
        }
    }


    /**
     * Moves the player in the specified direction if possible.
     *
     * @param direction The direction in which the player wants to move.
     */
    private void move(String direction) {
        Direction dir = null;
        switch (direction) {
            case "north":
                dir = Direction.NORTH;
                break;
            case "east":
                dir = Direction.EAST;
                break;
            case "south":
                dir = Direction.SOUTH;
                break;
            case "west":
                dir = Direction.WEST;
                break;
            default:
                System.out.println("Invalid direction.");
                return;
        }

        Location nextLocation = currentLocation.getExit(dir);
        if (nextLocation != null) {
            currentLocation = nextLocation;
            System.out.println("You have moved to: " + currentLocation.getDescription());
        } else {
            System.out.println("You cannot go that way.");
        }
    }


    /**
     * Attempts to take an item from the current location and add it to the inventory.
     *
     * @param itemName The name of the item to take.
     */
    private void takeItemV2(String itemName) {
        boolean itemFound = false;
        for (Item item : currentLocation.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                inventory.add(item);
                currentLocation.removeItem(item);
                System.out.println("You've taken the " + itemName + ".");
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            System.out.println("The " + itemName + " is not here.");
        }
    }


    /**
     * Handles taking an item from the current location and adding it to the player's inventory.
     *
     * @param itemName The name of the item to take.
     */
    private void takeItem(String itemName) {
        boolean itemTaken = false;
        List<Item> itemsAtLocation = currentLocation.getItems();

        for (Item item : itemsAtLocation) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                inventory.add(item);
                currentLocation.removeItem(item);
                System.out.println("You've taken the " + item.getName() + ".");
                itemTaken = true;
                break;
            }
        }

        if (!itemTaken) {
            System.out.println("There is no " + itemName + " here.");
        }
    }


    /**
     * Handles dropping an item from the player's inventory and placing it in the current location.
     *
     * @param itemName The name of the item to drop.
     */
    private void dropItem(String itemName) {
        boolean itemDropped = false;

        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                currentLocation.addItem(item);
                inventory.remove(item);
                System.out.println("You've dropped the " + item.getName() + ".");
                itemDropped = true;
                break;
            }
        }

        if (!itemDropped) {
            System.out.println("You don't have a " + itemName + " in your inventory.");
        }
    }

    /**
     * Displays the contents of the player's inventory.
     */
    private void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }

    /**
     * Displays instructions or a list of available commands to the player.
     */
    private void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("- go [direction]");
        System.out.println("- look");
        System.out.println("- inventory");
        System.out.println("- take [item_name]");
        System.out.println("- drop [item_name]");
        System.out.println("- help");
        // Add descriptions or usage instructions for each command
    }


    /**
     * Adds an item to the player's inventory.
     *
     * @param item The item to add to the inventory.
     */
    private void addItemToInventory(Item item) {
        inventory.add(item);
    }

    /**
     * Main method to run the game.
     *
     * @param args Command-line arguments (unused).
     */
//    public static void main(String[] args) {
//        Game game = new Game();
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Welcome to the Text Adventure Game!");
//        while (true) {
//            System.out.print("> ");
//            String input = scanner.nextLine();
//            game.processUserInput(input);
//        }
//    }
}