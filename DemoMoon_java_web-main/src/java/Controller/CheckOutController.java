/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.Servlet.*;
import DAO.BanhDAO;
import DTO.DetailDTO;
import DTO.OrderDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {

    private static final String ERROR = "Cart.jsp";
    private static final String SUCCESS = "Home.jsp";

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
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String url = ERROR;
//        int voucher = 0;
        BanhDAO dao = new BanhDAO();
        HttpSession session = request.getSession();
        ArrayList<DetailDTO> list = (ArrayList<DetailDTO>) session.getAttribute("CART");
        try {
            String check = request.getParameter("voucherID");
            if (!check.isEmpty()) {
//                voucher = Integer.parseInt(check);
            }
            if (list != null) {
                float total = Float.parseFloat(request.getParameter("total"));
                int UserID = Integer.parseInt(request.getParameter("userID"));
                if (dao.insertOrder(new OrderDTO(0, format.format(date), total, UserID)) != -1) {
                    int OrderID = dao.getOrderID();
                    for (DetailDTO detailDTO : list) {
                        detailDTO.setOrderID(OrderID);
                        if (dao.insertDetail(detailDTO) != -1) { 
                            int CurQuantity = dao.getQuantityOfBanh(detailDTO.getBook().getBanhID());
                            if (CurQuantity > 0) {
                                int BanhID = detailDTO.getBook().getBanhID();
                                int Quantity = CurQuantity - detailDTO.getQuantity();
                                int result = dao.updateQuantityOfBanh(BanhID, Quantity);
                            }
                        }
                    }
//                    dao.deleteVoucher(voucher);
                    session.setAttribute("listb", dao.getListBanh());
                    session.setAttribute("listc", dao.getListCategory());
//                    session.setAttribute("VOU", dao.getAllDiscount());
                    session.setAttribute("CART", null);
                    session.removeAttribute("CART");
                    request.setAttribute("OK", "Thank you for your purchase!");
                    url = SUCCESS;

                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
