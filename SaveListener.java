import java.awt.event.*;

/**
 * SaveListenr
 */
public class SaveListener implements ActionListener {

    private Board board;

    private BoardView boardView;

    public SaveListener (BoardView boardView) {
        this.boardView = boardView;
    }

    public void actionPerformed(ActionEvent evt) {
        board = Board.getInstance();
        board.save();
    }
}