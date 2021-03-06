package app19;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class SwingTimerDemo extends JFrame {
    String[] questions = {"What is the largest mammal?",
            "Who is the current prime minister of Japan?",
            "Who invented the Internet?",
            "What is the smallest country in the world?",
            "What is the biggest city in America?",
            "Finished. Please remain seated"};

    JLabel questionLabel = new JLabel("Click Start to begin");
    JTextField answer = new JTextField();
    JButton startButton = new JButton("Start");
    JComboBox answerBox = new JComboBox();
    int counter = 0;
    Timer timer = new Timer(10000, new MyTimerActionListener());

    public SwingTimerDemo(String title) {
        super(title);
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(questionLabel, BorderLayout.WEST);
        questionLabel.setPreferredSize(new Dimension(300, 15));
        answer.setPreferredSize(new Dimension(100, 15));
        this.getContentPane().add(answer, BorderLayout.CENTER);
        this.getContentPane().add(startButton, BorderLayout.EAST);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((JButton) e.getSource()).setEnabled(false);
                timer.start();
            }
        });
        this.getContentPane().add(answerBox, BorderLayout.SOUTH);
        this.startButton.setFocusable(true);
        this.pack();
        this.setVisible(true);
    }

    private String getNextQuestion() {
        return questions[counter++];
    }

    private static void constructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingTimerDemo frame = new SwingTimerDemo(
                "Swing Timer Demo");
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();
            }
        });
    }

    class MyTimerActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Toolkit.getDefaultToolkit().beep();
            if (counter > 0) {
                answerBox.addItem(answer.getText());
                answer.setText("");
            }
            String nextQuestion = getNextQuestion();
            questionLabel.setText(nextQuestion);
            if (counter == questions.length) {
                timer.stop();
            }
        }
    }
}