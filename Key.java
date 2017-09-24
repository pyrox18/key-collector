/**
 * A key piece that can be picked up by players to unlock the chest.
 * 
 * @author      Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */

public class Key extends SpecialPiece {
    /**
     * The movement strategy tied to the key.
     */
    private MoveStrategy strategy;

    /**
     * Constructor for the Key class.
     * Sets the movement strategy related to the key.
     * Also sets the key's initial square and icon path.
     * 
     * @author Haryz
     * @param  square The square that the key is initially on.
     * @param  iconPath The path to the icon for the piece.
     * @param  strategy The movement strategy related to the key.
     */
    public Key(Square square, String iconPath, MoveStrategy strategy) {
        super(square, iconPath);
        this.strategy = strategy;
    }

    /**
     * Constructor for the Key class.
     * Constructs the class based on a string with the same format as the string returned
     * by the toString method.
     * 
     * @author Haryz
     * @param  str A string containing the key data.
     * @throws Error if the string format is not recognised.
     */
    public Key(String str) {
        super(new Square(9, 9), str.split("\\|")[2]);
        String[] data = str.split("\\|");
        if (!data[0].equals("key")) {
            throw new Error("Bad key string format");
        }
        else {
            String[] squareCoordinates = data[1].split(",");
            setSquare(Board.getInstance().getSquare(Integer.parseInt(squareCoordinates[0]), Integer.parseInt(squareCoordinates[1])));
            switch (data[3]) {
                case "MonkeyStrategy":
                    strategy = new MonkeyStrategy();
                    break;
                case "PinkeyStrategy":
                    strategy = new PinkeyStrategy();
                    break;
                case "KeyNoteStrategy":
                    strategy = new KeyNoteStrategy();
                    break;
                case "KeyDiskStrategy":
                    strategy = new KeyDiskStrategy();
                    break;
                case "DonkeyStrategy":
                    strategy = new DonkeyStrategy();
                    break;
                case "DefaultStrategy":
                default:
                    strategy = new DefaultStrategy();
            }
        }
    }

    /**
     * Gets the strategy attached to the key.
     * 
     * @author Haryz
     * @return the strategy
     */
    public MoveStrategy getStrategy() {
        return strategy;
    }

    /**
     * Method for a player to interact with the special piece.
     * 
     * @author Haryz
     * @param  player The player that is interacting with the special piece.
     * @return a boolean - true if the player successfully picks up the key, else false
     */
    @Override
    public boolean interact(Player player) {
        return player.pickupKey(this);
    }

    /**
     * Gets the key's data in the form of a string.
     * Example: "key|3,4|/icons/monkey.gif|MonkeyStrategy"
     * 
     * @author Haryz
     * @return A string containing the key's data.
     */
    @Override
    public String toString() {
        String str = "key|";
        str = str + getSquare().getPosition().x + "," + getSquare().getPosition().y;
        str = str + "|";
        str = str + getIconPath();
        str = str + "|";
        str = str + strategy.toString();
        return str;
    }
}