package id.ac.unpas.modul6.latihan.event_handling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContohMouseListener {
    public static void main(String[] args) {
        // 1. Buat Frame
        JFrame frame = new JFrame("Contoh MouseListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // 2. Buat Komponen (Event Source)
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(200, 200));

        // 3. Buat Event Listener (menggunakan MouseAdapter)
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Saat mouse masuk, ubah warna jadi biru
                panel.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Saat mouse keluar, kembalikan warna
                panel.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Saat diklik, tampilkan koordinat klik
                System.out.println("Mouse diklik di: x=" + e.getX() + ", y=" + e.getY());
            }
        };

        // 4. Daftarkan listener ke source
        panel.addMouseListener(adapter);

        // 5. Tambahkan komponen ke frame dan tampilkan
        frame.add(panel);
        frame.setVisible(true);
    }
}
