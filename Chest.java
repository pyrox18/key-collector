/**
 * A chest piece that can be unlocked by players who have picked up all available keys.
 * 
 * @author      Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */

public class Chest extends SpecialPiece {
    /**
     * The number of keys required to unlock the chest.
     */
    private int keysRequired;

    /**
     * Constructor for the Chest class.
     * Sets the number of keys required to unlock the chest.
     * Also sets the square that the chest is initially on.
     * 
     * @author Haryz
     * @param  square The square that the chest is initially on.
     * @param  keysRequired The number of keys required to unlock the chest.
     */
    public Chest(Square square, int keysRequired) {
        super(square);
        this.keysRequired = keysRequired;
    }

    /**
     * Attempt to unlock the chest with a certain number of keys.
     * 
     * @author Haryz
     * @param  numOfKeys The number of keys used to unlock the chest.
     */
    public boolean unlockChest(int numOfKeys) {
        return numOfKeys == keysRequired;
    }

    /**
     * Method for a player to interact with the special piece.
     * 
     * @author Haryz
     * @param  player The player that is interacting with the special piece.
     * @return a boolean - true if the chest is unlocked, else false
     */
    @Override
    public boolean interact(Player player) {
        boolean isChestUnlocked = this.unlockChest(player.getNumberOfKeys());
        return isChestUnlocked;
    }
}