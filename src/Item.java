/**
 * Represents an item that can be found and used in the game.
 */
public class Item {
    private String name;

    /**
     * Constructs an item with a given name.
     *
     * @param name The name of the item.
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }
}
