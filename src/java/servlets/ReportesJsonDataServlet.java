/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "ReportesJsonDataServlet", urlPatterns = {"/ReportesJsonDataServlet"})
public class ReportesJsonDataServlet extends HttpServlet {

    public ReportesJsonDataServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        
        GestorDB g = new GestorDB();
        ArrayList<ReporteStockItem> items = null;
        items = g.obtenerReporteStockItems();
        
        Map<String, Integer> itemsPorGenero = new HashMap<String, Integer>();
        for(ReporteStockItem item : items) {
            if (!itemsPorGenero.containsKey(item.getGenero().getNombre())) {
                itemsPorGenero.put(item.getGenero().getNombre(), 1);
            }
            itemsPorGenero.put(item.getGenero().getNombre(), 
                itemsPorGenero.get(item.getGenero().getNombre())+1);
        }

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(itemsPorGenero);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
 
}
