<%-- 
    Document   : registrarUsuario
    Created on : 31/10/2021, 16:15:56
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
                <form method="POST" action="LoginServlet">
                   <h1>Iniciar sesion</h1>
                        <div class="form-group">
                            <label for="txtUsuario">Usuario</label>
                            <input type="text" class="form-control" name="txtUsuario"/>
                        </div>
                        <div class="form-group">
                            <label for="txtClave">Clave</label>
                            <input type="password" class="form-control" name="txtClave"/>
                        </div>
                        <button type="submit" class="btn btn-primary">Enviar</button>

                </form>
            </div>
        </div>
    </div>
</body>
<%@ include file="components/footer.jsp" %>
<c:if test="${not empty error}">
        <p style='color:red;'>Error: ${error}</p>	
</c:if>
