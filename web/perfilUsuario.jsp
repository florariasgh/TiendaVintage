<%-- 
    Document   : perfilUsuario
    Created on : 31/10/2021, 18:30:52
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@ include file="components/meta.jsp" %>     
<!-- BODY -->
<%@ include file="components/header.jsp" %>    
   <div class="container mt-5">
    <div class="row d-flex justify-content-center">
        <div class="col-md-7">
            <div class="card p-3 py-4">
                <div class="text-center"> <img src="./resources/imagenusuario.jpg" width="100" class="rounded-circle"> </div>
                <div class="text-center mt-3"> <span class="bg-secondary p-1 px-4 rounded text-white">Usuario</span>
                    <h5 class="mt-2 mb-0">${user.getNombre()} ${user.getApellido()}</h5>
                    <span>${user.getEmail()}</span>
                    <c:if test="${user.getId() == usuario}">
                        <div class="buttons"> <button class="btn btn-outline-primary px-4">Editar perfil</button></div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@ include file="components/footer.jsp" %>
