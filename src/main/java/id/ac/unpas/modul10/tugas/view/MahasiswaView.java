package id.ac.unpas.modul10.tugas.view;

import id.ac.unpas.modul10.tugas.Mahasiswa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;

public class MahasiswaView extends JFrame {
    private JTextField txtNama, txtNIM, txtJurusan, txtCari;
    private JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    private JTable tableMahasiswa;
    private DefaultTableModel model;

    public MahasiswaView() {
        setTitle("Aplikasi CRUD Mahasiswa (MVC)");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel Form
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);

        panelForm.add(new JLabel("NIM:"));
        txtNIM = new JTextField();
        panelForm.add(txtNIM);

        panelForm.add(new JLabel("Jurusan:"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);

        // Panel Tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");

        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

        JPanel panelInput = new JPanel(new BorderLayout());
        panelInput.add(panelForm, BorderLayout.CENTER);
        panelInput.add(panelTombol, BorderLayout.SOUTH);

        // Panel Cari
        JPanel panelCari = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelCari.setBorder(BorderFactory.createTitledBorder("Pencarian Data"));
        txtCari = new JTextField(20);
        btnCari = new JButton("Cari");

        panelCari.add(new JLabel("Cari Nama:"));
        panelCari.add(txtCari);
        panelCari.add(btnCari);

        // Gabung Panel
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelInput, BorderLayout.CENTER);
        panelAtas.add(panelCari, BorderLayout.SOUTH);
        add(panelAtas, BorderLayout.NORTH);

        // Tabel
        model = new DefaultTableModel(new Object[]{"No", "Nama", "NIM", "Jurusan"}, 0);
        tableMahasiswa = new JTable(model);
        add(new JScrollPane(tableMahasiswa), BorderLayout.CENTER);
    }

    public String getNama() { return txtNama.getText(); }
    public String getNim() { return txtNIM.getText(); }
    public String getJurusan() { return txtJurusan.getText(); }
    public String getKeyword() { return txtCari.getText(); }

    // Mengisi input ke Form
    public void setForm(String nama, String nim, String jurusan) {
        txtNama.setText(nama);
        txtNIM.setText(nim);
        txtJurusan.setText(jurusan);
    }

    // Membersihkan Form
    public void clearForm() {
        txtNama.setText("");
        txtNIM.setText("");
        txtJurusan.setText("");
    }

    // Update data tabel
    public void setTableData(List<Mahasiswa> listMhs) {
        model.setRowCount(0); // Reset
        int no = 1;
        for (Mahasiswa mhs : listMhs) {
            model.addRow(new Object[]{no++, mhs.getNama(), mhs.getNim(), mhs.getJurusan()});
        }
    }

    // Event Listener
    public void addSimpanListener(ActionListener listener) { btnSimpan.addActionListener(listener); }
    public void addEditListener(ActionListener listener) { btnEdit.addActionListener(listener); }
    public void addHapusListener(ActionListener listener) { btnHapus.addActionListener(listener); }
    public void addClearListener(ActionListener listener) { btnClear.addActionListener(listener); }
    public void addCariListener(ActionListener listener) { btnCari.addActionListener(listener); }
    public void addTableMouseListener(MouseAdapter adapter) { tableMahasiswa.addMouseListener(adapter); }

    // Ambil data baris tabel
    public JTable getTable() { return tableMahasiswa; }
}
