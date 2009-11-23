import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class SimpleFileViewer extends JFrame {
  public static void main(String[] args) {
    SimpleFileViewer viewer = new SimpleFileViewer();
  }

  private JTextArea textArea;
  private static final String EOL = System.getProperty("line.separator");

  public SimpleFileViewer() {
    super("SimpleFileViewer");
    buildUI();
    setVisible(true);
  }

  private void buildUI() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton button = new JButton("Click to select a file");
    textArea = new JTextArea();
    textArea.setEditable(false);
    textArea.setLineWrap(true);
    button.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        selectFile();
      }
    });
    getContentPane().setLayout( new BorderLayout() );
    getContentPane().add(button, BorderLayout.NORTH);
    getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
    pack();
    setSize( new Dimension(320, 240) );
  }

  private void selectFile() {
    JFileChooser fileChooser = new JFileChooser();
    int answer = fileChooser.showOpenDialog(this);
    if( answer == JFileChooser.APPROVE_OPTION ) {
      readFile(fileChooser.getSelectedFile());
    }
  }

  private void readFile( File file ) {
    try {
      StringBuilder text = new StringBuilder();
      BufferedReader in = new BufferedReader(new FileReader(file));
      String line = null;
      while( (line = in.readLine()) != null ) {
        text.append(line).append(EOL);
      }
      textArea.setText(text.toString());
      textArea.setCaretPosition(0);
    } catch( IOException ioe ) {
      ioe.printStackTrace();
    }
  }
}