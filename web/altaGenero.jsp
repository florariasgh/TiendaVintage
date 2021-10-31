<%-- 
    Document   : altaGenero
    Created on : 04/10/2021, 13:56:46
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar genero</title>
        <link href="./resources/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/blog.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="well well-sm">
                        <form method="POST" action="/TiendaVintage/AltaGeneroServlet" >
                            <fieldset>
                                <legend class="text-center header">Subir genero</legend>

                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                    <div class="col-md-8">
                                        <input id="txtNombre" name="nombre" type="text" placeholder="Agregar genero" class="form-control">
                                        
                                    </div>
                                </div>
                              
                                <div class="form-group">
                                    <div class="col-md-12 text-center">
                                        <button type="submit" class="btn btn-primary btn-lg">Agregar genero</button>
                                        <button class="btn btn-primary btn-lg">Cancelar</button>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
