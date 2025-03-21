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
import model.Request;
import java.sql.Date;

/**
 *
 * @author admi
 */
public class UpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId")); // Sửa lại
        RequestDAO dao = new RequestDAO();
        Request requestDetail = dao.getRequestById(requestId);
        request.setAttribute("requestDetail", requestDetail);
        request.getRequestDispatcher("Check.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String reason = request.getParameter("reason");
        Date dateFrom = Date.valueOf(request.getParameter("dateFrom"));
        Date dateTo = Date.valueOf(request.getParameter("dateTo"));

        Request updatedRequest = new Request();
        updatedRequest.setId(id);
        updatedRequest.setDateFrom(dateFrom);
        updatedRequest.setDateTo(dateTo);
        updatedRequest.setReason(reason);

        RequestDAO dao = new RequestDAO();
        int result = dao.updateRequest(updatedRequest);

        if (result > 0) {
            response.sendRedirect("RequestList"); // Quay về danh sách sau khi update thành công
        } else {
            request.setAttribute("error", "Cập nhật thất bại. Vui lòng thử lại.");
            request.getRequestDispatcher("Check.jsp").forward(request, response);
        }
    }

}
