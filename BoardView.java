import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A JPanel class that provides a view for the game board.
 * 
 * @author  Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */
public class BoardView extends JPanel {
    /**
     * The model instance for the game board.
     */
    private Board board;

    /**
     * Constructor for the BoardView class.
     * Sets up a 9x9 GridLayout to house the square buttons, and adds those buttons.
     * 
     * @author Haryz
     */
    public BoardView() {
        super(new GridLayout(9, 9));
        board = Board.getInstance();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // TODO: Replace this with SquareButton once ready
                add(new JButton(i + ", " + j));
            }
        }
    }
}