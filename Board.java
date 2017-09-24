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
    /**
     * The single Board instance.
     */
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
     * The save manager for the board.
     */
    private SaveManager saveManager;

    /**
     * Constructor for Board class.
     * Sets the the size of board to 9x9 squares, and initialises the player list and save manager.
     * 
     * @author  Faishal
     * @author  Haryz
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
     * @author  Faishal
     * @return  The singleton instance of the board.
     */
    public static Board getInstance() {
        return instance;
    }

    /**
     * Gets the instance of the square at coordinate X and Y.
     * 
     * @author  Faishal
     * @param   x The X coordinate of the square.
     * @param   y The Y coordinate of the square.
     * @return  The square at coordinate X and Y of the board.
     */
    public Square getSquare(int x, int y) {
        return squares[x][y];
    }

    /**
     * Advances the turn counter.
     * Wraps back to 0 if the counter advances beyond the number of available players.
     * 
     * @author  Haryz
     * @return  A boolean - true if the counter is modified correctly
     */
    public boolean advanceTurn() {
        playerTurn = (playerTurn + 1) % players.size();
        return true;
    }

    /**
     * Gets the player of the current turn.
     * 
     * @author  Ramanan
     * @return  A player - the player of the current turn 
     */
    public Player getCurrentPlayer() {
        return players.get(playerTurn);
    }

    /**
     * Gets the player of the next turn.
     * 
     * @author  Haryz
     * @return  A player - the player of the next turn 
     */
    public Player getNextPlayer() {
        return players.get((playerTurn + 1) % players.size());
    }

    /**
     * Gets the current player turn.
     * 
     * @author  Ramanan
     * @return  An int - the counter for the current player
     */
    public int getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Gets all the players in the board.
     * 
     * @author  Ramanan
     * @return  An array list of players - all the players on the board 
     */
    public ArrayList<Player> getAllPlayers() {
        return players;
    }

    /**
     * Saves the state of the board with the save manager.
     * 
     * @author  Ramanan
     */
    public void save() {
        saveManager.save("testsave.txt");
    }

    /**
     * Loads the board to a previous state.
     * 
     * @author  Ramanan
     */
    public void load() {
        saveManager.load("testsave.txt");
    }

    /**
     * Initialises the board for a new game.
     * Clears the board, then adds players and special pieces to the board.
     * 
     * @author  Haryz
     * @return  A boolean - true if the board is successfully initialised
     */
    public boolean initializeBoard() {
        clearBoard();
        playerTurn = 0;

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
     * @author  Ramanan
     * @param   save The save file to restore from.
     * @return  A boolean - true if the board is successfully initialised
     */
    public boolean initializeBoard(SaveFile save) {
        int playerTurn = save.getPlayerTurn();
        ArrayList<Player> players = save.getPlayerData();
        ArrayList<Key> keys = save.getKeyData();
        String chestIconPath = save.getChestIconPath();

        clearBoard();

        Square chestSquare = getSquare(4, 4);
        chestSquare.setSpecialPiece(new Chest(chestSquare, chestIconPath, 5));

        for (Key key : keys) {
            Square square = key.getSquare();
            square.setSpecialPiece(key);
        }

        for (Player player : players) {
            Player p = new Player(player);
            this.players.add(p);
            p.getSquare().placePlayer(p);
        }
        
        this.playerTurn = playerTurn;

        return true;
    }

    /**
     * Clears and resets the board's attributes. Private method.
     * 
     * @author  Haryz
     * @return  A boolean - true if the operation is successful
     */
    private boolean clearBoard() {
        players.clear();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                squares[i][j].clear();
            }
        }

        return true;
    }
}
