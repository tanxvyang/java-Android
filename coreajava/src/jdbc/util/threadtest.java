package jdbc.util;

import javax.swing.*;

public class threadtest extends Thread {

    JTextField inputSQL;
    JButton execute;
    JButton empty;
    JTextArea text;



    @Override
    public void run() {
       text.setText(inputSQL.getText());
    }
}

