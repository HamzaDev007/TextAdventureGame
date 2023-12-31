/**
 * Represents a command to be executed within the game.
 */
public interface Command {
    /**
     * Executes the command operation for the player.
     *
     * @param player The player object to perform the command operation.
     */
    void execute(Player player);
}
