package id.ac.unpas.modul10.tugas;

import id.ac.unpas.modul10.tugas.controller.MahasiswaController;
import id.ac.unpas.modul10.tugas.model.MahasiswaModel;
import id.ac.unpas.modul10.tugas.view.MahasiswaView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Inisialisasi
            MahasiswaModel model = new MahasiswaModel();
            MahasiswaView view = new MahasiswaView();

            new MahasiswaController(model, view);

            view.setVisible(true);
        });
    }
}
