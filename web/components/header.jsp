<%-- 
    Document   : header
    Created on : 31/10/2021, 17:43:52
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
  <header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

    <div class="container-fluid">
      <a class="navbar-brand" href="https://getbootstrap.com/docs/5.1/examples/navbar-static/#">Tienda Vintage</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button> 
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">

          <li class="nav-item">
            <a class="nav-link" href="/TiendaVintage/">Inicio</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/TiendaVintage/AltaProductoServlet">Subir Productos</a>
          </li>
                  <li class="nav-item">
            <a class="nav-link">Mi perfil</a>
          </li>
          
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Categorias
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
              <a class="dropdown-item" href="#">Action</a>
              <a class="dropdown-item" href="#">Another action</a>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
          </li>
          
                  <li class="nav-item">
            <a class="nav-link">Mis ventas</a>
          </li>
                  <li class="nav-item">
            <a class="nav-link">Mis compras</a>
          </li>
          
        </ul>
        
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
      <div class="col-4 d-flex justify-content-end align-items-center">
                    <a class="btn btn-sm btn-outline-secondary" href="/TiendaVintage/LoginServlet">Iniciar sesion</a>
                     <a class="btn btn-sm btn-outline-secondary" href="/TiendaVintage/LogoutServlet">Cerrar sesion</a>
                     <a class="btn btn-sm btn-outline-secondary" href="/TiendaVintage/RegistrarUsuarioServlet">Registrate</a>
                     
      </div>
      </div>
    </div>
       
  </nav>
      
  </header>