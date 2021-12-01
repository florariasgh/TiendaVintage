<%-- 
    Document   : listadoCategoria
    Created on : 05/10/2021, 15:37:22
    Author     : arias
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Categoria"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ include file="components/admin/meta.jsp" %>
<body> 
    <%@ include file="components/admin/header.jsp" %>  
    <div class="container-fluid">
      <div class="row">
        <%@ include file="components/admin/nav.jsp" %>  

        <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Dashboard</h1>
                <div class="container">
                <h1>Listado de Categorias</h1>

		<table class="table table-responsive table-bordered">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                        <tbody>
			<c:forEach var="categoria" items="${lista}">
                          <tr>
                            <td>${categoria.nombre}</td>
                            <td><a href="/TiendaVintage/ModificarCategoriaServlet?id=${categoria.id}">modificar</a></td>
                            <td><a href="/TiendaVintage/EliminarCategoriaServlet?id=${categoria.id}">eliminar</a></td>
                          </tr>
			</c:forEach>
                        </tbody>
		</table>
		<a href="/TiendaVintage/AltaCategoriaServlet"><button type="button" class="btn btn-primary">Alta Categoria</button></a>
                <a href="/TiendaVintage/indexAdmin.jsp"><button type="button" class="btn btn-primary">Volver atras</button></a>
                </div>
            </div>
        </main>
      </div>
    </div>
  </body>
</html>