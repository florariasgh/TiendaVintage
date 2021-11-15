<%-- 
    Document   : compraRealizada
    Created on : 12/11/2021, 21:08:47
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@ include file="components/meta.jsp" %>     
<!-- BODY -->
<%@ include file="components/header.jsp" %>    
    <div class="jumbotron">
  <h1 class="display-4">Gracias por tu compra!</h1>
  <p class="lead">Ya puedes contactar al vendedor al correo <a href="#">${producto.usuario.email}</a>.</p>
  <hr class="my-4">
  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
  <p class="lead">
    <a class="btn btn-primary btn-lg" href="#" role="button">Ver Mis compras</a>
  </p>
</div>
</body>
<%@ include file="components/footer.jsp" %> 
