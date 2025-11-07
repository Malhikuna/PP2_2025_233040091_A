package id.ac.unpas.modul6.tugas;

import javax.swing.*;
import java.awt.*;

public class Tugas1 {
    private static JTextField inputBox;

    public static void main(String[] args) {
        /* Init Frame */
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Panel North (Display) */
        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.LIGHT_GRAY);
        northPanel.add(new JLabel("0"));
        frame.add(northPanel, BorderLayout.NORTH);

        /* Panel Center (Button) */
        JPanel centerPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        frame.add(centerPanel, BorderLayout.CENTER);

        String[] num = {
                "", "AC", "%", "/",
                "7", "8", "9", "X",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "", "0", ".", "="
        };

        for (String n : num) {
            JButton btn = new JButton(n);
            btn.setBackground(Color.GRAY);
            btn.setForeground(Color.WHITE);
            btn.setPreferredSize(new Dimension(70, 70));
            centerPanel.add(btn);

            if (
                    n.equalsIgnoreCase("/") ||
                    n.equalsIgnoreCase("X") ||
                    n.equalsIgnoreCase("-") ||
                    n.equalsIgnoreCase("+") ||
                    n.equalsIgnoreCase("=")
            )
                btn.setBackground(Color.ORANGE);
        }

        JPanel equalPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        equalPanel.add(new JButton("0"));
        equalPanel.add(new JButton("="));

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
