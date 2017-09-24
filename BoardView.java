import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
     * A boolean that indicates whether the current game has ended or not.
     */
    private boolean gameEnded;

    /**
     * Constructor for the BoardView class.
     * Sets up a 9x9 GridLayout to house the square buttons, and adds those buttons.
     * 
     * @author Haryz
     */
    public BoardView() {
        super(new GridLayout(9, 9));
        gameEnded = false;
        board = Board.getInstance();
        buttons = new SquareButton[9][9];
        board.initializeBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Square square = board.getSquare(i, j);
                buttons[i][j] = new SquareButton(square);
                buttons[i][j].addActionListener(new SquareClickListener(this, buttons[i][j]));
                buttons[i][j].setOpaque(true);
                if (i == 4 && j == 4) {
                    square.getSpecialPiece().addListener(new ChestUnlockListener(this));
                }
                add(buttons[i][j]);
            }
        }
        refreshBoard();
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
        if (!gameEnded) {
            board = Board.getInstance();
            ArrayList<Point> validPoints = board.getCurrentPlayer().getValidMoveLocations();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    SquareButton button = buttons[i][j];
                    button.setIcon(button.getSquare().getTopMostImageIcon());
                    if (validPoints.contains(new Point(i, j))) {
                        button.setBackground(Color.GREEN);
                    }
                    else if (button.getSquare().equals(board.getCurrentPlayer().getSquare())) {
                        button.setBackground(Color.ORANGE);
                    }
                    else {
                        button.setBackground(null);
                    }
                }
            }
        }
        else {
            endOfGame();
        }

        return true;
    }

    /**
     * Repaints the buttons of the board and detaches click listeners when the game ends.
     * 
     * @author Haryz
     */
    public void endOfGame() {
        gameEnded = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                SquareButton button = buttons[i][j];
                button.setIcon(button.getSquare().getTopMostImageIcon());
                button.setBackground(Color.GREEN);
                for (ActionListener al : button.getActionListeners()) {
                    button.removeActionListener(al);
                }
            }
        }
    }

    /**
     * Gets the boolean that indicates if the game has ended.
     * 
     * @return The gameEnded attribute
     */
    public boolean isGameEnded() {
        return gameEnded;
    }

    /**
     * Resets the board view to use new square models.
     * Used when the square models are recreated due to a new game being initiated.
     */
    public void resetBoardView() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                buttons[i][j].setSquare(board.getSquare(i, j));
            }
        }
        refreshBoard();
    }
}