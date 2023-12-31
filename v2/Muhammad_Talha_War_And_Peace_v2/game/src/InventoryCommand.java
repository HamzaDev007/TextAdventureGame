import java.util.List;

/**
 * Represents a command to display the contents of the player's inventory.
 */
public class InventoryCommand implements Command {
    private Player player;

    /**
     * Constructs an InventoryCommand object to manage the player's inventory.
     *
     * @param player The player whose inventory is being managed.
     */
    public InventoryCommand(Player player) {
        this.player = player;
    }

    /**
     * Executes the inventory command, displaying the contents of the player's inventory.
     *
     * @param player The player executing the command.
     */
    @Override
    public void execute(Player player) {
        displayInventory(player.getInventory());
    }

    /**
     * Displays the contents of the player's inventory.
     *
     * @param inventory The list of items in the player's inventory.
     */
    private void displayInventory(List<Item> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (Item item : inventory) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
    }
}
