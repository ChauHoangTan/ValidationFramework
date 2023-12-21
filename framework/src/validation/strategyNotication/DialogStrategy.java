package validation.strategyNotication;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DialogStrategy extends JFrame implements IStrategyNotication {

    public DialogStrategy() { //may be it just used for show error =))))

    }

    @Override
    public void display(String message) {
        JDialog dialog = new JDialog();
        JTextArea textArea = new JTextArea(message);
        
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        dialog.getContentPane().add(scrollPane);
        
        dialog.setSize(480, 360);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}
