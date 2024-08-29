package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.NhanVien;
import model.PhongBan;

public class PhongBanDAO extends DBContext {

    public List<PhongBan> getNhanVienPhongBan() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<PhongBan> list = new ArrayList<>();
        Map<Integer, PhongBan> phongBanMap = new HashMap<>();

        try {
            String strSelect = "SELECT pb.MaPhongBan, pb.TenPhongBan,nv.MaNhanVien, nv.Ten, nv.ChucVu "
                    + "FROM PhongBan pb "
                    + "LEFT JOIN PhongBan_NhanVien pb_nv ON pb.MaPhongBan = pb_nv.MaPhongBan "
                    + "LEFT JOIN NhanVien nv ON pb_nv.MaNhanVien = nv.MaNhanVien "
                    + "ORDER BY pb.MaPhongBan";

            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();

            while (rs.next()) {
                int maPhongBan = rs.getInt("MaPhongBan");
                String tenPhongBan = rs.getString("TenPhongBan");
                int maNhanVien = rs.getInt("MaNhanVien");
                String tenNhanVien = rs.getString("Ten");
                String chucVu = rs.getString("ChucVu");
                PhongBan pb = phongBanMap.get(maPhongBan);
                if (pb == null) {
                    pb = new PhongBan(maPhongBan, tenPhongBan, new ArrayList<>());
                    phongBanMap.put(maPhongBan, pb);
                    list.add(pb);
                }

                if (tenNhanVien != null) {
                    NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, false, null, null, chucVu, 0);
                    pb.getNhanVienList().add(nv);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return list;
    }

    public void addNewPhongBan(PhongBan phongban) {
        PreparedStatement stm = null;
        try {
            String strInsert = "INSERT INTO PhongBan (MaPhongBan, TenPhongBan) VALUES (?, ?)";
            stm = connection.prepareStatement(strInsert);
            stm.setInt(1, phongban.getMaPhongBan());
            stm.setString(2, phongban.getTenPhongBan());
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

}
