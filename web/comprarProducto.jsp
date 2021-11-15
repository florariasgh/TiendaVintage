<%-- 
    Document   : comprarProducto
    Created on : 12/11/2021, 20:12:47
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
                <form method="POST" action="/TiendaVintage/ComprarServlet" onsubmit="return validar();">
                   <h1>Checkout</h1>
                   <div class="card" style="width: 25rem;">
                        <input type="hidden" name="id" value="${producto.id}" />
                        <img src="http://127.0.0.1:8887/${producto.nombreFoto}" class="card-img-top" alt="...">
                        <div class="card-body">
                          <h5 class="card-title">${producto.nombre}</h5>
                          <p class="card-text">${producto.descripcion}</p>
                        </div>
                        <ul class="list-group list-group-flush">
                          <li class="list-group-item">$ ${producto.precio}</li>
                          <li class="list-group-item">${producto.usuario.nombre} ${producto.usuario.apellido}</li>
                        </ul>
                   </div>
                   <div class="padding">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-header">
                                    <strong>Credit Card</strong>
                                    <small>enter your card details</small>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="name">Name</label>
                                                <input class="form-control" id="name" type="text" placeholder="Enter your name">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="ccnumber">Credit Card Number</label>
                                                <div class="input-group">
                                                    <input class="form-control" type="text" placeholder="0000 0000 0000 0000" autocomplete="email">
                                                    <div class="input-group-append">
                                                        <span class="input-group-text">
                                                            <i class="mdi mdi-credit-card"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-sm-4">
                                            <label for="ccmonth">Month</label>
                                            <select class="form-control" id="ccmonth">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                                <option>6</option>
                                                <option>7</option>
                                                <option>8</option>
                                                <option>9</option>
                                                <option>10</option>
                                                <option>11</option>
                                                <option>12</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-4">
                                            <label for="ccyear">Year</label>
                                            <select class="form-control" id="ccyear">
                                                <option>2014</option>
                                                <option>2015</option>
                                                <option>2016</option>
                                                <option>2017</option>
                                                <option>2018</option>
                                                <option>2019</option>
                                                <option>2020</option>
                                                <option>2021</option>
                                                <option>2022</option>
                                                <option>2023</option>
                                                <option>2024</option>
                                                <option>2025</option>
                                            </select>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <label for="cvv">CVV/CVC</label>
                                                <input class="form-control" id="cvv" type="text" placeholder="123">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <button class="btn btn-sm btn-success float-right" type="submit">
                                        <i class="mdi mdi-gamepad-circle"></i> Comprar</button>
                                    <button class="btn btn-sm btn-danger" type="reset">
                                        <i class="mdi mdi-lock-reset"></i> Cancelar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
               </form>
           </div>
        </div>
    </div>
</body>
<%@ include file="components/footer.jsp" %>
