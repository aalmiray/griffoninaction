import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class JavaQuiz {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable(){
      public void run() {
        JavaQuiz javaQuiz = new JavaQuiz();
        javaQuiz.buildUI();
        javaQuiz.setupActions();
        javaQuiz.frame.setVisible(true);
      }
    });
  }

  private JFrame frame;
  private ButtonGroup group;
  private JButton button;

  private void buildUI() {
    frame = new JFrame("JavaQuiz");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BorderLayout());

    JLabel question = new JLabel("Who is known as 'the father of Java' ?");
    frame.getContentPane().add(question, BorderLayout.NORTH);
    JPanel answerPanel = new JPanel(new GridLayout(0,1));
    frame.getContentPane().add(answerPanel, BorderLayout.CENTER);
    String[] answers = {"Larry Wall", "James Gosling", "Guido van Rossum"};
    group = new ButtonGroup();
    for(int i = 0; i < answers.length; i++) {
       JRadioButton option = new JRadioButton((i+1)+" "+answers[i]);
       option.setMnemonic(i+1+48);
       option.setActionCommand(answers[i]);
       group.add(option);
       answerPanel.add(option);
    }
    button = new JButton("Get the answer!");
    frame.getContentPane().add(button, BorderLayout.SOUTH);
    frame.pack();
  }

  private void setupActions() {
    button.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        ButtonModel selection = group.getSelection();
        if(selection != null) {
          String answer = selection.getActionCommand();
          if(answer.equals("James Gosling")) {
            JOptionPane.showMessageDialog(frame,
             "You guessed right!",
             "JavaQuiz - Answer",
             JOptionPane.INFORMATION_MESSAGE);
          } else {
           JOptionPane.showMessageDialog(frame,
             "You guessed wrong. Please try again!",
             "JavaQuiz - Answer",
             JOptionPane.ERROR_MESSAGE);
          }
        } else {
          JOptionPane.showMessageDialog(frame,
            "You have not made a selection yet!",
            "JavaQuiz - Answer",
            JOptionPane.WARNING_MESSAGE);
        }
      }
    });
  }
}