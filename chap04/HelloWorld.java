import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorld {
  public static void main(String[] args) {
    // unsafe Swing threading
    JFrame frame = new JFrame();
    frame.setTitle("Hello World");
    frame.setSize(new Dimension(200, 100));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new JLabel("Hello World"));
    frame.setVisible(true);
  }
}
