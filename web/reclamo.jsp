<%-- 
    Document   : reclamo
    Created on : 01/12/2021, 15:15:55
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
                         <form enctype="multipart/form-data" action="/TiendaVintage/ReclamoServlet" method="post">
                            <fieldset>
                                <legend class="text-center header">Realizar reclamo</legend>

                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                    <div class="col-md-8">
                                        <input id="txtNombre" name="nombre" type="text" placeholder="Agregar nombre completo" class="form-control">
                                        <input id="txtEmail" name="email" type="text" placeholder="Agregar Email" class="form-control">
                                        <input id="txtPrecio" name="precio" type="text" placeholder="Agregar precio" class="form-control">
   
                                    </div>
                                </div>
                              
                                <div class="form-group">
                                    <div class="col-md-12 text-center">
                                        <button type="submit" class="btn btn-primary btn-lg">Reclamar</button>
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
