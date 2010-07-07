import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HelloBack {
  public static void main(String[] args) {
    // unsafe Swing threading
    JFrame frame = new JFrame();
    frame.setTitle("Hello World");
    frame.setSize(new Dimension(200, 140));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final JTextField textField = new JTextField();
    textField.setColumns(20);
    final JLabel label = new JLabel();
    JButton button = new JButton("Say 'Hello'");
    frame.setLayout(new GridLayout(3,1));
    frame.add(textField);
    frame.add(button);
    frame.add(label);

    button.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent evt) {
        String text = textField.getText().trim();
        if(text.length() == 0) return;
        label.setText("Hello "+ text +"!");
      }
    });

    frame.setVisible(true);
  }
}
