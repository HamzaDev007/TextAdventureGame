import java.util.List;

/**
 * Represents a command to observe the details of the current location.
 */
public class LookCommand implements Command {
    private Location currentLocation;

    /**
     * Constructs a LookCommand for the given location.
     *
     * @param currentLocation The current location to observe.
     */
    public LookCommand(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     * Displays the items available in the current location.
     */
    private void displayItems() {
        List<Item> items = currentLocation.getItems();
        if (!items.isEmpty()) {
            System.out.println("Items in this location:");
            for (Item item : items) {
                System.out.println("- " + item.getName());
            }
        } else {
            System.out.println("There are no items here.");
        }
    }

    /**
     * Displays the available exits/adjacent locations from the current location.
     */
    private void displayExits() {
        System.out.println("Exits:");
        for (Direction direction : Direction.values()) {
            Location nextLocation = currentLocation.getExit(direction);
            if (nextLocation != null) {
                System.out.println("- " + direction.toString() + ": " + nextLocation.getDescription());
            }
        }
    }

    /**
     * Executes the Look command, displaying details about the current location, its items, and exits.
     *
     * @param player The player associated with the command.
     */
    @Override
    public void execute(Player player) {
        // Display information about the current location
        System.out.println(currentLocation.getDescription());

        // Display items in the current location
        displayItems();

        // Display exits/adjacent locations
        displayExits();
    }
}
