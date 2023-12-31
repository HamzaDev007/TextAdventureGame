import java.util.List;

/**
 * Represents a command to drop an item from the player's inventory at the current location.
 */
public class DropCommand implements Command {
    private String itemName;
    private Player player;
    private Location currentLocation;

    /**
     * Constructs a DropCommand object to drop an item from the player's inventory at the current location.
     *
     * @param itemName        The name of the item to drop.
     * @param player          The player executing the command.
     * @param currentLocation The current location where the item is to be dropped.
     */
    public DropCommand(String itemName, Player player, Location currentLocation) {
        this.itemName = itemName;
        this.player = player;
        this.currentLocation = currentLocation;
    }

    /**
     * Executes the drop command, removing the specified item from the player's inventory and placing it in the current location.
     *
     * @param player The player executing the command.
     */
    @Override
    public void execute(Player player) {
        Item itemToDrop = findItem(itemName, player.getInventory());
        if (itemToDrop != null) {
            player.removeItemFromInventory(itemToDrop);
            currentLocation.addItem(itemToDrop);
            System.out.println("You've dropped the " + itemToDrop.getName() + ".");
        } else {
            System.out.println("You don't have a " + itemName + " in your inventory.");
        }
    }

    /**
     * Finds the specified item in the list of items.
     *
     * @param itemName The name of the item to find.
     * @param items    The list of items to search in.
     * @return The found item or null if not found.
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
