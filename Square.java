import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * A square that serves as a platform of where several types of piece is located
 * (players, keys and chest).
 * 
 * @author  Muhammad Faishal Dzaky (1141326988) 
 * @author  Ramanan R Muralitharan (1141128291)
 */

public class Square{
    /**
     * The position of square in the game board.
     */
    private Point position;

    /**
     * The list of players that are occupying the square.
     */
    private ArrayList<Player> players;

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
        players = new ArrayList<Player>();
        position = new Point(x, y);
    }

    /**
     * To know if the square is spawning point for a player. There are
     * 4 spawning points exist on the board and located at coordinate
     * (0,0),(0,8),(8,0),(8,8).
     * 
     * @author Faishal
     * @return a boolean - true if the square coordinate is at one of the 
     *         spawning point, else, false.
     */
    public boolean isPlayerSpawn() {
        return ( (position.getX() == 0 || position.getX() == 8) && 
                 (position.getY() == 0 || position.getY() == 8) );
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
        return this.specialPiece == specialPiece;
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

    /**
     * Add a player that is going to occupy the square.
     * 
     * @author Faishal
     * @param player the player that is going to occupy the square.
     * @return a boolean - true for adding the player into players array list and
     *         it exist in the players array list.
     */
    public boolean placePlayer(Player player) {
        players.add(player);
        return players.contains(player);
    }

    /**
     * Remove a player from the square.
     * 
     * @author Faishal
     * @param player the player that is going to be removed from the square.
     * @return a boolean - true if the player is exist and removed from player array list,
     *         else, false. 
     */
    public boolean removePlayer(Player player) {
        return players.remove(player);
    }

    /**
     * Get all players that is occupying the square.
     * 
     * @author Faishal
     * @return An array list of player.
     */
    public ArrayList<Player> getAllPlayers() {
        return players;
    }

    /**
     * Gets the icon for the piece on top of the square.
     * If there are players on the square, the method retrieves the icon of the fist player to land in the square.
     * If there are no players, the method retrieves the icon of the special piece on the square.
     * 
     * @author  Ramanan
     * @return  an ImageIcon
     */
    public ImageIcon getTopMostImageIcon() {
        if (!players.isEmpty())
            return players.get(players.size() - 1).getIcon();
        else {
            try {
                return specialPiece.getIcon();          
            } catch (Exception e) {
                return null;
            }
        }
    }
}