<%-- 
    Document   : listadoProducto
    Created on : 21/10/2021, 16:09:34
    Author     : arias
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Producto"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Mi vestidor</title>
        <link href="./resources/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/blog.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
        <h1>Mi vestidor</h1>

		<table class="table table-responsive table-bordered">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Categoria</th>
                                    <th>Precio</th>
                                    <th>Descripcion</th>
                                    <th>Disponible</th>
                                    <th>Usuario</th>
                                    <th>Talle</th>
                                    <th>Genero</th>
                                    <th>nombreFoto</th>
                                </tr>
                            </thead>
                        <tbody>
			<c:forEach var="producto" items="${lista}">
				<tr>
                                    <td>${producto.id}</td>
                                    <td>${producto.nombre}</td>
                                    <td>${producto.categoria.nombre}</td>
                                    <td>${producto.precio}</td>
                                    <td>${producto.descripcion}</td>
                                    <td>${producto.disponible}</td>
                                    <td>${producto.usuario.nombre}</td>
                                    <td>${producto.talle.nombre}</td>
                                    <td>${producto.genero.nombre}</td>
                                    <td>${producto.nombreFoto}</td>
                                   <!-- <td><a href="/TiendaVintage/ModificarComercioServlet?id=${comercio.id}">modificar</a></td>
                                    <td><a href="/TiendaVintage/EliminarComercioServlet?id=${comercio.id}">eliminar</a></td> -->
				</tr>
			</c:forEach>
                        </tbody>
		</table>
		<a href="/TiendaVintage/AltaProductoServlet"><button type="button" class="btn btn-primary">Subir Producto</button></a>
                <a href="/TiendaVintage/index.jsp"><button type="button" class="btn btn-primary">Volver atras</button></a>
        </div>
    </body>
</html>
