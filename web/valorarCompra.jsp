<%-- 
    Document   : valorarCompra
    Created on : 12/11/2021, 20:12:47
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
                <form method="POST" action="/TiendaVintage/ValorarCompraServlet">
                   <h1>Calificar compra</h1>
                   <div class="card" style="width: 25rem;">
                        <input type="hidden" name="id" value="${compra.producto.id}" />
                        <img src="http://127.0.0.1:8887/${compra.producto.nombreFoto}" class="card-img-top" alt="...">
                        <div class="card-body">
                          <h5 class="card-title">${compra.producto.nombre}</h5>
                          <p class="card-text">${compra.producto.descripcion}</p>
                        </div>
                        <ul class="list-group list-group-flush">
                          <li class="list-group-item">$ ${compra.producto.precio}</li>
                          <li class="list-group-item">${compra.producto.usuario.nombre} ${compra.producto.usuario.apellido}</li>
                        </ul>
                   </div>
                   <div class="padding">
                    <div class="row">
                        <div class="col-sm-6">
                            <input type="hidden" name="txtId" value="${compra.id}" />            
                            <div class="form-group">
                                <select name="cboValoracion" >
                                    <option value='5'>⭐⭐⭐⭐⭐</option>
                                    <option value='4'>⭐⭐⭐⭐</option>
                                    <option value='3'>⭐⭐⭐</option>
                                    <option value='2'>⭐⭐</option>
                                    <option value='1'>⭐</option>
                                </select>
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
