/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.FormaDePago;
import modelo.GestorDB;
import modelo.Producto;
import modelo.Venta;

/**
 *
 * @author arias
 */
@WebServlet(name = "ComprarServlet", urlPatterns = {"/ComprarServlet"})
public class ComprarServlet extends HttpServlet {

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
        if (request.getSession().getAttribute("usuario") != null) {
            GestorDB g = new GestorDB();
            String id = (String) request.getParameter("id");

            Producto p = g.obtenerProducto(Integer.parseInt(id));
            request.setAttribute("producto", p);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/comprarProducto.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
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
        GestorDB g = new GestorDB();
        int id = Integer.parseInt((String) request.getParameter("id"));
        int idUsuario = (Integer) request.getSession().getAttribute("usuario");
        
        Producto p = g.obtenerProducto(id);
        request.setAttribute("producto", p);
        
        p.setDisponible(false);
        g.actualizarProducto(p);
        java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        g.insertarVenta(new Venta(0, now, p, new FormaDePago(5,""), g.obtenerUsuario(idUsuario), p.getUsuario(), false, null));
         
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/compraRealizada.jsp");
        rd.forward(request, response);
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
