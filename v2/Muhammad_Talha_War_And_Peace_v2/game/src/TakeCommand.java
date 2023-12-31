import java.util.List;

/**
 * Represents a command to take an item from a location and add it to the player's inventory.
 */
public class TakeCommand implements Command {
    private String itemName;
    private Location currentLocation;

    /**
     * Constructs a command to take an item.
     *
     * @param itemName        The name of the item to take.
     * @param player          The player executing the command.
     * @param currentLocation The current location where the item is to be taken from.
     */
    public TakeCommand(String itemName, Player player, Location currentLocation) {
        this.itemName = itemName;
        this.currentLocation = currentLocation;
    }

    /**
     * Executes the command to take an item.
     *
     * @param player The player executing the command.
     */
    @Override
    public void execute(Player player) {
        Item itemToTake = findItem(itemName, currentLocation.getItems());
        if (itemToTake != null) {
            currentLocation.removeItem(itemToTake);
            player.addItemToInventory(itemToTake);
            System.out.println("You've taken the " + itemToTake.getName() + ".");
        } else {
            System.out.println("There is no " + itemName + " here.");
        }
    }

    /**
     * Finds the item with the given name in the specified list of items.
     *
     * @param itemName The name of the item to find.
     * @param items    The list of items to search in.
     * @return The item found, or null if not found.
     */
    private Item findItem(String itemName, List<Item> items) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}
