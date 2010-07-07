import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class RevisedSimpleFileViewer {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        RevisedSimpleFileViewer viewer = new RevisedSimpleFileViewer();
      }
    });
  }

  private JTextArea textArea;
  private JFrame frame;
  private static final String EOL = System.getProperty("line.separator");

  public RevisedSimpleFileViewer() {
    frame = new JFrame("RevisedSimpleFileViewer");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add(buildUI(), BorderLayout.CENTER);
    frame.pack();
    frame.setSize( new Dimension(320, 240) );
    frame.setVisible(true);
  }

  private JPanel buildUI() {
    JPanel panel = new JPanel(new BorderLayout());
    JButton button = new JButton("Click to select a file");
    textArea = new JTextArea();
    textArea.setEditable(false);
    textArea.setLineWrap(true);
    button.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        selectFile();
      }
    });
    panel.add(button, BorderLayout.NORTH);
    panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
    return panel;
  }

  private void selectFile() {
    JFileChooser fileChooser = new JFileChooser();
    int answer = fileChooser.showOpenDialog(frame);
    if( answer == JFileChooser.APPROVE_OPTION ) {
      readFile(fileChooser.getSelectedFile());
    }
  }

  private void readFile( final File file ) {
    new Thread(new Runnable(){
      public void run() {
        try {
          final StringBuilder text = new StringBuilder();
          BufferedReader in = new BufferedReader(new FileReader(file));
          String line = null;
          while( (line = in.readLine()) != null ) {
           text.append(line).append(EOL);
          }
          SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              textArea.setText(text.toString());
              textArea.setCaretPosition(0);
            }
          });
        } catch( IOException ioe ) {
          ioe.printStackTrace();
        }
      }
    }).start();
  }
}