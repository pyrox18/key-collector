import java.awt.*;

import javax.swing.*;

/**
 * A JPanel that houses buttons to start a new game, save a game and load a game.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */
public class Toolbar extends JPanel {
    /**
     * The board view.
     */
    BoardView boardview;

    /**
     * The instance of the game board.
     */
    Board board;

    /**
     * Constructor for the Toolbar class.
     * Sets the layout and attributes, and adds the respective buttons with their listeners.
     * 
     * @author  Ramanan
     */
    public Toolbar (BoardView boardview) {
        super(new FlowLayout());
        this.boardview = boardview;
        board = Board.getInstance();

        JButton newGameButton = new JButton("New Game");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        newGameButton.addActionListener(new NewGameClickListener(boardview));
        saveButton.addActionListener(new SaveListener(boardview));
        loadButton.addActionListener(new LoadListener(boardview));

        add(newGameButton);
        add(saveButton);
        add(loadButton);
    }
}