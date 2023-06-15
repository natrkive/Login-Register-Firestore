import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Persegi {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        JLabel lbl1 = new JLabel();
        lbl1.setText("MyApp Latihan 2");
        frame.add(lbl1, BorderLayout.NORTH);

        // Variabel

        JLabel lblPanjang = new JLabel();
        lblPanjang.setText("Panjang");

        JLabel lblLebar = new JLabel();
        lblLebar.setText("Lebar");

        JLabel lbl3 = new JLabel();

        JTextField txtPanjang = new JTextField("", 4);
        txtPanjang.requestFocus();

        JTextField txtLebar = new JTextField("", 4);

        JButton btn1 = new JButton("Hitung Luas");

        // Panel

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // Put constraints on different buttons
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        panel.add(lblPanjang, gbc);
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        panel.add(lblLebar, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        panel.add(txtPanjang, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        panel.add(txtLebar, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 8;
        panel.add(btn1, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 8;
        panel.add(lbl3, gbc);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl3.setText("Luas Persegi Panjang adalah "
                        + (Integer.parseInt(txtPanjang.getText()) * Integer.parseInt(txtLebar.getText())));
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}