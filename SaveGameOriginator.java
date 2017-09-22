/**
 * A class that is used to save and load the state of the current game.
 * The states that are saved include the current player turn, player data and key data.
 * 
 * @author Ramanan R Muralitharan(1141128291)
 */
public class SaveGameOriginator {

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
     * The constructor for SaveGameOriginator class.
     * Sets the player turn to the current player turn.
     * Sets the player data to the current states of all players on the board.
     * Sets the key data to the current states of all keys on the board.
     * 
     * @author Ramanan
     * @param board - the instance of the board
     */
    public SaveGameOriginator (Board board) {
        playerData = new ArrayList(4);
        keyData = new ArrayList(7);

        playerTurn = board.getPlayerTurn();
        playerData = board.getAllPlayers().clone();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                SpecialPiece key = board.getSquare(i,j).getSpecialPiece();
                if (key != null && !(i == 0 && j == 0)) {
                    keyData.add(key);
                }
            }    
        }
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

    /**
     * Saves the current state of this object into the memento.
     * Returns the memento to the caretaker.
     * 
     * @author Ramanan
     * @return a SaveGameMemento - the current save of the game
     */
    public SaveGameMemento save() {
        return new SaveGameMemento(this);
    }

    /**
     * Loads this object to a previous state.
     * This objects attributes are set to the attributes from a previous session.
     * 
     * @author Ramanan
     * @param obj - the saved state to load from 
     */
    public void load(Object obj) {
        SaveGameMemento memento = obj;
        this.playerTurn = memento.getPlayerTurn();
        this.playerData = memento.getPlayerData();
        this.keyData = memento.getKeyData();
    }
    // TODO : change the use of Object as parameter
}