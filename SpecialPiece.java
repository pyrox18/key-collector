import java.util.ArrayList;

/**
 * A class used to categorise keys and chests, where there can only be one of those at a time
 * on a certain square.
 * Uses the observer design pattern.
 * 
 * @author      Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */

 public abstract class SpecialPiece extends Piece {
    /**
     * A list of listeners attached to the special piece.
     */
    private ArrayList<CustomListener> listeners;

    /**
     * Constructor for the SpecialPiece class.
     * Sets the square that the special piece is initially on, and provides the piece's icon path.
     * Also initialises the list of listeners.
     * 
     * @author Haryz
     * @param  square The square that the special piece is initially on.
     * @param  iconPath The path to the icon for the piece.
     */
    public SpecialPiece(Square square, String iconPath) {
        super(square, iconPath);
        listeners = new ArrayList<CustomListener>();
    }

    /**
     * Method for a player to interact with the special piece.
     * 
     * @author Haryz
     * @param  player The player that is interacting with the special piece.
     * @return a boolean
     */
    public abstract boolean interact(Player player);

    /**
     * Adds a listener for the chest.
     * 
     * @author Haryz
     */
    public void addListener(CustomListener listener) {
        listeners.add(listener);
    }

    /**
     * Removes a listener for the chest.
     * 
     * @author Haryz
     */
    public void removeListener(CustomListener listener) {
        listeners.remove(listener);
    }

    /**
     * Notifies all listeners when an event occurs.
     * 
     * @author Haryz
     */
    public void notifyListeners() {
        for (CustomListener listener : listeners) {
            listener.update();
        }
    }
}