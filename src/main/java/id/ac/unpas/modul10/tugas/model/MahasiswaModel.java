package id.ac.unpas.modul10.tugas.model;

import id.ac.unpas.modul10.tugas.KoneksiDB;
import id.ac.unpas.modul10.tugas.Mahasiswa;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaModel {
    DefaultTableModel model;

    // Method untuk mengambil semua data (READ)
    public List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> listMhs = new ArrayList<>();
        try {
            Connection conn = KoneksiDB.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM mahasiswa");

            while (res.next()) {
                listMhs.add(new Mahasiswa(
                        res.getString("nama"),
                        res.getString("nim"),
                        res.getString("jurusan")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMhs;
    }

    // Method INSERT (CREATE)
    public void insertMahasiswa(Mahasiswa mhs) throws SQLException {
        Connection conn = KoneksiDB.configDB();
        String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, mhs.getNama());
        pst.setString(2, mhs.getNim());
        pst.setString(3, mhs.getJurusan());
        pst.execute();
    }

    // Method UPDATE
    public void updateMahasiswa(Mahasiswa mhs) throws SQLException {
        Connection conn = KoneksiDB.configDB();
        String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, mhs.getNama());
        pst.setString(2, mhs.getJurusan());
        pst.setString(3, mhs.getNim());
        pst.executeUpdate();
    }

    // Method DELETE
    public void deleteMahasiswa(String nim) throws SQLException {
        Connection conn = KoneksiDB.configDB();
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nim);
        pst.execute();
    }

    // Validasi Cek NIM
    public boolean isNimExist(String nim) {
        boolean exist = false;
        try {
            Connection conn = KoneksiDB.configDB();
            String sql = "SELECT nim FROM mahasiswa WHERE nim = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nim);
            ResultSet res = pst.executeQuery();
            if (res.next()) exist = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exist;
    }

    public List<Mahasiswa> cariData(String keyword) throws SQLException {
        List<Mahasiswa> list = new ArrayList<>();
        Connection conn = KoneksiDB.configDB();
        String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + keyword + "%");
        ResultSet res = pst.executeQuery();

        while (res.next()) {
            list.add(new Mahasiswa(
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("jurusan")
            ));
        }
        return list;
    }
}
