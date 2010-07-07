import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class JavaFrame {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable(){
      public void run() {
        JFrame frame = buildUI();
        frame.setVisible(true);
      }
    });
  }

  private static JFrame buildUI() {
    JFrame frame = new JFrame("JavaFrame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(
      new GridLayout(3,1)
    );
    final JTextField input = new JTextField(20);
    final JTextField output = new JTextField(20);
    output.setEditable(false);
    JButton button = new JButton("Click me!");
    button.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        output.setText(input.getText());
      }
    });
    frame.getContentPane().add(input);
    frame.getContentPane().add(button);
    frame.getContentPane().add(output);
    frame.pack();
    return frame;
  }
}