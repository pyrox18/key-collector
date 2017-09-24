import java.util.ArrayList;

/**
 * A board that contains 9x9 squares by default.
 * This class is using singleton design pattern by having only one instance of
 * Board class in the program.
 * 
 * @author  Muhammad Faishal Dzaky (1141326988)
 * @author  Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 * @author  Ramanan R Muralitharan (1141128291)
 */

public class Board {
    private static Board instance = new Board();

    /**
     * Array of Square indicating how many squares are on the board.
     */
    private Square[][] squares;
    /**
     * List of players that are on the board.
     */
    private ArrayList<Player> players;
    /**
     * A counter to keep track of the current player turn.
     */
    private int playerTurn;
    /**
     * The save manager for the board
     */
    private SaveManager saveManager;

    /**
     * Constructor for Board class.
     * Sets the the size of board to 9x9 squares and initialises the player list.
     * 
     * @author Faishal
     * @author Haryz
     */
    private Board() {
        squares = new Square[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                squares[i][j] = new Square(i,j);
            }
        }
        players = new ArrayList<Player>();
        saveManager = new SaveManager();
    }

    /**
     * Gets the instance of the board.
     * 
     * @author Faishal
     * @return the instance
     */
    public static Board getInstance() {
        return instance;
    }

    /**
     * Gets the instance of the square at coordinate X and Y.
     * 
     * @author Faishal
     * @param x the X coordinate of the square.
     * @param y the Y coordinate of the square.
     * @return the square at coordinate X and Y of the board.
     */
    public Square getSquare(int x, int y) {
        return squares[x][y];
    }

    /**
     * Advances the turn counter.
     * Wraps back to 0 if the counter advances beyond the number of available players.
     * 
     * @author Haryz
     * @return a boolean - true if the counter is modified correctly
     */
    public boolean advanceTurn() {
        playerTurn = (playerTurn + 1) % players.size();
        return true;
    }

    /**
     * Gets the player of the current turn.
     * 
     * @author Ramanan
     * @return a player - the player of the current turn 
     */
    public Player getCurrentPlayer() {
        return players.get(playerTurn);
    }

    /**
     * Gets the player of the next turn.
     * 
     * @author Haryz
     * @return a player - the player of the next turn 
     */
    public Player getNextPlayer() {
        return players.get((playerTurn + 1) % players.size());
    }

    /**
     * Gets the current player turn.
     * 
     * @author Ramanan
     * @return an int - the counter for the current player
     */
    public int getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Gets all the players in the board.
     * 
     * @author Ramanan
     * @return an array list of player - all the players on the board 
     */
    public ArrayList<Player> getAllPlayers() {
        return players;
    }

    /**
     * Saves the state of board.
     * 
     * @author Ramanan
     */
    public void save() {
        saveManager.save("testsave.txt");
    }

    /**
     * Loads the board to a previous state.
     * 
     * @author Ramanan
     */
    public void load() {
        saveManager.load("testsave.txt");
    }

    /**
     * Initialises the board for a new game.
     * Clears the board, then adds players and special pieces to the board.
     * 
     * @author Haryz
     * @return a boolean - true if the board is successfully initialised
     */
    public boolean initializeBoard() {
        clearBoard();

        for (int i = 0; i < 4; i++) {
            try {
                Player player = Piece.generateNewPlayer();
                players.add(player);
            } catch (Exception e) {
                System.err.println(e);
                System.exit(0);
            }
        }

        Piece.generateNewChest();

        for (int i = 0; i < 5; i++) {
            try {
                Piece.generateNewKey();
            } catch (Exception e) {
                System.err.println(e);
                System.exit(0);
            }
        }

        return true;
    }

    /**
     * Restores the board to a previously saved state.
     * Clears the board, then adds players and special pieces to the board.
     * 
     * @author Ramanan
     * @param  playerTurn - the current player turn
     * @param  players - the list of players
     * @param  keys - the list of keys
     * @return a boolean - true if the board is successfully initialised
     */
    public boolean initializeBoard(int playerTurn, ArrayList<Player> players, ArrayList<Key> keys, String chestIconPath) {

        clearBoard();

        Square chestSquare = getSquare(4, 4);
        chestSquare.setSpecialPiece(new Chest(chestSquare, chestIconPath, 5));

        for (Key key : keys) {
            Square square = key.getSquare();
            square.setSpecialPiece(key);
        }

        Player p1 = new Player(players.get(0));
        this.players.add(p1);
        p1.getSquare().placePlayer(p1);
        Player p2 = new Player(players.get(1));
        this.players.add(p2);
        p2.getSquare().placePlayer(p2);
        Player p3 = new Player(players.get(2));
        this.players.add(p3);
        p3.getSquare().placePlayer(p3);
        Player p4 = new Player(players.get(3));
        this.players.add(p4);
        p4.getSquare().placePlayer(p4);
        
        this.playerTurn = playerTurn;

        return true;
    }

    /**
     * Clears and resets the board's attributes. Private method.
     * 
     * @author Haryz
     * @return a boolean - true if the operation is successful
     */
    private boolean clearBoard() {
        players.clear();
        squares = new Square[9][9];
        for (int i = 0; i < 9; i++) { // TODO: Refactor - redundant with constructor
            for (int j = 0; j < 9; j++) {
                squares[i][j] = new Square(i,j);
            }
        }

        return true;
    }
}
