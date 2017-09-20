/**
 * A key piece that can be picked up by players to unlock the chest.
 * 
 * @author      Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */

public class Key extends SpecialPiece {
    /**
     * The movement strategy tied to the key.
     */
    private MoveStrategy strategy;

    /**
     * Constructor for the Key class.
     * Sets the movement strategy related to the key.
     * Also sets the key's initial square and icon path.
     * 
     * @author Haryz
     * @param  square The square that the key is initially on.
     * @param  iconPath The path to the icon for the piece.
     * @param  strategy The movement strategy related to the key.
     */
    public Key(Square square, String iconPath, MoveStrategy strategy) {
        super(square, iconPath);
        this.strategy = strategy;
    }

    /**
     * Gets the strategy attached to the key.
     * 
     * @author Haryz
     * @return the strategy
     */
    public MoveStrategy getStrategy() {
        return strategy;
    }

    /**
     * Method for a player to interact with the special piece.
     * 
     * @author Haryz
     * @param  player The player that is interacting with the special piece.
     * @return a boolean - true if the player successfully picks up the key, else false
     */
    @Override
    public boolean interact(Player player) {
        return player.pickupKey(this);
    }
}