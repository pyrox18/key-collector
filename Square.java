/**
 * A square that serves as a platform of where several types of piece is located
 * (players, keys and chest).
 * 
 * @author  Muhammad Faishal Dzaky (1141326988) 
 */

import java.awt.Point;

public class Square{
    /**
     * The position of square in the game board.
     */
    private Point position;

    /**
     * The list of players that are occupying the square.
     */
    private Player[] players;

    /**
     * The special piece that is occupying the square. 
     */
    private SpecialPiece specialPiece;

    /**
     * Constructor for the Square class.
     * Sets the position of the squares on the game board.
     * 
     * @author Faishal
     * @param x the X coordinate of the square on the game board.
     * @param y the Y coordinate of the square on the game board.
     */
    public Square(int x, int y) {
        position = new Point(x, y);
    }

    /**
     * To know wether the square is occupied by players or not. 
     * 
     * @author Faishal
     * @return a boolean - true if one player or more is occupying the square. 
     */
    public boolean isPlayerSpawn() {
        return players.size() > 0;
    }

    /**
     * Gets the special piece that occupying the square.
     * 
     * @author Faishal
     * @return the special piece that occupying the square.
     */
    public SpecialPiece getSpecialPiece() {
        return specialPiece;
    }

    /**
     * Sets the special piece that is going to occupy the square.
     * Special pieces are keys and chest.
     * 
     * @author Faishal
     * @param specialPiece the special piece that is going to occupy the square.
     * @return a boolean - true for setting the special piece onto the square.
     */
    public boolean setSpecialPiece(SpecialPiece specialPiece) {
        this.specialPiece = specialPiece;
        return true;
    }

    /**
     * Gets the position of the square in the game board.
     * 
     * @author Faishal
     * @return Point of the square's position in the game board.
     */
    public Point getPosition() {
        return position;
    }
}
