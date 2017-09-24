import java.awt.*;

import javax.swing.JButton;

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

        saveButton.addActionListener(new SaveListener());
        load.addActionListener(new LoadListener());

        add(saveButton);
        add(loadButton);
    }
}