package control;

import dal.PhongBanDAO;
import model.PhongBan;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class PhongBanServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PhongBanDAO phongBanDAO = new PhongBanDAO();
        List<PhongBan> phongBanList = phongBanDAO.getNhanVienPhongBan();
        request.setAttribute("phongBanList", phongBanList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("QuanLy.jsp");
        dispatcher.forward(request, response);
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

}
