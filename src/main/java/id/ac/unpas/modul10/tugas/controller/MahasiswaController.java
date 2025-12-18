package id.ac.unpas.modul10.tugas.controller;

import id.ac.unpas.modul10.tugas.Mahasiswa;
import id.ac.unpas.modul10.tugas.model.MahasiswaModel;
import id.ac.unpas.modul10.tugas.view.MahasiswaView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.util.List;

public class MahasiswaController {
    private MahasiswaModel model;
    private MahasiswaView view;

    public MahasiswaController(MahasiswaModel model, MahasiswaView view) {
        this.model = model;
        this.view = view;

        refreshTable();

        // Daftarkan Action Listeners dari View
        view.addSimpanListener(e -> simpanData());
        view.addEditListener(e -> ubahData());
        view.addHapusListener(e -> hapusData());
        view.addClearListener(e -> view.clearForm());
        view.addCariListener(e -> cariData());

        // Listener Tabel
        view.addTableMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = view.getTable().getSelectedRow();
                String nama = view.getTable().getValueAt(row, 1).toString();
                String nim = view.getTable().getValueAt(row, 2).toString();
                String jurusan = view.getTable().getValueAt(row, 3).toString();

                view.setForm(nama, nim, jurusan);
            }
        });
    }

    private void refreshTable() {
        List<Mahasiswa> list = model.getAllMahasiswa();
        view.setTableData(list);
    }

    private void simpanData() {
        String nama = view.getNama();
        String nim = view.getNim();
        String jurusan = view.getJurusan();

        // Validasi (Latihan 2)
        if (nama.trim().isEmpty() || nim.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
            return;
        }

        // Cek Duplikasi (Latihan 4)
        if (model.isNimExist(nim)) {
            JOptionPane.showMessageDialog(view, "NIM Sudah Ada!");
            return;
        }

        try {
            Mahasiswa mhs = new Mahasiswa(nama, nim, jurusan);
            model.insertMahasiswa(mhs);
            JOptionPane.showMessageDialog(view, "Berhasil Simpan");
            refreshTable();
            view.clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Gagal Simpan: " + e.getMessage());
        }
    }

    private void ubahData() {
        String nama = view.getNama();
        String nim = view.getNim();
        String jurusan = view.getJurusan();

        try {
            Mahasiswa mhs = new Mahasiswa(nama, nim, jurusan);
            model.updateMahasiswa(mhs);
            JOptionPane.showMessageDialog(view, "Berhasil Edit");
            refreshTable();
            view.clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Gagal Edit: " + e.getMessage());
        }
    }

    private void hapusData() {
        String nim = view.getNim();
        int confirm = JOptionPane.showConfirmDialog(view, "Yakin hapus?");
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                model.deleteMahasiswa(nim);
                JOptionPane.showMessageDialog(view, "Berhasil Hapus");
                refreshTable();
                view.clearForm();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(view, "Gagal Hapus: " + e.getMessage());
            }
        }
    }

    private void cariData() {
        String keyword = view.getKeyword();
        try {
            List<Mahasiswa> list = model.cariData(keyword);
            view.setTableData(list);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Gagal Mencari Data: " + e.getMessage());
        }
    }
}