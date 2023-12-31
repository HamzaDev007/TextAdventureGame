/**
 * Parses user input and generates corresponding commands for the game.
 */
public class CommandParser {
    private Player player;

    /**
     * Constructs a CommandParser with a specified player.
     *
     * @param player The player object for command execution.
     */
    public CommandParser(Player player) {
        this.player = player;
    }

    /**
     * Parses the user input and generates the corresponding command.
     *
     * @param userInput The input provided by the user.
     * @return The command corresponding to the user input or null if invalid.
     */
    public Command parseCommand(String userInput) {
        String[] parts = userInput.toLowerCase().split(" ");
        String action = parts[0];

        if (action.equals("go")) {
            return parseGoCommand(parts);
        } else if (action.equals("take")) {
            return parseTakeCommand(parts);
        } else if (action.equals("drop")) {
            return parseDropCommand(parts);
        } else if (action.equals("inventory")) {
            return parseInventoryCommand();
        } else if (action.equals("look")) {
            return parseLookCommand();
        } else if (action.equals("help")) {
            return parseHelpCommand();
        }

        return null; // Invalid command
    }

    private Command parseGoCommand(String[] parts) {
        if (parts.length > 1 && parts.length < 3) {
            Direction direction = Direction.parseDirection(parts[1]);
            return new MoveCommand(direction != null ? direction : null);
        }
        return new MoveCommand(null);
    }

    private Command parseTakeCommand(String[] parts) {
        return new TakeCommand(parts[1], player, player.getCurrentLocation());
    }

    private Command parseDropCommand(String[] parts) {
        return new DropCommand(parts[1], player, player.getCurrentLocation());
    }

    private Command parseLookCommand() {
        return new LookCommand(player.getCurrentLocation());
    }

    private Command parseInventoryCommand() {
        return new InventoryCommand(player);
    }

    private Command parseHelpCommand() {
        return new HelpCommand();
    }
}
