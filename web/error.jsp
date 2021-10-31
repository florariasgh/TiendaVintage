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
<body>
    <div class="container p-3">
        <div class="alert alert-danger" role="alert">
          ${mensaje}
        </div>
    </div>
</body>
<%@ include file="components/footer.jsp" %>