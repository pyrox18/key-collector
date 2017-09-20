/**
 * A class used to categorise keys and chests, where there can only be one of those at a time
 * on a certain square.
 * 
 * @author      Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */

 public abstract class SpecialPiece extends Piece {
    /**
     * Constructor for the SpecialPiece class.
     * Sets the square that the special piece is initially on, and provides the piece's icon path.
     * 
     * @author Haryz
     * @param  square The square that the special piece is initially on.
     * @param  iconPath The path to the icon for the piece.
     */
    public SpecialPiece(Square square, String iconPath) {
        super(square, iconPath);
    }

    /**
     * Method for a player to interact with the special piece.
     * 
     * @author Haryz
     * @param  player The player that is interacting with the special piece.
     * @return a boolean
     */
    public abstract boolean interact(Player player);
}