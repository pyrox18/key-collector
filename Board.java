import java.util.ArrayList;

/**
 * A board that contains 9x9 squares by default.
 * This class is using singleton design pattern by having only one instance of
 * Board class in the program.
 * 
 * @author  Muhammad Faishal Dzaky (1141326988)
 * @author  Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
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
     * Initialises the board for a new game.
     * Clears the board, then adds players and special pieces to the board.
     * 
     * @author Haryz
     * @return a boolean - true if the board is successfully initialised
     */
    public boolean initializeBoard() {
        final String[] playerNames = {
            "Ban Gei",
            "Ark Imides",
            "Can Ser",
            "Doz Ciztem"
        };

        clearBoard();

        players.add(new Player(getSquare(0, 0), playerNames[0]));
        players.add(new Player(getSquare(0, 8), playerNames[1]));
        players.add(new Player(getSquare(8, 0), playerNames[2]));
        players.add(new Player(getSquare(8, 8), playerNames[3]));

        Square chestSquare = getSquare(5, 5);
        chestSquare.setSpecialPiece(new Chest(chestSquare, 5));

        // Key setting is a placeholder for now - should be randomised later
        Square monkeySquare = getSquare(2, 3);
        monkeySquare.setSpecialPiece(new Key(monkeySquare, new MonkeyStrategy()));
        Square donkeySquare = getSquare(2, 6);
        donkeySquare.setSpecialPiece(new Key(donkeySquare, new DonkeyStrategy()));
        Square keyDiskSquare = getSquare(4, 4);
        keyDiskSquare.setSpecialPiece(new Key(keyDiskSquare, new KeyDiskStrategy()));
        Square pinkeySquare = getSquare(6, 5);
        pinkeySquare.setSpecialPiece(new Key(pinkeySquare, new PinkeyStrategy()));
        Square keyNoteSquare = getSquare(7, 6);
        keyNoteSquare.setSpecialPiece(new Key(keyNoteSquare, new KeyNoteStrategy()));

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
