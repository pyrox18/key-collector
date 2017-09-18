import javax.swing.*;

/**
 * A class for creating buttons used as squares in the board.
 * 
 * @author  Ramanan 
 */
public class SquareButton extends JButton {

    /**
     * The square the button is assigned to.
     */
    private Square square;

    /**
     * Constructor for the SquareButton class.
     * Sets the square the button is assigned to.
     * 
     * @author  Ramanan
     * @param   square The square that the button needs to be assigned to.
     */
    public SquareButton (Square square) {
        this.square = square;
    }
}

