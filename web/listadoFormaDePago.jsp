<%-- 
    Document   : listadoFormaDePago
    Created on : 14/10/2021, 19:55:35
    Author     : arias
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.FormaDePago"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ABM Forma de Pago</title>
        <link href="./resources/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/blog.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
        <h1>Lista de formas de pago</h1>

		<table class="table table-responsive table-bordered">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                        <tbody>
			<c:forEach var="formadepago" items="${lista}">
                          <tr>
                            <td>${formadepago.nombre}</td>
                            <td><a href="/TiendaVintage/ModificarFormaDePagoServlet?id=${formadepago.id}">modificar</a></td>
                            <td><a href="/TiendaVintage/EliminarFormaDePagoServlet?id=${formadepago.id}">eliminar</a></td>
                          </tr>
			</c:forEach>
                        </tbody>
		</table>
		<a href="/TiendaVintage/AltaFormaDePagoServlet"><button type="button" class="btn btn-primary">Alta Forma de pago</button></a>
                <a href="/TiendaVintage/indexAdmin.jsp"><button type="button" class="btn btn-primary">Volver atras</button></a>
        </div>
    </body>
</html>

