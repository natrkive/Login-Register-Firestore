import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Tes3 {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        JLabel lbl1 = new JLabel();
        lbl1.setText("MyApp Latihan 1");
        frame.add(lbl1, BorderLayout.NORTH);

        JLabel lbl2 = new JLabel();
        lbl2.setText("Masukkan nama anda :");
        
        JLabel lbl3 = new JLabel();

        JTextField txtNama = new JTextField("", 4);
        txtNama.requestFocus();

        JButton btn1 = new JButton("Proses");

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // Put constraints on different buttons
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lbl2, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(txtNama, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(btn1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel.add(lbl3, gbc);


        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl3.setText("Hi,"+txtNama.getText());
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}