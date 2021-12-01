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
@WebServlet(name = "ModificarProductoServlet", urlPatterns = {"/ModificarProductoServlet"})
@MultipartConfig(location="C:\\Users\\arias\\Documents\\TiendaVintageRepositorio")
public class ModificarProductoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
            

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
            String idModificar = (String) request.getParameter("id");

            Producto producto = g.obtenerProducto(Integer.parseInt(idModificar));

            request.setAttribute("id", idModificar);
            request.setAttribute("nombre", producto.getNombre());
            request.setAttribute("idCategoria", producto.getCategoria() .getId());
            request.setAttribute("precio", producto.getPrecio());
            request.setAttribute("descripcion", producto.getDescripcion());
            request.setAttribute("idTalle", producto.getTalle().getId());
            request.setAttribute("idGenero", producto.getGenero().getId());
            request.setAttribute("nombreFoto", producto.getNombreFoto());
            
            request.setAttribute("listacategorias", g.obtenerCategorias());
            request.setAttribute("listageneros", g.obtenerGeneros());
            request.setAttribute("listatalles", g.obtenerTalles());

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarProducto.jsp");
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

            int id = Integer.parseInt(request.getParameter("id"));
            Producto p = g.obtenerProducto(id);
            
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            Float precio = Float.parseFloat(request.getParameter("precio"));
            
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
            
            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setPrecio(precio);
            p.setCategoria(categoria);
            p.setGenero(genero);
            p.setTalle(talle);
            p.setNombreFoto(nombreFoto);
            
            g.modificarProducto(p);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/VerProductosServlet");
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
