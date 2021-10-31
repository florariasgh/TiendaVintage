/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Producto;
import modelo.Talle;
import modelo.Categoria;
import modelo.Genero;
import modelo.Usuario;
import modelo.GestorDB;

/**
 *
 * @author arias
 */
@WebServlet(name = "AltaProductoServlet", urlPatterns = {"/AltaProductoServlet"})
@MultipartConfig 
public class AltaProductoServlet extends HttpServlet {

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
            out.println("<title>Servlet AltaProductoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaProductoServlet at " + request.getContextPath() + "</h1>");
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
        GestorDB g = new GestorDB();	

        request.setAttribute("listacategorias", g.obtenerCategorias());
        request.setAttribute("listageneros", g.obtenerGeneros());
        request.setAttribute("listatalles", g.obtenerTalles());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaProducto.jsp");
                rd.forward(request, response);
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

            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String precio = request.getParameter("precio");
            
            int idCategoria = Integer.parseInt(request.getParameter("cboCategoria"));
            Categoria categoria = new Categoria();
            categoria.setId(idCategoria);
            
            int idGenero = Integer.parseInt(request.getParameter("cboGenero"));
            Genero genero = new Genero(); 
            genero.setId(idGenero);
            
            int idTalle = Integer.parseInt(request.getParameter("cboTalle"));
            Talle talle = new Talle(); 
            talle.setId(idTalle);
                
            Part filePart = request.getPart("fileFoto");
            String nombreFoto = filePart.getSubmittedFileName();
            
            for (Part part : request.getParts()) {
              if (part.getName().equals("fileFoto"))
                  part.write(nombreFoto);
            }
            
            Producto producto = new Producto(); 
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(Float.parseFloat(precio));
            producto.setCategoria(categoria);
            producto.setGenero(genero);
            producto.setTalle(talle);
            producto.setUsuario(g.obtenerUsuario((Integer) request.getSession().getAttribute("usuario")));
            
            g.insertarProducto(producto);
            
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/verProductos.jsp");
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
