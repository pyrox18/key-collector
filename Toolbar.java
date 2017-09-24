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

        JButton saveButton = new JButton("save");
        JButton loadButton = new JButton("load");

        saveButton.addActionListener(new SaveListener(boardview));
        loadButton.addActionListener(new LoadListener(boardview));

        add(saveButton);
        add(loadButton);
    }
}