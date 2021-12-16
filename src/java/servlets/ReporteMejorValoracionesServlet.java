/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestorDB;
import modelo.ReporteStockItem;

/**
 *
 * @author arias
 */
@WebServlet(name = "ReporteMejorValoracionesServlet", urlPatterns = {"/ReporteMejorValoracionesServlet"})
public class ReporteMejorValoracionesServlet extends HttpServlet {

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
        ArrayList<ReporteVendedoresItem> items = null;
        items = g.obtenerReporteVendedores(false, null, null);
        request.setAttribute("items", items);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/reporteValoraciones.jsp");
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
        java.sql.Date fechaDesde = null;
        java.sql.Date fechaHasta = null;
        
        ArrayList<ReporteVendedoresItem> items = null;
        
        String desde = (String) request.getParameter("desde");
        String hasta = (String) request.getParameter("hasta");
        try {
            fechaDesde = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(desde).getTime());
            fechaHasta = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(hasta).getTime());
        } catch (ParseException ex) {
            request.setAttribute("error", "Las fechas ingresadas no son correctas.");
            desde = "";
            hasta = "";
            fechaDesde = null;
        }
        
        items = g.obtenerReporteVendedores(false, fechaDesde, fechaHasta);
        request.setAttribute("initialDesde", desde);
        request.setAttribute("initialHasta", hasta);
        
        request.setAttribute("items", items);
        if (items.isEmpty()) {
            request.setAttribute("error", "No existen ventas en el periodo ingresado.");
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/reporteValoraciones.jsp");
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
