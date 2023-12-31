/**
 * Represents a character in the game.
 */

public class Character {
    private String name;

    /**
     * Constructs a character with a given name.
     *
     * @param name The name of the character.
     */
    public Character(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the character.
     *
     * @return The name of the character.
     */
    public String getName() {
        return name;
    }
}
