<%-- 
    Document   : misCompras
    Created on : 21/10/2021, 16:09:34
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                                    <th scope="col">Articulo</th>
                                    <th scope="col">Precio</th>
                                    <th scope="col">Vendedor</th>
                                    <th scope="col">Email vendedor</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                        <tbody>
			<c:forEach var="compra" items="${lista}">
				<tr>
                                    <td>${compra.producto.nombre}</td>
                                    <td>$ ${compra.producto.precio}</td>
                                    <td>${compra.vendedor.nombre}  ${compra.vendedor.apellido}</td>
                                    <td>${compra.vendedor.email}</td>
				</tr>
			</c:forEach>
                        </tbody>
		</table>
            </div>
         
</div>
<%@ include file="components/footer.jsp" %>