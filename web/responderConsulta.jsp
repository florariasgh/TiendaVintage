<%-- 
    Document   : responderConsulta
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
                <form method="POST" action="/TiendaVintage/ResponderConsultaServlet">
                   <h1>Responder consulta</h1>
                   <div class="card" style="width: 25rem;">
                        <input type="hidden" name="id" value="${consulta.producto.id}" />
                        <img src="http://127.0.0.1:8887/${consulta.producto.nombreFoto}" class="card-img-top" alt="...">
                        <div class="card-body">
                          <h5 class="card-title">${consulta.producto.nombre}</h5>
                          <p class="card-text">${consulta.producto.descripcion}</p>
                        </div>
                        <div class="comment mt-4 col-md-12 text-justify float-left"> <img src="https://i.imgur.com/yTFUilP.jpg" alt="" class="rounded-circle" width="40" height="40">
                            <h4>${consulta.comprador.nombre} ${consulta.comprador.apellido}</h4> <span>- ${consulta.fecha}</span> <br>
                            <p>${consulta.consulta}</p>
                        </div>
                   </div>
                   <div class="padding">
                    <div class="row">
                        <div class="col-sm-6">
                            <input type="hidden" name="txtId" value="${consulta.id}" />            
                            <div class="form-group">
                                <textarea name="consulta" cols="30" rows="5" class="form-control"></textarea>
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
