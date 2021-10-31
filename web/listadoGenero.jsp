<%-- 
    Document   : listadoGenero
    Created on : 14/10/2021, 18:03:39
    Author     : arias
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Genero"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ABM Generos</title>
        <link href="./resources/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/blog.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
        <h1>Listado de Generos</h1>

		<table class="table table-responsive table-bordered">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                        <tbody>
			<c:forEach var="genero" items="${lista}">
                          <tr>
                            <td>${genero.nombre}</td>
                            <td><a href="/TiendaVintage/ModificarGeneroServlet?id=${genero.id}">modificar</a></td>
                            <td><a href="/TiendaVintage/EliminarGeneroServlet?id=${genero.id}">eliminar</a></td>
                          </tr>
			</c:forEach>
                        </tbody>
		</table>
		<a href="/TiendaVintage/AltaGeneroServlet"><button type="button" class="btn btn-primary">Alta Genero</button></a>
                <a href="/TiendaVintage/indexAdmin.jsp"><button type="button" class="btn btn-primary">Volver atras</button></a>
        </div>
    </body>
</html>

