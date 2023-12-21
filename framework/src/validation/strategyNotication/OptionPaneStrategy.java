package validation.strategyNotication;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OptionPaneStrategy extends JFrame implements IStrategyNotication{
    public static final String DIALOG_TITLE = "Register Status";

    public OptionPaneStrategy(){

    }
    
    @Override
    public void display(String message) {
        JOptionPane.showMessageDialog(this, message, DIALOG_TITLE, JOptionPane.INFORMATION_MESSAGE);
    }
}