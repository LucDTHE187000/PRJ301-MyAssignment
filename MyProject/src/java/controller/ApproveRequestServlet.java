/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.RequestDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admi
 */
public class ApproveRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("welcome.jsp"); // Redirect to welcome.jsp if accessed via GET
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String action = request.getParameter("action");
        String message;

        try {
            int requestId = Integer.parseInt(idParam);
            RequestDAO requestDAO = new RequestDAO();

            if ("approve".equals(action)) {
                boolean success = requestDAO.updateRequestStatus(requestId, "Approved");
                message = success ? "Đơn đã được duyệt thành công!" : "Lỗi: Không thể duyệt đơn.";
            } else if ("reject".equals(action)) {
                boolean success = requestDAO.updateRequestStatus(requestId, "Rejected");
                message = success ? "Đơn đã bị từ chối!" : "Lỗi: Không thể từ chối đơn.";
            } else {
                message = "Hành động không hợp lệ.";
            }
        } catch (NumberFormatException e) {
            message = "Lỗi: ID không hợp lệ.";
        }

        // Set the message as a request attribute and forward back to Requestservlet
        request.setAttribute("message", message);
        request.getRequestDispatcher("Requestservlet").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet to approve or reject leave requests";
    }
}