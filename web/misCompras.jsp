<%-- 
    Document   : misCompras
    Created on : 21/10/2021, 16:09:34
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<%@ include file="components/meta.jsp" %>     
<!-- BODY -->
<%@ include file="components/header.jsp" %>   
<div class="container mt-5">
<h2>Mis compras</h2>
    <div class="row d-flex justify-content-center">
		<table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Fecha</th>
                                    <th scope="col">Articulo</th>
                                    <th scope="col">Precio</th>
                                    <th scope="col">Vendedor</th>
                                    <th scope="col">Email vendedor</th>
                                    <th scope="col">Calificar compra</th>
                                    <th scope="col">Realizar reclamo</th>
                                </tr>
                            </thead>
                        <tbody>
			<c:forEach var="compra" items="${lista}">
				<tr>
                                    <td>${compra.fecha}</td>
                                    <td>${compra.producto.nombre}</td>
                                    <td>$ <fmt:formatNumber pattern="#,##0" value="${compra.producto.precio}" /></td>
                                    <td>${compra.vendedor.nombre}  ${compra.vendedor.apellido}</td>
                                    <td>${compra.vendedor.email}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${compra.cancelado == true}">
                                                <i>Compra cancelada</i>
                                            </c:when>
                                            <c:when test="${compra.valoracion == 0}">
                                                <a href="/TiendaVintage/ValorarCompraServlet?id=${compra.id}">
                                                    <button class="btn btn-success" type="button">Calificar</button>
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                <c:forEach var="starCounter" begin="1" end="${compra.valoracion}">⭐</c:forEach>
                                            </c:otherwise>
                                        </c:choose>
                                        
                                    </td>
                                    <td>
                                        <button class="btn btn-danger" type="button">Reclamar</button>
                                    </td>
				</tr>
			</c:forEach>
                        </tbody>
		</table>
            </div>
         
</div>
<%@ include file="components/footer.jsp" %>