package id.ac.unpas.modul5.tugas;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing .SwingUtilities;

/**
 *
 * @author wdgus
 */
public class Tugas1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setLayout(new BorderLayout());

                JLabel label = new JLabel("Label ada di Atas (NORTH)");
                JButton southButton = new JButton("Tombol ada di Bawah (SOUTH)");
                JButton westButton = new JButton("WEST");
                JButton eastButton = new JButton("EAST");
                JButton centerButton = new JButton("CENTER");

                southButton.addActionListener(e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });

                westButton.addActionListener(e -> {
                    label.setText("Tombol di WEST diklik!");
                });

                eastButton.addActionListener(e -> {
                    label.setText("Tombol di EAST diklik!");
                });

                centerButton.addActionListener(e -> {
                    label.setText("Tombol di CENTER diklik!");
                });

                frame.add(label, BorderLayout.NORTH);
                frame.add(southButton, BorderLayout.SOUTH);
                frame.add(westButton, BorderLayout.WEST);
                frame.add(eastButton, BorderLayout.EAST);
                frame.add(centerButton, BorderLayout.CENTER);

                frame.setVisible(true);
            }
        });
    }
}
