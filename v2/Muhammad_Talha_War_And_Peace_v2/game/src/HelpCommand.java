/**
 * Represents a command to display available commands and their usage instructions.
 */
public class HelpCommand implements Command {

    /**
     * Constructs a HelpCommand object, displaying available commands and their usage instructions.
     */
    public HelpCommand() {
        displayHelp();
    }

    /**
     * Executes the help command. This method is intentionally left blank as the help command doesn't perform actions on the player.
     *
     * @param player The player executing the command.
     */
    @Override
    public void execute(Player player) {
        // Help command execution intentionally left blank as it doesn't perform actions on the player.
    }

    /**
     * Displays available commands and their usage instructions.
     */
    private void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("- go [direction]");
        System.out.println("- look");
        System.out.println("- inventory");
        System.out.println("- take [item_name]");
        System.out.println("- drop [item_name]");
        System.out.println("- help");
    }
}
