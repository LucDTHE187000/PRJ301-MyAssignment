/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Request;

/**
 *
 * @author admi
 */
public class RequestController extends HttpServlet {

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
            out.println("<title>Servlet RequestController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RequestController at " + request.getContextPath() + "</h1>");
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
            response.sendRedirect("login.jsp");
            return;
        }
        String action = request.getParameter("action");
        if ("listRequests".equals(action)) {
            RequestDAO dao = new RequestDAO();
            List<Request> list = dao.getRequestsByEmployeeId(account.getEmployeeId());
            request.setAttribute("listRequests", list);
            switch (account.getRoleId()) {
                case 1:
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                   break;
                case 2:
                    request.getRequestDispatcher("manager.jsp").forward(request, response);
                  break;
                case 3:
                    request.getRequestDispatcher("employee1.jsp").forward(request, response);
                    break;
            }
        }
        return;
    }

    // Các xử lý khác nếu cần
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
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            response.sendRedirect("login");
        }
        String DateFrom = request.getParameter("fromDate");
        String DateTo = request.getParameter("toDate");
        String Reason = request.getParameter("reason");
        List<String> error = new ArrayList<>();
        if (Reason == null || DateTo == null || DateFrom == null) {
            error.add("Dữ liệu không hợp lệ, nhập lại.");
            SendirecttoRoleHome(account.getRoleId(), request, response);
        }

        Date datefrom = Date.valueOf(DateFrom);
        Date dateto = Date.valueOf(DateTo);
        Date now = Date.valueOf(LocalDate.now());

        if (datefrom.before(dateto)) {
            error.add("Ngày bắt đầu nghỉ không thể sau ngày kết thúc nghỉ.");
        }
        if (dateto.before(now)) {
            error.add("Ngày kết thúc nghỉ không thể là quá khứ.");
        }
        if (datefrom.before(now)) {
            error.add("Ngày bắt đầu nghỉ không thể là quá khứ.");
        }

        if (!error.isEmpty()) {

            request.setAttribute("error", error);
            SendirecttoRoleHome(account.getRoleId(), request, response);
            return;
        } else {
            RequestDAO RequestDAO = new RequestDAO();
            Request re = new Request(0, account.getEmployeeId(), dateto, datefrom, now, Reason, "Inprogress");
            RequestDAO.insert(re);
            request.getRequestDispatcher("Welcome").forward(request, response);
        }
        String id = request.getParameter("id");
    String fromDate = request.getParameter("fromDate");
    String toDate = request.getParameter("toDate");
    String reason = request.getParameter("reason");
    
    if (id != null && fromDate != null && toDate != null && reason != null) {
        RequestDAO requestDAO = new RequestDAO();
        boolean success = requestDAO.updateRequest(Integer.parseInt(id), fromDate, toDate, reason);
        
        if (success) {
            request.setAttribute("message", "Cập nhật đơn thành công!");
        } else {
            request.setAttribute("message", "Cập nhật thất bại, vui lòng thử lại!");
        }
    }
    
    request.getRequestDispatcher("welcome.jsp").forward(request, response);
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

    private void SendirecttoRoleHome(int Id, HttpServletRequest request, HttpServletResponse response) {
        switch (Id) {
            case 1:
            {
                try {
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                } catch (ServletException ex) {
                    Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case 2:
            {
                try {
                    request.getRequestDispatcher("manager.jsp").forward(request, response);
                } catch (ServletException ex) {
                    Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case 3:
            {
                try {
                    request.getRequestDispatcher("employee1.jsp").forward(request, response);
                } catch (ServletException ex) {
                    Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            default:
            {
                try {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } catch (ServletException ex) {
                    Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

        }
    }
}
