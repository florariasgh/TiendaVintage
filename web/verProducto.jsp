<%-- 
    Document   : verProducto
    Created on : 17/11/2021, 14:55:42
    Author     : arias
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="components/meta.jsp" %>     
<!-- BODY -->
<%@ include file="components/header.jsp" %>     

<div class="container p-5 section-products">
        <div class="row justify-content-center text-center">
            <!-- Single Product -->
            <div class="col-md-6 col-lg-4 col-xl-3">
                <div id="product-1" class="single-product">
                    <div class="part-1" style="background: url('http://127.0.0.1:8887/${producto.nombreFoto}') no-repeat center;">

                    </div>
                    <div class="part-2">
                        <h3 class="product-title">${producto.nombre}</h3>
                        <h3 class="product-price">$ <fmt:formatNumber pattern="#,##0" value="${producto.precio}" /></h3>
                        <h3 class="product-descripcion">${producto.descripcion}</h3>
                        <h3 class="product-genero">${producto.genero.nombre}</h3>
                        <h3 class="product-usuario"><a href="/TiendaVintage/PerfilUsuarioServlet?id=${producto.usuario.id}">${producto.usuario.nombre}</a></h3>
                        <c:if test="${not empty usuario}">
                            <a href="/TiendaVintage/ComprarServlet?id=${producto.id}" ><button type="button" class="btn btn-dark">Comprar</button></a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
</div>


<!-- Main Body -->
<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-5 col-md-6 col-12 pb-4">
                <h1>Consultas</h1>
                <c:forEach var="consulta" items="${consultas}">
                    <div class="comment mt-4 col-md-12 text-justify float-left"> <img src="https://i.imgur.com/yTFUilP.jpg" alt="" class="rounded-circle" width="40" height="40">
                        <h4>${consulta.comprador.nombre} ${consulta.comprador.apellido}</h4> <span>- ${consulta.fecha}</span> <br>
                        <p>${consulta.consulta}</p>
                    </div>
                    <c:if test="${not empty consulta.respuesta}">
                        <div class="comment col-md-11 offset-md-1 text-justify float-left">
                            <i>Respuesta</i> <span>- ${consulta.respuesta.fecha}</span> <br>
                            <p>${consulta.respuesta.consulta}</p>
                        </div>
                    </c:if>
                    <c:if test="${producto.usuario.id == usuario && empty consulta.respuesta}">
                        <div class="comment col-md-11 offset-md-1 text-justify float-left">
                            <a href="/TiendaVintage/ResponderConsultaServlet?id=${consulta.id}">
                                <button class="btn btn-primary" type="button">Responder</button>
                            </a>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <c:if test="${not empty usuario && producto.usuario.id != usuario}">
                <div class="col-lg-4 col-md-5 col-sm-4 offset-md-1 offset-sm-1 col-12 mt-4">
                    <form method="POST" action="/TiendaVintage/VerProductoServlet" >
                        <input type="hidden" name="txtId" value="${producto.id}" />            
                        <div class="form-group">
                            <h4>Hacer una consulta</h4> <label for="message">Consulta</label> <textarea name="consulta" cols="30" rows="5" class="form-control"></textarea>
                        </div>

                        <div class="form-group"> <button type="submit" class="btn btn-dark">Realizar consulta</button> </div>
                    </form>
                </div>
            </c:if>
        </div>
    </div>
</section>                    
</body>
<%@ include file="components/footer.jsp" %>
