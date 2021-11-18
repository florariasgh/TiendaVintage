<%-- 
    Document   : verProducto
    Created on : 17/11/2021, 14:55:42
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="components/meta.jsp" %>     
<!-- BODY -->
<%@ include file="components/header.jsp" %>     

<div class="container p-5 section-products">
        <div class="row justify-content-center text-center">
            <!-- Single Product -->
            <div class="col-md-6 col-lg-4 col-xl-3">
                <div id="product-1" class="single-product">
                    <div class="part-1" style="background: url('http://127.0.0.1:8887/${producto.nombreFoto}') no-repeat center;">

                    </div>
                    <div class="part-2">
                        <h3 class="product-title">${producto.nombre}</h3>
                        <h3 class="product-price">${producto.precio}</h3>
                        <h3 class="product-descripcion">${producto.descripcion}</h3>
                        <h3 class="product-genero">${producto.genero.nombre}</h3>
                        <h3 class="product-usuario"><a href="/TiendaVintage/PerfilUsuarioServlet?id=${producto.usuario.id}">${producto.usuario.nombre}</a></h3>
                        <a href="/TiendaVintage/ComprarServlet?id=${producto.id}" ><button type="button" class="btn btn-dark">Comprar</button></a>
                    </div>
                </div>
            </div>
        </div>
</div>
</body>
<%@ include file="components/footer.jsp" %>
