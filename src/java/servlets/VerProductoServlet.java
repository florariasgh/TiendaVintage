/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Consulta;
import modelo.FormaDePago;
import modelo.GestorDB;
import modelo.Producto;
import modelo.Venta;

/**
 *
 * @author arias
 */
@WebServlet(name = "VerProductoServlet", urlPatterns = {"/VerProductoServlet"})
public class VerProductoServlet extends HttpServlet {

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
        GestorDB g = new GestorDB();
        String id = (String) request.getParameter("id");
        
        Producto p = g.obtenerProducto(Integer.parseInt(id));
        request.setAttribute("producto", p);
        
        ArrayList<Consulta> consultas = g.obtenerConsultas(p.getId());
        request.setAttribute("consultas", consultas);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/verProducto.jsp");
        rd.forward(request, response);
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
        int idProducto = Integer.parseInt((String) request.getParameter("txtId"));
        int idUsuario = (Integer) request.getSession().getAttribute("usuario");
        String consulta = (String) request.getParameter("consulta");
        
        Producto p = g.obtenerProducto(idProducto);
        java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Consulta c = new Consulta(0, now, consulta, g.obtenerUsuario(idUsuario), p.getUsuario(), p);
        
        g.insertarConsulta(c);
        //RequestDispatcher rd = getServletContext().getRequestDispatcher("/VerProductoServlet?id=" + idProducto);
        //rd.forward(request, response);
        response.sendRedirect("/TiendaVintage/VerProductoServlet?id=" + idProducto);
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
