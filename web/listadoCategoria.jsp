<%-- 
    Document   : listadoCategoria
    Created on : 05/10/2021, 15:37:22
    Author     : arias
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Categoria"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ABM Categorias</title>
        <link href="./resources/bootstrap.min.css" rel="stylesheet" >
        <!-- Custom styles for this template -->
        <link href="./resources/css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/blog.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
        <h1>Listado de Categorias</h1>

		<table class="table table-responsive table-bordered">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                        <tbody>
			<c:forEach var="categoria" items="${lista}">
                          <tr>
                            <td>${categoria.nombre}</td>
                            <td><a href="/TiendaVintage/ModificarCategoriaServlet?id=${categoria.id}">modificar</a></td>
                            <td><a href="/TiendaVintage/EliminarCategoriaServlet?id=${categoria.id}">eliminar</a></td>
                          </tr>
			</c:forEach>
                        </tbody>
		</table>
		<a href="/TiendaVintage/AltaCategoriaServlet"><button type="button" class="btn btn-primary">Alta Categoria</button></a>
                <a href="/TiendaVintage/indexAdmin.jsp"><button type="button" class="btn btn-primary">Volver atras</button></a>
        </div>
    </body>
</html>

