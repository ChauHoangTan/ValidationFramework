package validation.strategyNotication;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogStrategy extends JFrame implements IStrategyNotication {

    public static final String DIALOG_TITLE = "Register Status";

    public DialogStrategy() {

    }

    @Override
    public void display(String message) {
        JOptionPane.showMessageDialog(this, message, DIALOG_TITLE, JOptionPane.INFORMATION_MESSAGE);
    }

}
