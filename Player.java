import java.util.ArrayList;

/**
 * A player piece that each player uses in the game.
 * 
 * @author      Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */

public class Player extends Piece {
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
     * Also sets the player's initial square.
     * 
     * @author Haryz
     * @param  square The square that the player is initially on.
     */
    public Player(Square square) {
        super(square);
        keys = new ArrayList<Key>();
        movementStrategy = new DefaultStrategy();
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
}