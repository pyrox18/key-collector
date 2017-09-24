import java.awt.event.*;

/**
 * A button click listener for saving a game.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */
public class SaveListener implements ActionListener {
    /**
     * The game's board instance.
     */
    private Board board;

    /**
     * Constructor for the LoadListener class.
     * Sets the board reference for the class.
     * 
     * @author  Ramanan
     */
    public SaveListener() {
        board = Board.getInstance();
    }

    /**
     * Saves the board's state when the button is clicked.
     * 
     * @author  Ramanan
     */
    public void actionPerformed(ActionEvent evt) {
        board.save();
    }
}