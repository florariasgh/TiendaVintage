<%-- 
    Document   : modificarTalle
    Created on : 14/10/2021, 16:05:48
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar talles</title>
        <link href="./resources/bootstrap.min.css" rel="stylesheet" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <!-- Custom styles for this template -->
        <link href="./resources/css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/blog.css" rel="stylesheet">
    </head>
    <body>
        <h1>Modificar Talle</h1>

		<form method="POST" action="ModificarTalleServlet"> 
			
			<input type="hidden" name="txtId" value="${id}" />
			<div class="form-group">
				<label for="txtNombre">Nombre</label>
                                <input type="text" name="txtNombre" id="txtNombre" value="${nombre}"/>
                                
			</div> 
			 

			<input type="submit" value="Modificar" class="btn btn-primary" />
		</form>
                <a href="/TiendaVintage/listadoTalle.jsp"><button type="button" class="btn btn-primary">Volver atras</button></a>
    </body>
</html>
