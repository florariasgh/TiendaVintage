<%-- 
    Document   : modificarProducto
    Created on : 17/11/2021, 17:50:55
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@ include file="components/meta.jsp" %>     
<!-- BODY -->
<%@ include file="components/header.jsp" %>    
    <div class="container p-3">
         <div class="row">
                <div class="col-md-12">
                    <div class="well well-sm">
                         <form enctype="multipart/form-data" action="/TiendaVintage/ModificarProductoServlet" method="post">
                            <fieldset>
                                <legend class="text-center header">Modificar Producto</legend>

                                <div class="form-group">
                                    <input type="hidden" name="id" value="${id}" />
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                    <div class="col-md-8">
                                        <input id="txtNombre" name="nombre" type="text" placeholder="Agregar titulo" class="form-control" value="${nombre}">
                                        <input id="txtDescripcion" name="descripcion" type="text" placeholder="Agregar descripcion" class="form-control" value="${descripcion}">
                                        <input id="txtPrecio" name="precio" type="text" placeholder="Agregar precio" class="form-control" value="${precio}">

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
                                        <button type="submit" class="btn btn-primary btn-lg">Modificar</button>
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
<%@ include file="components/footer.jsp" %>
