package model;

import java.util.List;

public class PhongBan {
    private int maPhongBan;
    private String tenPhongBan;
    private List<NhanVien> nhanVienList;

    public PhongBan() {
    }

    public PhongBan(int maPhongBan, String tenPhongBan) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
    }

    public PhongBan(int maPhongBan, String tenPhongBan, List<NhanVien> nhanVienList) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.nhanVienList = nhanVienList;
    }

    public int getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(int maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public List<NhanVien> getNhanVienList() {
        return nhanVienList;
    }

    public void setNhanVienList(List<NhanVien> nhanVienList) {
        this.nhanVienList = nhanVienList;
    }

    @Override
    public String toString() {
        return "PhongBan{" + "maPhongBan=" + maPhongBan + ", tenPhongBan=" + tenPhongBan + ", nhanVienList=" + nhanVienList + '}';
    }
    
}
