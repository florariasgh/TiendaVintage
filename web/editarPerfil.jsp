<%-- 
    Document   : registrarUsuario
    Created on : 31/10/2021, 16:15:56
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
                <form method="POST" action="/TiendaVintage/EditarPerfilServlet" onsubmit="return validar();">
                   <h1>Editar perfil</h1>
                   <div class="form-group">
                       <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                       <div class="col-md-8">
                           <div class="form-group">
                             <label for="txtNombre">Nombre</label>
                             <input type="text" name="nombre" class="form-control" id="txtNombre" value="${nombre}">
                           </div>
                           <div class="form-group">
                             <label for="txtApellido">Apellido</label>
                             <input type="text" name="apellido" class="form-control" id="txtApellido" value="${apellido}">
                           </div>
                           <div class="form-group">
                             <label for="txtTelefono">Telefono</label>
                             <input type="text" name="telefono" class="form-control" id="txtTelefono" value="${telefono}">
                           </div>
                           <div class="form-group">
                             <label for="txtClave">Clave</label>
                             <input type="password" name="clave" class="form-control" aria-describedby="claveHelp" id="txtClave" placeholder="Ingrese su nueva clave si desea cambiarla.">
                             <small id="claveHelp" class="form-text text-muted">Debe contener al menos 6 caracteres.</small>
                             <input type="password" name="repetirclave" class="form-control" id="txtRepetirClave" placeholder="Reingrese su clave.">
                           </div>
                           <div class="form-group">
                           </div>
                       </div>
                   </div>
                   <div class="form-group">
                       <div class="col-md-12 text-center">
                           <button type="submit" class="btn btn-primary">Guardar cambios</button>
                           <a href="/TiendaVintage" class="btn btn-outline-primary">Cancelar</a>
                       </div>
                   </div>
               </form>
           </div>
        </div>
    </div>
</body>
<%@ include file="components/footer.jsp" %>    
    <script>
            function validar() {
                    let txtNombre = document.getElementById("txtNombre").value;
                    if (!txtNombre) {
                            alert("Debe incluir un nombre");
                            return false;
                    }
                    let txtApellido = document.getElementById("txtApellido").value;
                    if (!txtApellido) {
                            alert("Debe incluir un apellido");
                            return false;
                    }
                    let txtClave = document.getElementById("txtClave").value;
                    if (txtClave) {
                        if (txtClave.length < 6) {
                            alert("Debe incluir una clave de al menos 6 caracteres.");
                            return false;
                        }
                        let txtRepetirClave = document.getElementById("txtClave").value;
                        if (!txtRepetirClave || txtRepetirClave.localeCompare(txtClave)) {
                                alert("Las claves ingresadas no coinciden");
                                return false;
                        }
                    }
                    return true;    
            }
            
            function validateEmail(email) {
                const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                return re.test(String(email).toLowerCase());
            }
    </script>
