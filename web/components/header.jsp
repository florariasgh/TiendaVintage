<%-- 
    Document   : header
    Created on : 31/10/2021, 17:43:52
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<body>
  <header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

    <div class="container-fluid">
      <a class="navbar-brand" href="/TiendaVintage">Tienda Vintage</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button> 
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">

          <li class="nav-item">
            <a class="nav-link" href="/TiendaVintage/">Inicio</a>
          </li>
          
          <c:if test="${not empty usuario}">
        
          <li class="nav-item">
            <a class="nav-link" href="/TiendaVintage/AltaProductoServlet">Subir Productos</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="/TiendaVintage/PerfilUsuarioServlet">Mi perfil</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link"href="/TiendaVintage/MisVentasServlet">Mis ventas</a>
          </li>
                  <li class="nav-item">
            <a class="nav-link" href="/TiendaVintage/MisComprasServlet">Mis compras</a>
          </li>
          
          </c:if>
                  
          <!-- MENU PRODUCTOS -->
          <li class="nav-item dropdown">
            <a href="/TiendaVintage/VerProductosServlet" class= "nav-link dropdown-toggle" id="navbarDropdown"  role="button"
                data-bs-toggle="dropdown" aria-expanded="false">
                   Productos
            </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a href="/TiendaVintage/VerProductosServlet"
                          class="dropdown-item">
                             Ver todo
                      </a>
                      
                  </li>
                  
                  <li><a href="/TiendaVintage/VerProductosServlet?genero=2"
                          class="dropdown-item">
                             Mujeres
                      </a>
                      
                  </li>
                  
                  <li><a href="/TiendaVintage/VerProductosServlet?genero=3"
                          class="dropdown-item">
                             Hombres
                      </a>
                      
                  </li>
                  <li><a href="/TiendaVintage/VerProductosServlet?genero=1"
                          class="dropdown-item">
                             Unisex
                      </a>
                      
                  </li>
              </ul>
          </li>
          
          <!-- FIN MENU PRODUCTOS -->
          
          
          
        </ul>
        
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
      <div class="col-4 d-flex justify-content-end align-items-center">
          <c:choose>
            <c:when test="${not empty usuario}">
              <a class="btn btn-sm btn-secondary" href="/TiendaVintage/LogoutServlet">Cerrar sesion</a>
           </c:when>
           <c:otherwise>
             <a class="btn btn-sm btn-secondary" href="/TiendaVintage/LoginServlet">Iniciar sesion</a>
             <a class="btn btn-sm btn-secondary" href="/TiendaVintage/RegistrarUsuarioServlet">Registrate</a>
           </c:otherwise>
          </c:choose>
      </div>
      </div>
    </div>
       
  </nav>
      
  </header>