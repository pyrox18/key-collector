import javax.swing.*;

/**
 * A class for creating buttons used as squares in the board.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 * @author  Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
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
        super();
        this.square = square;
        this.setIcon(square.getTopMostImageIcon());
    }

    /**
     * Gets the square attached to the button.
     * 
     * @author  Haryz
     * @return  The square attribute.
     */
    public Square getSquare() {
        return square;
    }

    /**
     * Sets the square attached to the button.
     * 
     * @author  Haryz
     * @param   square The square to set
     */
    public void setSquare(Square square) {
        this.square = square;
    }
}

