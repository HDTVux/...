package control;

import dal.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if ("logout".equals(action)) {
                // Xử lý đăng xuất
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.invalidate();
                }
                response.sendRedirect("login.jsp");
            } else {
                // Xử lý đăng nhập
                String user = request.getParameter("username");
                String pass = request.getParameter("password");
                LoginDAO o = new LoginDAO();
                Account a = o.checkLogin(user, pass);
                if (a == null) {
                    request.setAttribute("mess", "Wrong username or password!!!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    // Tạo session mới
                    HttpSession session = request.getSession();
                    session.setAttribute("account", a);
                    response.sendRedirect("nhanvienservlet");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
