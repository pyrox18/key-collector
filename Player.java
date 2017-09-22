import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Point;

/**
 * A player piece that each player uses in the game.
 * 
 * @author      Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */

public class Player extends Piece {
    /**
     * The name of the player.
     */
    private String playerName;
    /**
     * A list of keys that the player currently possesses.
     */
    private ArrayList<Key> keys;
    /**
     * The movement strategy that the player is currently using to move on the board.
     */
    private MoveStrategy movementStrategy;

    /**
     * Constructor for the Player class.
     * Initialises the list of keys and sets the player to move using the default strategy.
     * Also sets the player's initial square, the piece's icon path and the player's name.
     * 
     * @author Haryz
     * @param  square The square that the player is initially on.
     * @param  iconPath The path to the icon for the piece.
     * @param  playerName The name of the player.
     */
    public Player(Square square, String iconPath, String playerName) {
        super(square, iconPath);
        this.playerName = playerName;
        keys = new ArrayList<Key>();
        movementStrategy = new DefaultStrategy();
    }

    /**
     * Constructor for the Player class.
     * Constructs the class based on a string with the same format as the string returned
     * by the toString method.
     * 
     * @author Haryz
     * @param  str A string containing the key data.
     * @throws Error if the string format is not recognised.
     */
    public Player(String str) {
        super(new Square(9, 9), str.split("\\|")[2]);
        String[] data = str.split("\\|");
        if (data[0] != "player") {
            throw new Error("Bad player string format");
        }
        else {
            keys = new ArrayList<Key>();
            ArrayList<String> dataList = new ArrayList<String>(Arrays.asList(data));
            String[] squareCoordinates = dataList.get(1).split(",");
            setSquare(Board.getInstance().getSquare(Integer.parseInt(squareCoordinates[0]), Integer.parseInt(squareCoordinates[1])));
            playerName = dataList.get(3);
            for (int i = 4; i < dataList.size(); i++) {
                String[] keyCoordinates = dataList.get(i).split(",");
                keys.add((Key) Board.getInstance().getSquare(Integer.parseInt(keyCoordinates[0]), Integer.parseInt(keyCoordinates[1])).getSpecialPiece());
            }
            if (keys.size() < 1) {
                movementStrategy = new DefaultStrategy();
            }
            else {
                movementStrategy = keys.get(0).getStrategy();
            }
        }
    }

    /**
     * Gets the player's name
     * 
     * @author Haryz
     * @return The playerName attribute.
     */
    public String getPlayerName() {
        return playerName;
    }
    
    /**
     * Gets the number of keys in the player's possession.
     * 
     * @author Haryz
     * @return The length of the keys list.
     */
    public int getNumberOfKeys() {
        return keys.size();
    }

    /**
     * Gets the list of keys in the player's possession.
     * 
     * @author Haryz
     * @return the keys
     */
    public ArrayList<Key> getKeys() {
        return keys;
    }

    /**
     * Adds a key that the player picks up to the keys list and sets the player's movement
     * strategy to the key's movement strategy.
     * 
     * @author Haryz
     * @param  key The key that the player picks up.
     * @return a boolean - true if the key is successfully added and the movement strategy is set, else false
     */
    public boolean pickupKey(Key key) {
        keys.remove(key);
        keys.add(0, key);
        movementStrategy = key.getStrategy();
        return true;
    }

    /**
     * Moves the player to a new square based on the player's current movement strategy.
     * 
     * @author Haryz
     * @param  square The square to move to.
     * @return a boolean - true if the movement is successful, else false
     */
    public boolean move(Square square) {
        boolean isMoveSuccessful = this.movementStrategy.move(this, square);
        return isMoveSuccessful;
    }

    /**
     * Gets the square points where a valid move can be made by the player.
     * 
     * @author Haryz
     * @return An ArrayList of valid movement points.
     */
    public ArrayList<Point> getValidMoveLocations() {
        return movementStrategy.getValidMoveLocations(this);
    }

    /**
     * Gets the player's data in the form of a string.
     * Example: "player|0,8|/icons/p1.gif|Can Ser|4,4|2,3|6,2"
     * 
     * @author Haryz
     * @return A string containing the player's data.
     */
    @Override
    public String toString() {
        String str = "player|";
        str.concat(getSquare().getPosition().x + "," + getSquare().getPosition().y);
        str.concat("|");
        str.concat(getIconPath());
        str.concat("|");
        str.concat(playerName);
        for (Key key : keys) {
            str.concat("|");
            Point keyLocation = key.getSquare().getPosition();
            str.concat(Integer.toString(keyLocation.x) + "," + Integer.toString(keyLocation.y));
        }
        return str;
    }
}