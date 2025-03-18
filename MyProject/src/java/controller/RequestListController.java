/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.RequestDAO;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import model.Account;
import model.Request;
import model.RequestDTO;

/**
 *
 * @author admi
 */
public class RequestListController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RequestListController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RequestListController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      HttpSession session = request.getSession();
    Account account = (Account) session.getAttribute("account");
    if (account == null) {
        response.sendRedirect("login");
        return;
    }
   // String action = request.getParameter("action");
    //if ("listRequests".equals(action)) {
        // Gọi DAO lấy danh sách đơn
       /* RequestDAO requestDAO = new RequestDAO();
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        List<Request> list = requestDAO.getRequestsByEmployeeId(employeeId);
        */
        // Gán vào attribute để JSP đọc
        //request.setAttribute("Request", list);
        
        // Forward về đúng trang JSP (ví dụ welcome.jsp hoặc employee1.jsp tuỳ phân quyền)
       // request.getRequestDispatcher("employee1.jsp").forward(request, response);
        //return;
    // Sử dụng hàm DAO đã có để lấy danh sách đơn của nhân viên đang đăng nhập.
       RequestDAO dao = new RequestDAO();
       List<RequestDTO> requestList = dao.getRequestsByManagerId(account.getEmployeeId());
       request.setAttribute("requestList", requestList);
       request.getRequestDispatcher("list.jsp").forward(request, response);
       
       
}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
