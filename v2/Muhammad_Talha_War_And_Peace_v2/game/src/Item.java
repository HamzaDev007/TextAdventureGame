/**
 * Represents an item that can be found and used in the game.
 */
public class Item {
    private String name;
    private String description;

    /**
     * Constructs an item with a given name and description.
     *
     * @param name        The name of the item.
     * @param description The description of the item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the description of the item.
     *
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }
}
