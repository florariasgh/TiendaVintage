<%-- 
    Document   : misVentas
    Created on : 17/11/2021, 15:35:58
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@ include file="components/meta.jsp" %>     
<!-- BODY -->
<%@ include file="components/header.jsp" %>   
<div class="container mt-5">
<h2>Mis ventas</h2>
    <div class="row d-flex justify-content-center">
        <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Fecha</th>
                            <th scope="col">Articulo</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Cliente</th>
                            <th scope="col">Email cliente</th>
                            <th scope="col">Calificacion</th>
                        </tr>
                    </thead>
                <tbody>
                <c:forEach var="venta" items="${lista}">
                        <tr>
                            <td>${venta.fecha}</td>
                            <td>${venta.producto.nombre}</td>
                            <td>$ ${venta.producto.precio}</td>
                            <td>${venta.comprador.nombre}  ${venta.comprador.apellido}</td>
                            <td>${venta.comprador.email}</td>
                            <td>
                                <c:if test="${user.getId() != usuario and venta.cancelado != true}">
                                    <a href="/TiendaVintage/CancelarVentaServlet?id=${venta.id}">
                                        <button class="btn btn-danger" type="button">Cancelar venta</button>
                                    </a>
                                </c:if>
                                <c:choose>
                                    <c:when test="${venta.cancelado == true}">
                                        <i>Venta cancelada</i>
                                    </c:when>
                                    <c:when test="${venta.valoracion == 0}">
                                        <i>Calificacion pendiente</i>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="starCounter" begin="1" end="${venta.valoracion}">⭐</c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                </c:forEach>
                </tbody>
        </table>
    </div>
         
</div>
<%@ include file="components/footer.jsp" %>
