<%-- 
    Document   : reporteStock
    Created on : 30/11/2021, 17:40:36
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@ include file="components/admin/meta.jsp" %>>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!-- BODY -->
<%@ include file="components/admin/header.jsp" %>  
        <div class="container-fluid">
        <div class="row">
    <%@ include file="components/admin/nav.jsp" %>     
    <div class="col-md-8 offset-md-3">
        <div class="row">
                <h1>Reporte de existencias de producto</h1>
                <canvas id="myChart" width="400" height="400"></canvas>
                <table class="table  table-bordered">
                    <thead>
                        <tr>
                            <th>Categoria</th>
                            <th>Talle</th>
                            <th>Genero</th>
                            <th>Cantidad</th>
                        </tr>
                    </thead>
                    <tbody>
			<c:forEach var="item" items="${items}">
                          <tr>
                            <td>${item.categoria.nombre}</td>
                            <td>${item.talle.nombre}</td>
                            <td>${item.genero.nombre}</td>
                            <td>${item.cantidad}</td>
                          </tr>
			</c:forEach>
                    </tbody>
		</table>
        </div>
    </div>
</body>
<script>
    var generoDict = {};
    $.ajax({
      async: false,
      url: "ReportesJsonDataServlet",
      dataType:"json",
      success: function(generoJsonData) {
        generoDict = generoJsonData;
      }
    });
    const labels = Object.keys(generoDict);
    const data = {
        labels: labels,
        datasets: [{
          label: 'Stock por genero',
          backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(54, 162, 235)',
            'rgb(255, 205, 86)'
          ],
          data: Object.values(generoDict)
        }],
        hoverOffset: 4
    };
    const config = {
        type: 'doughnut',
        data: data,
        options: {
            responsive: false,
        }
    };
    const myChart = new Chart(
        document.getElementById('myChart'),
        config
    );
</script>
