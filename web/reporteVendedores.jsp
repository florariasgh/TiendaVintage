<%-- 
    Document   : reporteVendedores
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
                <h1>Ranking de vendedores por cantidad de ventas</h1>
                <canvas id="myChart" width="400" height="400"></canvas>
                <table class="table  table-bordered">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Cantidad</th>
                        </tr>
                    </thead>
                    <tbody>
			<c:forEach var="item" items="${items}">
                          <tr>
                            <td>${item.nombre}</td>
                            <td>${item.cantidad}</td>
                          </tr>
			</c:forEach>
                    </tbody>
		</table>
        </div>
    </div>
</body>
<script>
    function sort_object(obj) {
        items = Object.keys(obj).map(function(key) {
            return [key, obj[key]];
        });
        items.sort(function(first, second) {
            return second[1] - first[1];
        });
        sorted_obj={}
        $.each(items, function(k, v) {
            use_key = v[0]
            use_value = v[1]
            sorted_obj[use_key] = use_value
        })
        return(sorted_obj)
    } 
    var vendedoresDict = {};
    $.ajax({
      async: false,
      url: "ReportesJsonDataServlet?reporte=vendedores",
      dataType:"json",
      success: function(vendedoresJsonData) {
        vendedoresDict = vendedoresJsonData;
      }
    });
    vendedoresDict = sort_object(vendedoresDict);
    const labels = Object.keys(vendedoresDict);
    const data = {
        labels: labels,
        datasets: [{
          label: 'Vendedores con mas ventas',
          data: Object.values(vendedoresDict),
          backgroundColor: 'rgb(255, 99, 132)'
        }],
        hoverOffset: 4
    };
    const config = {
        type: 'bar',
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
