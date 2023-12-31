import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a location within the game world.
 */
public class Location {
    private String description;
    private Map<Direction, Location> exits;
    private List<Item> items;

    /**
     * Constructs a location with a description.
     *
     * @param description The description of the location.
     */
    public Location(String description) {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
    }

    /**
     * Sets an exit in a particular direction from this location.
     *
     * @param direction The direction to set the exit.
     * @param location  The location in the specified direction.
     */
    public void setExit(Direction direction, Location location) {
        exits.put(direction, location);
    }

    /**
     * Gets the location in the specified direction from this location.
     *
     * @param direction The direction of the desired location.
     * @return The location in the specified direction.
     */
    public Location getExit(Direction direction) {
        return exits.get(direction);
    }

    /**
     * Adds an item to this location.
     *
     * @param item The item to be added.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes an item from this location.
     *
     * @param item The item to be removed.
     * @return True if the item was removed successfully, otherwise false.
     */
    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    /**
     * Retrieves a list of items in this location.
     *
     * @return The list of items in this location.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Retrieves the description of the location.
     *
     * @return The description of the location.
     */
    public String getDescription() {
        return description;
    }
}
