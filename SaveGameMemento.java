/**
 * A class used to save the state of SaveGameOriginator.
 * 
 * @author Ramanan R Muralitharan (1141128291)
 */
public class SaveGameMemento {

    /**
     * The current player turn
     */
    private int playerTurn;
    
    /**
     * Array list of all of the players
     */
    private ArrayList<Player> playerData;

    /**
     * Array list of all of the keys
     */
    private ArrayList<Key> keyData;

    /**
     * The constructor for SaveGameMemento class.
     * Sets the player turn to the current player turn.
     * Sets the player data to the current states of all players on the board.
     * Sets the key data to the current states of all keys on the board.
     * 
     * @author Ramanan
     * @param save - the state saver for the board
     */
    public SaveGameMemento (SaveGameOriginator save) {
        playerTurn = save.getPlayerTurn();
        playerData = save.getPlayerData();
        keyData = save.getKeyData();
    }

    /**
     * Gets the current player turn.
     * 
     * @author Ramanan
     * @return an int - the counter for the current player turn
     */
    public int getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Gets the players on the board.
     * 
     * @author Ramanan
     * @return an array list of players - the players on the board
     */
    public ArrayList<Player> getPlayerData() {
        return playerData;
    }

    /**
     * Gets the keys on the board.
     * 
     * @author Ramanan
     * @return an array list of keys - the keys on the board
     */
    public ArrayList<Key> getKeyData() {
        return keyData;
    }
}

