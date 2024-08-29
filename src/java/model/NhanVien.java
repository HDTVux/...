package model;

import java.util.Date;

public class NhanVien {
    private int maNhanVien;
    private String ten;
    private boolean gioiTinh;
    private Date ngayThangNamSinh;
    private String queQuan;
    private String chucVu;
    private int luong;
    public NhanVien() {
    }

    public NhanVien(int maNhanVien, String ten, boolean gioiTinh, Date ngayThangNamSinh, String queQuan, String chucVu, int luong) {
        this.maNhanVien = maNhanVien;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngayThangNamSinh = ngayThangNamSinh;
        this.queQuan = queQuan;
        this.chucVu = chucVu;
        this.luong = luong;
    }

    // Getter và setter cho maNhanVien
    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    // Getter và setter cho ten
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    // Getter và setter cho gioiTinh
    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    // Getter và setter cho ngayThangNamSinh
    public Date getNgayThangNamSinh() {
        return ngayThangNamSinh;
    }

    public void setNgayThangNamSinh(Date ngayThangNamSinh) {
        this.ngayThangNamSinh = ngayThangNamSinh;
    }

    // Getter và setter cho queQuan
    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    // Getter và setter cho chucVu
    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    // Getter và setter cho luong
    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNhanVien=" + maNhanVien + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", ngayThangNamSinh=" + ngayThangNamSinh + ", queQuan=" + queQuan + ", chucVu=" + chucVu + ", luong=" + luong + '}';
    }
    
    
}
