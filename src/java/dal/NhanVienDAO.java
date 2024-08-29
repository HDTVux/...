package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.NhanVien;

public class NhanVienDAO extends DBContext {

    public List<NhanVien> getAll() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<NhanVien> list = new ArrayList<>();
        try {
            String strSelect = "SELECT * FROM NhanVien";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                int maNhanVien = rs.getInt("MaNhanVien");
                String ten = rs.getString("Ten");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                Date ngayThangNamSinh = rs.getDate("NgayThangNamSinh");
                String queQuan = rs.getString("QueQuan");
                String chucVu = rs.getString("ChucVu");
                int luong = rs.getInt("Luong");
                NhanVien nv = new NhanVien(maNhanVien, ten, gioiTinh, ngayThangNamSinh, queQuan, chucVu, luong);
                list.add(nv);
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

    public List<NhanVien> searchUsers(String searchQuery) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<NhanVien> list = new ArrayList<>();
        try {
            String strSearch = "SELECT * FROM NhanVien WHERE MaNhanVien LIKE ? OR Ten LIKE ? OR ChucVu LIKE ?";
            stm = connection.prepareStatement(strSearch);
            String queryParam = "%" + searchQuery + "%";
            stm.setString(1, queryParam);
            stm.setString(2, queryParam);
            stm.setString(3, queryParam);
            rs = stm.executeQuery();
            while (rs.next()) {
                int maNhanVien = rs.getInt("MaNhanVien");
                String ten = rs.getString("Ten");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                Date ngayThangNamSinh = rs.getDate("NgayThangNamSinh");
                String queQuan = rs.getString("QueQuan");
                String chucVu = rs.getString("ChucVu");
                int luong = rs.getInt("Luong");
                NhanVien nv = new NhanVien(maNhanVien, ten, gioiTinh, ngayThangNamSinh, queQuan, chucVu, luong);
                list.add(nv);
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

    public void addNewUser(NhanVien nhanVien) {
        PreparedStatement stm = null;
        try {
            String strInsert = "INSERT INTO NhanVien (Ten, GioiTinh, NgayThangNamSinh, QueQuan, ChucVu, Luong) VALUES (?, ?, ?, ?, ?, ?)";
            stm = connection.prepareStatement(strInsert);
            stm.setString(1, nhanVien.getTen());
            stm.setBoolean(2, nhanVien.isGioiTinh());
            stm.setDate(3, new java.sql.Date(nhanVien.getNgayThangNamSinh().getTime()));
            stm.setString(4, nhanVien.getQueQuan());
            stm.setString(5, nhanVien.getChucVu());
            stm.setInt(6, nhanVien.getLuong());
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

    public void deleteUserById(int maNhanVien) {
        PreparedStatement stm = null;
        try {
            String strDelete = "DELETE FROM NhanVien WHERE MaNhanVien = ?";
            stm = connection.prepareStatement(strDelete);
            stm.setInt(1, maNhanVien);
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
    
        public void deleteNhanVienPhongBan(int maNhanVien) {
        PreparedStatement stm = null;
        try {
            String strDelete = "DELETE FROM PhongBan_NhanVien WHERE MaNhanVien = ?";
            stm = connection.prepareStatement(strDelete);
            stm.setInt(1, maNhanVien);
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

    public boolean checkIdExists(int maNhanVien) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String strSelect = "SELECT * FROM NhanVien WHERE MaNhanVien = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, maNhanVien);
            rs = stm.executeQuery();
            return rs.next(); // Return true if ResultSet has any rows, indicating maNhanVien exists
        } catch (SQLException e) {
            System.out.println(e);
            return false; // Return false on error or if maNhanVien does not exist
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
    }

    public NhanVien getNhanVienById(int maNhanVien) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        NhanVien nhanVien = null;
        try {
            String strSelect = "SELECT * FROM NhanVien WHERE MaNhanVien = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, maNhanVien);
            rs = stm.executeQuery();
            if (rs.next()) {
                String ten = rs.getString("Ten");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                Date ngayThangNamSinh = rs.getDate("NgayThangNamSinh");
                String queQuan = rs.getString("QueQuan");
                String chucVu = rs.getString("ChucVu");
                int luong = rs.getInt("Luong");
                nhanVien = new NhanVien(maNhanVien, ten, gioiTinh, ngayThangNamSinh, queQuan, chucVu, luong);
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
        return nhanVien;
    }

    public void editUser(NhanVien nhanVien) {
        PreparedStatement stm = null;
        try {
            String strUpdate = "UPDATE NhanVien SET Ten=?, GioiTinh=?, NgayThangNamSinh=?, QueQuan=?, ChucVu=?, Luong=? WHERE MaNhanVien=?";
            stm = connection.prepareStatement(strUpdate);
            stm.setString(1, nhanVien.getTen());
            stm.setBoolean(2, nhanVien.isGioiTinh());
            stm.setDate(3, new java.sql.Date(nhanVien.getNgayThangNamSinh().getTime()));
            stm.setString(4, nhanVien.getQueQuan());
            stm.setString(5, nhanVien.getChucVu());
            stm.setInt(6, nhanVien.getLuong());
            stm.setInt(7, nhanVien.getMaNhanVien());
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
      public boolean addNhanVienToPhongBan(int maPhongBan, int maNhanVien) {
    PreparedStatement stm = null;
    boolean result = false;
    
    try {
        // Check if the association already exists
        String checkQuery = "SELECT COUNT(*) AS count FROM PhongBan_NhanVien WHERE MaPhongBan = ? AND MaNhanVien = ?";
        stm = connection.prepareStatement(checkQuery);
        stm.setInt(1, maPhongBan);
        stm.setInt(2, maNhanVien);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            int count = rs.getInt("count");
            if (count > 0) {
                return true;
            }
        }
        
        // If not exists, then insert
        String insertQuery = "INSERT INTO PhongBan_NhanVien (MaPhongBan, MaNhanVien) VALUES (?, ?)";
        stm = connection.prepareStatement(insertQuery);
        stm.setInt(1, maPhongBan);
        stm.setInt(2, maNhanVien);
        
        int rowsAffected = stm.executeUpdate();
        if (rowsAffected > 0) {
            result = true;
        }
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
    
    return result;
}
    
    public static void main(String[] args) {
        System.out.println(new NhanVienDAO().getNhanVienById(1));
    }
}
