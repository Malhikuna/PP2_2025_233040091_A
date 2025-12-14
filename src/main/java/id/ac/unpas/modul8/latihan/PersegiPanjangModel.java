package id.ac.unpas.modul8.latihan;

public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;

    public void hitungLuas()
    {
        this.luas = this.panjang * this.lebar;
    }

    public void setPanjang(double panjang)
    {
        this.panjang = panjang;
    }

    public void setLebar(double lebar)
    {
        this.lebar = lebar;
    }

    public double getLuas()
    {
        return luas;
    }
}
