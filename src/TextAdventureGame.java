import java.util.*;

// Enum to represent directions
enum Direction {
    NORTH, EAST, SOUTH, WEST
}

// Class representing an item
class Item {
    private String name;
    // Add more properties/methods as needed

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Class representing a location
class Location {
    private String description;
    private Map<Direction, Location> exits;
    private List<Item> items;

    public Location(String description) {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
    }

    public void setExit(Direction direction, Location location) {
        exits.put(direction, location);
    }

    public String getDescription() {
        return description;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    // Add more methods for interacting with items or characters in the location
}

// Class representing a character
class Character {
    private String name;
    // Add more properties/methods as needed

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Add methods for character interactions (fight, heal, etc.)
}

// Main game class
public class TextAdventureGame {
    private Location currentLocation;
    private List<Item> inventory;

    public TextAdventureGame() {
        // Initialize locations, characters, and items
        // Example:
        Location start = new Location("You are at the starting point.");
        Location secondRoom = new Location("You are in the second room.");
        Item sword = new Item("Sword");
        start.addItem(sword);
        start.setExit(Direction.NORTH, secondRoom);
        secondRoom.setExit(Direction.SOUTH, start);

        currentLocation = start;
        inventory = new ArrayList<>();
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
                // Implement dropping items from inventory
                break;
            case "help":
                // Display help instructions
                break;
            default:
                System.out.println("Invalid command. Type 'help' for instructions.");
        }
    }

    private void move(String direction) {
        // Implement logic to move to the specified direction if possible
    }

    private void takeItem(String itemName) {
        // Implement logic to take an item from the current location and add it to the inventory
    }

    private void displayInventory() {
        // Display items in the inventory
    }

    // Main method to run the game
    public static void main(String[] args) {
        TextAdventureGame game = new TextAdventureGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Text Adventure Game!");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            game.processCommand(input);
        }
    }
}