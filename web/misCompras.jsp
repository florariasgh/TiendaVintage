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
                                    <th scope="col">Calificar compra</th>
                                    <th scope="col">Realizar reclamo</th>
                                </tr>
                            </thead>
                        <tbody>
			<c:forEach var="compra" items="${lista}">
				<tr>
                                    <td>${compra.producto.nombre}</td>
                                    <td>$ ${compra.producto.precio}</td>
                                    <td>${compra.vendedor.nombre}  ${compra.vendedor.apellido}</td>
                                    <td>${compra.vendedor.email}</td>
                                    <td>
                                        <select name="cboValoracion${producto.id}" >
                                            <option value='5'>⭐⭐⭐⭐⭐</option>
                                            <option value='4'>⭐⭐⭐⭐</option>
                                            <option value='3'>⭐⭐⭐</option>
                                            <option value='2'>⭐⭐</option>
                                            <option value='1'>⭐</option>
                                        </select>
                                        <a href="javascript:guardarValoracion(${producto.id});">
                                            <button class="btn btn-primary" type="button">Enviar</button>
                                        </a>
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
<script>
    function guardarValoracion(id) {
        console.log(id);
        return "/TiendaVintage/GuardarValoracion?id=" + id + "&valoracion=" + $(`select[name="cboValoracion${producto.id}"]`).value;
    }
    </script>
<%@ include file="components/footer.jsp" %>