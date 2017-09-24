import java.awt.event.*;

/**
 * 
 */
public class LoadListener implements ActionListener {

    private Board board;
    
    private BoardView boardView;

    public LoadListener (BoardView boardView) {
        this.boardView = boardView;
    }

    public void actionPerformed(ActionEvent evt) {
        board = Board.getInstance();
        board.load();
        boardView.refreshBoard();
    }
}