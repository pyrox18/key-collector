import java.util.concurrent.TimeUnit; // TODO: Remove

/**
 * A listener that acts when the board's chest is unlocked.
 * Uses the observer design pattern in conjunction with the Chest class.
 * 
 * @author  Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */
public class ChestUnlockListener implements CustomListener {
    /**
     * The game's board view.
     */
    private BoardView boardView;

    /**
     * Constructor for the ChestUnlockListener class.
     * Sets a reference to the game board view for the class's methods to act on.
     * 
     * @author Haryz
     * @param  boardView The game board view.
     */
    public ChestUnlockListener(BoardView boardView) {
        this.boardView = boardView;
    }

    /**
     * Calls the board view's end of game method when the chest is unlocked.
     * 
     * @author Haryz
     */
    @Override
    public void update() {
        try {
            TimeUnit.MILLISECONDS.sleep(200); // TODO: Remove this workaround
        } catch (Exception e) {
            System.err.println(e);
        }
        boardView.endOfGame();
    }
}