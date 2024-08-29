package control;

import dal.NhanVienDAO;
import dal.PhongBanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.NhanVien;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.PhongBan;

public class NhanVienServlet extends HttpServlet {

    private boolean checkSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("account") == null) {
            response.sendRedirect("login.jsp");
            return false;
        }
        return true;
    }

    protected String defaultDoGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NhanVienDAO dao = new NhanVienDAO();
        //get list nhan vien
        String searchQuery = request.getParameter("search");
        List<NhanVien> list;
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            list = dao.searchUsers(searchQuery);
        } else {
            list = dao.getAll(); // Fetch all employees if no search query
        }
        //get list phong ban
        List<PhongBan> phongBanList = new PhongBanDAO().getNhanVienPhongBan();
        request.setAttribute("phongBanList", phongBanList);

        request.setAttribute("ndata", list);
        return "QuanLy.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!checkSession(request, response)) {
            return;
        }
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action") == null
                ? ""
                : request.getParameter("action");
        String url = "QuanLy.jsp";
        switch (action) {
            case "edit":
                url = editDoGet(request);
                break;
            default:
                url = defaultDoGet(request, response);
                break;
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!checkSession(request, response)) {
            return;
        }
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            // Xử lý thêm nhân viên
            String ten = request.getParameter("ten");
            boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
            String ngayThangNamSinhStr = request.getParameter("ngayThangNamSinh");
            Date ngayThangNamSinh = null;

            // Check if ngayThangNamSinhStr is not null or empty before parsing
            if (ngayThangNamSinhStr != null && !ngayThangNamSinhStr.isEmpty()) {
                try {
                    ngayThangNamSinh = new SimpleDateFormat("yyyy-MM-dd").parse(ngayThangNamSinhStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                    // Handle parsing exception (e.g., inform user, log error)
                }
            }

            String queQuan = request.getParameter("queQuan");
            String chucVu = request.getParameter("chucVu");
            int luong = Integer.parseInt(request.getParameter("luong"));

            NhanVien nhanVien = new NhanVien(0, ten, gioiTinh, ngayThangNamSinh, queQuan, chucVu, luong);
            NhanVienDAO dao = new NhanVienDAO();
            dao.addNewUser(nhanVien);
        } else if ("delete".equals(action)) {
            // Xử lý xóa nhân viên
            int maNhanVien = Integer.parseInt(request.getParameter("maNhanVien"));
            NhanVienDAO dao = new NhanVienDAO();
            dao.deleteNhanVienPhongBan(maNhanVien);
            dao.deleteUserById(maNhanVien);
        } else if ("deletelink".equals(action)) {
            int maNhanVien = Integer.parseInt(request.getParameter("maNhanVien"));
            NhanVienDAO dao = new NhanVienDAO();
            dao.deleteNhanVienPhongBan(maNhanVien);
        } else if ("edit".equals(action)) {
            // Xử lý chỉnh sửa thông tin nhân viên
            String maNhanVienStr = request.getParameter("MaNhanVien");
            String ten = request.getParameter("Ten");
            boolean gioiTinh = Boolean.parseBoolean(request.getParameter("GioiTinh"));
            String ngayThangNamSinhStr = request.getParameter("NgayThangNamSinh");
            Date ngayThangNamSinh = null;
            if (ngayThangNamSinhStr != null && !ngayThangNamSinhStr.isEmpty()) {
                try {
                    ngayThangNamSinh = new SimpleDateFormat("yyyy-MM-dd").parse(ngayThangNamSinhStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                    // Xử lý ngoại lệ (ví dụ: thông báo lỗi cho người dùng)
                }
            }
            String queQuan = request.getParameter("QueQuan");
            String chucVu = request.getParameter("ChucVu");
            int luong = 0; // Giá trị mặc định hoặc không hợp lệ

            String luongStr = request.getParameter("Luong");
            if (luongStr != null && !luongStr.isEmpty()) {
                try {
                    luong = Integer.parseInt(luongStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    // Xử lý ngoại lệ khi không thể chuyển đổi thành số nguyên
                }
            }

            if (maNhanVienStr != null && !maNhanVienStr.isEmpty()) {
                try {
                    int maNhanVien = Integer.parseInt(maNhanVienStr);
                    NhanVien nhanVien = new NhanVien(maNhanVien, ten, gioiTinh, ngayThangNamSinh, queQuan, chucVu, luong);
                    NhanVienDAO dao = new NhanVienDAO();
                    dao.editUser(nhanVien);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    // Xử lý ngoại lệ khi không thể chuyển đổi thành số nguyên
                }
            }
        } else if ("link".equals(action)) {
            // Xử lý liên kết nhân viên với phòng ban
            try {
                int maPhongBan = Integer.parseInt(request.getParameter("maPhongBan"));
                int maNhanVien = Integer.parseInt(request.getParameter("maNhanVien"));

                if (maPhongBan > 0 && maNhanVien > 0) {
                    NhanVienDAO dao = new NhanVienDAO();
                    dao.addNhanVienToPhongBan(maPhongBan, maNhanVien);
                } else {
                    System.out.println("Invalid maPhongBan or maNhanVien.");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else if ("addPhongBan".equals(action)) {
            // Xử lý xóa nhân viên
            int maPhongBan = Integer.parseInt(request.getParameter("maPhongBan"));
            String tenPhongBan = request.getParameter("tenPhongBan");
            PhongBan phongban = new PhongBan(maPhongBan, tenPhongBan);
            PhongBanDAO dao = new PhongBanDAO();
            dao.addNewPhongBan(phongban);

        }
        response.sendRedirect("nhanvienservlet");
    }

    private String editDoGet(HttpServletRequest request) {
        int maNhanVien = Integer.parseInt(request.getParameter("maNhanVien"));
        NhanVienDAO dao = new NhanVienDAO();
        NhanVien nhanVien = dao.getNhanVienById(maNhanVien);
        String urlReturn = "QuanLy.jsp";
        if (nhanVien != null) {
            request.setAttribute("nhanVien", nhanVien);
            urlReturn = "edit.jsp";
        }
        return urlReturn;
    }

}
