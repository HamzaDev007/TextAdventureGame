import java.util.HashMap;
import java.util.Map;

/**
 * Represents the cardinal directions in the game.
 */
public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    private static final Map<String, Direction> directionMap = new HashMap<>();

    // Initializes the direction map
    static {
        for (Direction direction : Direction.values()) {
            directionMap.put(direction.toString().toLowerCase(), direction);
        }
    }

    /**
     * Parses the string representation of a direction and returns the corresponding Direction object.
     *
     * @param directionStr The string representing a direction.
     * @return The Direction enum corresponding to the input string or null if not found.
     */
    public static Direction parseDirection(String directionStr) {
        return directionMap.getOrDefault(directionStr.toLowerCase(), null);
    }
}
