/**
 * Represents a command to move the player in a specific direction.
 */
public class MoveCommand implements Command {
    private Direction direction;

    /**
     * Constructs a MoveCommand for the specified direction.
     *
     * @param direction The direction in which the player will move.
     */
    public MoveCommand(Direction direction) {
        this.direction = direction;
    }

    /**
     * Executes the Move command to move the player in the specified direction.
     *
     * @param player The player associated with the command.
     */
    @Override
    public void execute(Player player) {
        player.move(direction);
    }
}
