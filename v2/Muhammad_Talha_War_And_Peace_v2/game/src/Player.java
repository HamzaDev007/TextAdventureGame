import java.util.ArrayList;
import java.util.List;

/**
 * Represents the player in the game.
 */
public class Player {
    private Location currentLocation;
    private List<Item> inventory;

    /**
     * Constructs a player at the specified starting location.
     *
     * @param startingLocation The starting location of the player.
     */
    public Player(Location startingLocation) {
        this.currentLocation = startingLocation;
        inventory = new ArrayList<>();
    }

    /**
     * Moves the player in the specified direction.
     *
     * @param direction The direction in which the player will move.
     */
    public void move(Direction direction) {
        Location nextLocation = currentLocation.getExit(direction);
        if (nextLocation != null) {
            currentLocation = nextLocation;
            System.out.println("You've moved to: " + currentLocation.getDescription());
        } else {
            System.out.println("You cannot go that way!");
        }
    }

    /**
     * Adds an item to the player's inventory.
     *
     * @param item The item to add to the inventory.
     */
    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    /**
     * Removes an item from the player's inventory.
     *
     * @param item The item to remove from the inventory.
     */
    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }

    /**
     * Retrieves the player's current location.
     *
     * @return The current location of the player.
     */
    public Location getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Retrieves the player's inventory.
     *
     * @return The inventory of the player.
     */
    public List<Item> getInventory() {
        return inventory;
    }
}
