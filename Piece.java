/**
 * An abstract class that serves as the basis for pieces that are present on the game board
 * (players, keys and chest).
 * 
 * @author      Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */

public abstract class Piece {
    /**
     * The square that the piece is currently on.
     */
    private Square square;

    /**
     * Constructor for the Piece class.
     * Sets the square that the piece is initially on.
     * 
     * @author Haryz
     * @param  square The square that the piece is initially on.
     */
    public Piece(Square square) {
        this.square = square;
    }

    /**
     * Gets the square that the piece is currently on.
     * 
     * @author Haryz
     * @return the square
     */
    public Square getSquare() {
        return square;
    }

    /**
     * Sets the square that the piece is currently on.
     * 
     * @author Haryz
     * @param square the square to set
     */
    public void setSquare(Square square) {
        this.square = square;
    }
}