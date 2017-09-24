import java.awt.*;

import javax.swing.*;

/**
 * Toolbar
 */
public class Toolbar extends JPanel {

    BoardView boardview;

    Board board;

    public Toolbar (BoardView boardview) {
        super(new FlowLayout());
        this.boardview = boardview;
        board = Board.getInstance();

        JButton newGameButton = new JButton("New Game");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        saveButton.addActionListener(new SaveListener(boardview));
        loadButton.addActionListener(new LoadListener(boardview));

        add(newGameButton);
        add(saveButton);
        add(loadButton);
    }
}