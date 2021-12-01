<%-- 
    Document   : index
    Created on : 27/09/2021, 19:59:16
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="components/meta.jsp" %>     
<!-- BODY -->
<%@ include file="components/header.jsp" %>  
<!-- CAROUSEL -->
<main>

  <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
      
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-label="Slide 1" aria-current="true"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2" class=""></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3" class=""></button>
    </div>
  <div class="carousel-inner">
        
    <div class="carousel-item active">
        <img src="resources/carousel1.jpg" class="img-fluid" alt="Responsive image">

        <div class="container">
          <div class="carousel-caption text-start">
            <h1>Nos beneficiamos todos.</h1>
            <p>Ahorras dinero sin perder calidad y ayudas al medio ambiente</p>
            <p><a class="btn btn-lg btn-light" href="/TiendaVintage/VerProductosServlet">Ver Productos</a></p>
    </div>
        </div>
      </div>
        
    <div class="carousel-item">
        <img src="resources/carousel2.jpg" class="img-fluid" alt="Responsive image">

        <div class="container">
          <div class="carousel-caption">
            <h1>Apoya la economia local</h1>
            <p> </p>
            
    </div>
        </div>
      </div>
        
    <div class="carousel-item">
        <img src="resources/carousel3.jpg" class="img-fluid" alt="Responsive image">

        <div class="container">
          <div class="carousel-caption text-end">
            <h1>Ayudemos al medio ambiente</h1>
            
    </div>
  </div>
      </div>
    </div>
      
    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
</div>
</main>


<%@ include file="components/footer.jsp" %>