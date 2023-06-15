import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Tes2 {
    public static void main(String args[]) {
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JButton button1 = new JButton("Proses");
        JTextPane txt1 = new JTextPane();

        JTextField textBox = new JTextField("Hi");
        frame.getContentPane().add(textBox, BorderLayout.NORTH);
        frame.getContentPane().add(button1, BorderLayout.CENTER);
        frame.getContentPane().add(txt1, BorderLayout.SOUTH);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, textBox.getText());
                txt1.setText("Hi, "+textBox.getText());
            }
        });
        frame.setVisible(true);
    }
}