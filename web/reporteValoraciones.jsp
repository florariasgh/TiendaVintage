<%-- 
    Document   : reporteValoraciones
    Created on : 30/11/2021, 17:40:36
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@ include file="components/admin/meta.jsp" %>>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!-- BODY -->
<%@ include file="components/admin/header.jsp" %>  
        <div class="container-fluid">
        <div class="row">
    <%@ include file="components/admin/nav.jsp" %>     
    <div class="col-md-8 offset-md-3">
        <h1>Reporte de 10 mejores vendedores por valoracion</h1>
        <c:if test="${not empty error}">
            <p style='color:red;'>${error}</p>	
        </c:if>
        <form method="POST" action="ReporteMejorValoracionesServlet"> 
            <div class="row">
                <div class="form-group col-md-5">
                    <label for="fechaDesde">Desde</label>
                    <input type="text" name="desde" value="${initialDesde}" class="form-control" id="fechaDesde" placeholder="">
                  </div>
                <div class="form-group col-md-5">
                    <label for="fechaHasta">Hasta</label>
                    <input type="text" name="hasta" value="${initialHasta}" class="form-control" id="fechaHasta" placeholder="">
                  </div>
                <div class="form-group col-md-2 p-4">
                    <button type="submit" class="btn btn-primary">Buscar</button>
                </div>
            </div>
        </form>
        <div class="row">
                <canvas id="myChart" width="400" height="400"></canvas>
                <table class="table  table-bordered">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Valoracion</th>
                        </tr>
                    </thead>
                    <tbody>
			<c:forEach var="item" items="${items}">
                          <tr>
                            <td>${item.nombre}</td>
                            <td>${item.valoracion}</td>
                          </tr>
			</c:forEach>
                    </tbody>
		</table>
        </div>
    </div>
</body>
<script>
    $( function() {
        $( "#fechaDesde" ).datepicker({ dateFormat: 'dd/mm/yy' });
        $( "#fechaHasta" ).datepicker({ dateFormat: 'dd/mm/yy' });
      } );
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
      url: "ReportesJsonDataServlet?reporte=valoraciones&desde=" + $("#fechaDesde").val() + "&hasta=" + $("#fechaHasta").val(),
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
          label: 'Vendedores con mejores valoraciones',
          data: Object.values(vendedoresDict),
          backgroundColor: 'rgb(255, 205, 86)'
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
