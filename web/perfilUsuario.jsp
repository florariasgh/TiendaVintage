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
    <hr/>
    <h2>Productos subidos</h2>
    <div class="row d-flex justify-content-center">
		<table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Categoria</th>
                                    <th scope="col">Precio</th>
                                    <th scope="col">Descripcion</th>
                                    <th scope="col">Talle</th>
                                    <th scope="col">Genero</th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                        <tbody>
			<c:forEach var="producto" items="${lista}">
				<tr>
                                    <td>${producto.nombre}</td>
                                    <td>${producto.categoria.nombre}</td>
                                    <td>$ ${producto.precio}</td>
                                    <td>${producto.descripcion}</td>
                                    <td>${producto.talle.nombre}</td>
                                    <td>${producto.genero.nombre}</td>
                                    <td>
                                        
                                        <c:if test="${user.getId() == usuario}">
                                            <a href="/TiendaVintage/ModificarProductoServlet?id=${producto.id}">
                                                <button class="btn btn-success" type="button">Editar</button>
                                            </a>
                                        </c:if>
                                        <c:if test="${user.getId() == usuario}">
                                            <a href="/TiendaVintage/EliminarProductoServlet?id=${producto.id}">
                                                <button class="btn btn-danger" type="button">Eliminar</button>
                                            </a>
                                        </c:if>
                                        <c:if test="${user.getId() == usuario}">
                                            <a href="/TiendaVintage/VerProductoServlet?id=${producto.id}">
                                                <button class="btn btn-info" type="button">Consultas</button>
                                            </a>
                                        </c:if>
                                        <c:if test="${user.getId() != usuario}">
                                            <a href="/TiendaVintage/VerProductoServlet?id=${producto.id}">
                                                <button class="btn btn-primary" type="button">Ver</button>
                                            </a>
                                        </c:if>
                                    </td>
				</tr>
			</c:forEach>
                        </tbody>
		</table>
            </div>
        </div> 
</body>
<%@ include file="components/footer.jsp" %>
