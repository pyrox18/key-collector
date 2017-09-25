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
     * The board view.
     */
    private BoardView boardView;

    /**
     * Constructor for the LoadListener class.
     * Sets the board reference for the class.
     * 
     * @author  Ramanan
     */
    public SaveListener(BoardView boardView) {
        board = Board.getInstance();
        this.boardView = boardView;
    }

    /**
     * Saves the board's state when the button is clicked.
     * 
     * @author  Ramanan
     */
    public void actionPerformed(ActionEvent evt) {
        if (!boardView.isGameEnded()) {
            board.save();
        }
    }
}