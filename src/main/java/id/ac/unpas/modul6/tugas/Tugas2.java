package id.ac.unpas.modul6.tugas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tugas2 {
    static double storedValue;

    public static void main (String[] args) {
        JFrame frame = new JFrame("Celsius Converted");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        frame.setLayout(new GridLayout(3, 2));

        JLabel convertedLabel = new JLabel("Celsius:");
        JTextField inputCelsius = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        JLabel resultFLabel = new JLabel();

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    storedValue = Double.parseDouble(inputCelsius.getText());

                    resultFLabel.setText(String.valueOf((storedValue * 9 / 5) + 32) + "°F");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Input harus berupa angka!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        };

        JButton convertedBtn = new JButton("Konversi");
        convertedBtn.addActionListener(listener);

        frame.add(convertedLabel);
        frame.add(inputCelsius);
        frame.add(resultLabel);
        frame.add(resultFLabel);
        frame.add(convertedBtn);

        frame.setVisible(true);
    }
}
