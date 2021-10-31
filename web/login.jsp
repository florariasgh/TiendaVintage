<%-- 
    Document   : login
    Created on : 05/11/2020, 21:05:33
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Usuario</title>
        <link href="./resources/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/blog.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
         <header class="blog-header py-3">
            <div class="row flex-nowrap justify-content-between align-items-center">
               
               <div class="col-4 text-center">
                  <a class="blog-header-logo text-dark" href="/TiendaVintage/">Tienda Vintage</a>
               </div>
            </div>
         </header>
         <form method="POST" action="LoginServlet">
                <label for="txtUsuario">Usuario</label>
                <input type="text" class="form-control" name="txtUsuario"/>
                <label for="txtClave">Clave</label>
                <input type="password" class="form-control" name="txtClave"/>

                <button type="submit" class="btn btn-primary">Enviar</button>

        </form>

        <c:if test="${not empty error}">
                <p style='color:red;'>Error: ${error}</p>	
        </c:if>
		
    </body>
</html>
