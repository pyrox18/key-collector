import java.awt.BorderLayout;
import java.awt.GridLayout;

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
     * A 2-dimensional array of square buttons that are present on the board.
     */
    private SquareButton[][] buttons;

    /**
     * Constructor for the BoardView class.
     * Sets up a 9x9 GridLayout to house the square buttons, and adds those buttons.
     * 
     * @author Haryz
     */
    public BoardView() {
        super(new GridLayout(9, 9));
        board = Board.getInstance();
        buttons = new SquareButton[9][9];
        board.initializeBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Square square = board.getSquare(i, j);
                buttons[i][j] = new SquareButton(square);
                buttons[i][j].addActionListener(new SquareClickListener(this, buttons[i][j]));
                add(buttons[i][j]);
            }
        }
    }

    /**
     * Gets a square button on the board.
     * 
     * @author Haryz
     * @param  x The x-coordinate of the button.
     * @param  y The y-coordinate of the button.
     * @return A square button.
     */
    public SquareButton getSquareButton(int x, int y) {
        return buttons[x][y];
    }

    /**
     * Repaints the icons on the board according to their new locations.
     * 
     * @author Haryz
     * @return a boolean - true if the refresh is successful
     */
    public boolean refreshBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                SquareButton button = buttons[i][j];
                button.setIcon(button.getSquare().getTopMostImageIcon());
            }
        }

        return true;
    }
}