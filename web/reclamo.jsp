<%-- 
    Document   : reclamo
    Created on : 01/12/2021, 15:15:55
    Author     : arias
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@ include file="components/meta.jsp" %>     
<!-- BODY -->
<%@ include file="components/header.jsp" %>    
   <div class="container p-3">
        <div class="row">
            <div class="col-md-12">
                <form method="POST" action="/TiendaVintage/ReclamoServlet">
                   <h1>Reclamar compra</h1>
                   <div class="card" style="width: 25rem;">
                        <input type="hidden" name="id" value="${compra.id}" />
                        <img src="http://127.0.0.1:8887/${compra.producto.nombreFoto}" class="card-img-top" alt="...">
                        <div class="card-body">
                          <h5 class="card-title">${compra.producto.nombre}</h5>
                          <p class="card-text">${compra.producto.descripcion}</p>
                        </div>
                   </div>
                   <div class="padding">
                    <div class="row">
                        <div class="col-sm-6">      
                            <br />
                            <div class="form-group">
                                <p>Ingrese el reclamo</p>
                                <textarea name="reclamo" cols="30" rows="5" class="form-control"></textarea>
                            </div>

                            <div class="form-group"> <button type="submit" class="btn btn-dark">Enviar</button> </div>
                        </div>
                    </div>
                </div>
               </form>
           </div>
        </div>
    </div>
</body>
<%@ include file="components/footer.jsp" %>
