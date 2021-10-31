<%-- 
    Document   : verComercio
    Created on : 31/10/2020, 18:31:43
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
        <title>Productos</title>
        <link href="./resources/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/blog.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Productos</h1>
                <c:forEach var="producto" items="${lista}">
                    <div class="row">
                        <div class="col-md-8">
                           <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                              <div class="col p-4 d-flex flex-column position-static">
                                 <strong class="d-inline-block mb-2 text-primary">Producto</strong>
                                 <h3 class="mb-0">${producto.nombre}</h3>
                                 <p class="card-text mb-auto">${producto.categoria}</p>
                                 <p class="card-text mb-auto">${producto.precio}</p>
                                 <p class="card-text mb-auto">${producto.descripcion}</p>
                                 <p class="card-text mb-auto">${producto.disponible}</p>
                                 <p class="card-text mb-auto">${producto.usuario}</p>
                                 <p class="card-text mb-auto">${producto.talle}</p>
                                 <p class="card-text mb-auto">${producto.genero}</p>
                                 <p class="card-text mb-auto">${producto.nombreFoto}</p>
                                 
                              </div>
                           </div>
                        </div>
                    </div>
                </c:forEach>
            <a href="/TiendaVintage/index.jsp"><button type="button" class="btn btn-primary">Volver atras</button></a>
        </div>
    </body>
</html>

