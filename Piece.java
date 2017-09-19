import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * An abstract class that serves as the basis for pieces that are present on the game board
 * (players, keys and chest).
 * 
 * @author  Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */

public abstract class Piece {
    /**
     * The square that the piece is currently on.
     */
    private Square square;

    /**
     * The icon for the piece.
     */
    private ImageIcon icon;

    /**
     * Constructor for the Piece class.
     * Sets the square that the piece is initially on.
     * Sets the icon for the piece.
     * 
     * @author  Haryz
     * @param   square The square that the piece is initially on.
     * @param   iconPath The path to the icon for the piece.
     */
    public Piece(Square square, String iconPath){
        this.square = square;
        icon = ImageIO.read(getClass().getResource(iconPath));
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

    /**
     * Gets the icon for the piece.
     * 
     * @author  Ramanan
     * @return  the icon
     */
    public ImageIcon getIcon () {
        return icon;
    }
}