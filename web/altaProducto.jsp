<%-- 
    Document   : altaCategoria
    Created on : 28/09/2021, 21:01:30
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subir productos</title>
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
                         <form enctype="multipart/form-data" action="/TiendaVintage/ListadoProductoServlet" method="post">
                            <fieldset>
                                <legend class="text-center header">Subir Productos</legend>

                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                    <div class="col-md-8">
                                        <input id="txtNombre" name="nombre" type="text" placeholder="Agregar titulo" class="form-control">
                                        <input id="txtDescripcion" name="descripcion" type="text" placeholder="Agregar descripcion" class="form-control">
                                        <input id="txtColor" name="color" type="text" placeholder="Agregar color" class="form-control">
                                        <input id="txtPrecio" name="precio" type="text" placeholder="Agregar precio" class="form-control">

                                        <div class="form-group">
                                                <label for="cboCategoria">Categoria</label>
                                                <select name="cboCategoria" >
                                                        <c:forEach var="c" items="${listacategorias}">
                                                                <option value="${c.id}">${c.nombre}</option>
                                                        </c:forEach>
                                                </select>
                                        </div> 
                                        <div class="form-group">
                                                <label for="cboGenero">Genero</label>
                                                <select name="cboGenero" >
                                                        <c:forEach var="c" items="${listageneros}">
                                                                <option value="${c.id}">${c.nombre}</option>
                                                        </c:forEach>
                                                </select>
                                        </div> 
                                        <div class="form-group">
                                                <label for="cboTalle">Talle</label>
                                                <select name="cboTalle" >
                                                        <c:forEach var="c" items="${listatalles}">
                                                                <option value="${c.id}">${c.nombre}</option>
                                                        </c:forEach>
                                                </select>
                                        </div> 
                                        
                                        <input type="file" name="fileFoto" />
                                    </div>
                                </div>
                              
                                <div class="form-group">
                                    <div class="col-md-12 text-center">
                                        <button type="submit" class="btn btn-primary btn-lg">Agregar producto</button>
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
