<%-- 
    Document   : verComercio
    Created on : 31/10/2020, 18:31:43
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<%@ include file="components/meta.jsp" %>     
<!-- BODY -->
<%@ include file="components/header.jsp" %>    
    <div class="container p-5 section-products">
        <h1>Productos</h1>
        <div class="row justify-content-center text-center">
                <c:forEach var="producto" items="${lista}">
                    <!-- Single Product -->
                    <div class="col-md-6 col-lg-4 col-xl-3">
                        <div id="product-1" class="single-product">
                            <div class="part-1" style="background: url('http://127.0.0.1:8887/${producto.nombreFoto}') no-repeat center;">
                                
                            </div>
                            <div class="part-2">
                                <h3 class="product-title">${producto.nombre}</h3>
                                <h4 class="product-price">$ <fmt:formatNumber pattern="#,##0" value="${producto.precio}" /></h4>
                                <a href="/TiendaVintage/VerProductoServlet?id=${producto.id}" ><button type="button" class="btn btn-info">Ver</button></a>
                                <c:if test="${not empty usuario}">
                                    <a href="/TiendaVintage/ComprarServlet?id=${producto.id}" ><button type="button" class="btn btn-dark">Comprar</button></a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <a href="/TiendaVintage/index.jsp"><button type="button" class="btn btn-primary">Volver atras</button></a>
        </div>
</body>
<%@ include file="components/footer.jsp" %>