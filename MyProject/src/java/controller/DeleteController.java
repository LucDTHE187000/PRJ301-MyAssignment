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

/**
 *
 * @author admi
 */
public class DeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Trả về thông báo lỗi nếu ai đó cố gắng sử dụng GET để xóa
        request.setAttribute("error", "Phương thức GET không được hỗ trợ cho việc xóa đơn.");
        request.getRequestDispatcher("Check.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy tham số "id" từ biểu mẫu
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int requestId = Integer.parseInt(idParam);
                RequestDAO dao = new RequestDAO();
                boolean success = dao.deleteRequest(requestId);
                if (success) {
                    // Chuyển hướng về danh sách đơn nếu xóa thành công
                    response.sendRedirect("RequestList");
                } else {
                    // Chuyển tiếp tới Check.jsp với thông báo lỗi nếu xóa thất bại
                    request.setAttribute("error", "Không thể xóa đơn.");
                    request.getRequestDispatcher("Check.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                // Xử lý lỗi nếu id không phải là số hợp lệ
                request.setAttribute("error", "ID không hợp lệ.");
                request.getRequestDispatcher("Check.jsp").forward(request, response);
            }
        } else {
            // Xử lý lỗi nếu id không được cung cấp
            request.setAttribute("error", "ID không được cung cấp.");
            request.getRequestDispatcher("Check.jsp").forward(request, response);
        }
    }
}