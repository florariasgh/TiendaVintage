/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import servlets.ReporteVendedoresItem;


/**
 *
 * @author arias
 */
public class GestorDB {
    
    private Connection con;
	private String CONN = "jdbc:sqlserver://LAPTOP-Q82L94GV\\SQLEXPRESS\\SQLEXPRESS:53031;databaseName=TiendaVintage";
	private String USER = "sa";
	private String PASS = "123456";

	private void abrirConexion() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager.getConnection(CONN, USER, PASS);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void cerrarConexion() {
		try {

			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
     /* CATEGORIAS*/
        
    public ArrayList<Categoria> obtenerCategorias() {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		try {
			abrirConexion();
			String sql = "select * from Categorias";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				lista.add(new Categoria(id, nombre));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;
	}
    
    public boolean insertarCategoria(Categoria categoria) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "INSERT INTO Categorias (nombre) VALUES (?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, categoria.getNombre());
			st.execute();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}
    
    public Categoria obtenerCategoria(int idCategoria) {
		Categoria categoria = null;
		try {
			abrirConexion();
			String sql = "select * from Categorias where id=" + idCategoria;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
                        if (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				categoria = new Categoria(id, nombre);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return categoria;
    }
    
    public void eliminarCategoria(int idCategoria) {
		Categoria categoria = null;
		try {
			abrirConexion();
			String sql = "DELETE from Categorias where id=" + idCategoria;
			PreparedStatement st = con.prepareStatement(sql);
                        st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
    }
    
    public boolean modificarCategoria(Categoria categoria) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "UPDATE Categorias SET nombre=? WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, categoria.getNombre());
			st.setInt(2, categoria.getId());
			st.executeUpdate();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}
    
         /* TALLES*/
         public ArrayList<Talle> obtenerTalles() {
		ArrayList<Talle> lista = new ArrayList<Talle>();
		try {
			abrirConexion();
			String sql = "select * from Talles";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				lista.add(new Talle(id, nombre));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;
	}
    
    public boolean insertarTalle(Talle talle) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "INSERT INTO Talles (nombre) VALUES (?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, talle.getNombre());
			st.execute();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}
    
    public Talle obtenerTalle(int idTalle) {
		Talle talle = null;
		try {
			abrirConexion();
			String sql = "select * from Talles where id=" + idTalle;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
                        if (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				talle = new Talle(id, nombre);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return talle;
    }
    
    public void eliminarTalle(int idTalle) {
		Talle talle = null;
		try {
			abrirConexion();
			String sql = "DELETE from Talles where id=" + idTalle;
			PreparedStatement st = con.prepareStatement(sql);
                        st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
    }
    
    public boolean modificarTalle(Talle talle) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "UPDATE Talles SET nombre=? WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, talle.getNombre());
			st.setInt(2, talle.getId());
			st.executeUpdate();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}
    
         /* GENEROS*/
    public ArrayList<Genero> obtenerGeneros() {
		ArrayList<Genero> lista = new ArrayList<Genero>();
		try {
			abrirConexion();
			String sql = "select * from Generos";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				lista.add(new Genero(id, nombre));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;
	}
    
    public boolean insertarGenero(Genero genero) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "INSERT INTO Generos (nombre) VALUES (?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, genero.getNombre());
			st.execute();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}
    
    public Genero obtenerGenero(int idGenero) {
		Genero genero = null;
		try {
			abrirConexion();
			String sql = "select * from Generos where id=" + idGenero;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
                        if (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				genero = new Genero(id, nombre);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return genero;
    }
    
    public void eliminarGenero(int idGenero) {
		Genero genero = null;
		try {
			abrirConexion();
			String sql = "DELETE from Generos where id=" + idGenero;
			PreparedStatement st = con.prepareStatement(sql);
                        st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
    }
    
    public boolean modificarGenero(Genero genero) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "UPDATE Generos SET nombre=? WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, genero.getNombre());
			st.setInt(2, genero.getId());
			st.executeUpdate();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}
    
    /* FORMA DE PAGO*/
     public ArrayList<FormaDePago> obtenerFormaDePago() {
		ArrayList<FormaDePago> lista = new ArrayList<FormaDePago>();
		try {
			abrirConexion();
			String sql = "select * from FormaDePago";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				lista.add(new FormaDePago(id, nombre));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;
	}
    
    public boolean insertarFormaDePago(FormaDePago formadepago) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "INSERT INTO FormaDePago (nombre) VALUES (?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, formadepago.getNombre());
			st.execute();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}
    
    public FormaDePago obtenerFormaDePago(int idFormaDePago) {
		FormaDePago formadepago = null;
		try {
			abrirConexion();
			String sql = "select * from FormaDePago where id=" + idFormaDePago;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
                        if (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				formadepago = new FormaDePago(id, nombre);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return formadepago;
    }
    
    public void eliminarFormaDePago(int idFormaDePago) {
		FormaDePago formadepago = null;
		try {
			abrirConexion();
			String sql = "DELETE from FormaDePago where id=" + idFormaDePago;
			PreparedStatement st = con.prepareStatement(sql);
                        st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
    }
    
    public boolean modificarFormaDePago(FormaDePago formadepago) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "UPDATE FormaDePago SET nombre=? WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, formadepago.getNombre());
			st.setInt(2, formadepago.getId());
			st.executeUpdate();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}
    
    /* USUARIOS*/
    
    public boolean insertarUsuario(Usuario usuario, String clave) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "INSERT INTO Usuarios (nombre,apellido,email,telefono,clave) VALUES (?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, usuario.getNombre());
                        st.setString(2, usuario.getApellido());
                        st.setString(3, usuario.getEmail());
                        st.setString(4, usuario.getTelefono());
                        st.setString(5, clave);
			st.execute();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}
    
    public Usuario existeUsuario(String usuario, String clave) {
            try {
                abrirConexion();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Usuarios WHERE email = ? AND clave = ?");
             pstmt.setString(1, usuario);
             pstmt.setString(2, clave);
             ResultSet rs = pstmt.executeQuery();
             Usuario u = null;
             if (rs.next()) {
                 u = new Usuario();
                 u.setId(rs.getInt("id"));
                 u.setEmail(rs.getString("email"));
             }
             pstmt.close();
             con.close();

             return u;
         } catch (SQLException ex) {
                 ex.printStackTrace();
         }
        return null;
    }
        
      public Usuario obtenerUsuario(int idUsuario) {
          try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Usuarios WHERE id = ?");
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            Usuario u = null;
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                
                u = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getString("telefono"));
            }
            pstmt.close();
            conn.close();

            return u;
         } catch (SQLException ex) {
                 ex.printStackTrace();
         }
        return null;
        }
      
    public ArrayList<Usuario> obtenerUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try {
                abrirConexion();
                String sql = "select * from Usuarios";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String email = rs.getString("email");
                    String telefono = rs.getString("telefono");

                    lista.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getString("telefono")));
                }
                rs.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
        return lista;
    }
    
    /* PRODUCTOS*/
    public boolean insertarProducto(Producto producto) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "INSERT INTO Productos (nombre,id_categoria,precio,descripcion,disponible,id_usuario,id_talle,id_genero,nombre_foto) VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, producto.getNombre());
                        st.setInt(2, producto.getCategoria().getId());
                        st.setFloat(3, producto.getPrecio());
                        st.setString(4, producto.getDescripcion());
                        st.setBoolean(5, producto.getDisponible());
                        st.setInt(6, producto.getUsuario().getId());
                        st.setInt(7, producto.getTalle().getId());
                        st.setInt(8, producto.getGenero().getId());
                        st.setString(9, producto.getNombreFoto());
                        
			st.execute();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}
    
    public Producto obtenerProducto(int idProducto) {
		Producto producto = null;
		try {
			abrirConexion();
			String sql = "select * from Productos where id=" + idProducto;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
                        if (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
                                int categoria = rs.getInt("id_categoria");
                                float precio = rs.getFloat("precio");
                                String descripcion = rs.getString("descripcion");
                                boolean disponible = rs.getBoolean("disponible");
                                int usuario = rs.getInt("id_usuario");
                                int talle = rs.getInt("id_talle");
                                int genero = rs.getInt("id_genero");
                                String nombreFoto = rs.getString("nombre_foto");
                                
                        producto = new Producto(id, nombre, obtenerCategoria(categoria), precio, descripcion, disponible,
                        obtenerUsuario(usuario), obtenerTalle(talle), obtenerGenero(genero), nombreFoto);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return producto;
    }
    
    public ArrayList<Producto> obtenerProductos(int idUsuario, boolean disponible, int generoFiltro) {
        String sql;
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {
                abrirConexion();
                if (idUsuario == 0)
                    sql = "select * from Productos WHERE 1=1";
                else
                    sql = "select * from Productos where id_usuario=" + idUsuario;
                if (disponible)
                    sql += " AND disponible=1";
                if (generoFiltro != 0)
                    sql += " AND id_genero=" + generoFiltro;
                
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                        int id = rs.getInt("id");
                        String nombre = rs.getString("nombre");
                        Categoria categoria = obtenerCategoria(rs.getInt("id_categoria"));
                        float precio = rs.getFloat("precio");
                        String descripcion = rs.getString("descripcion");
                        boolean disp = rs.getBoolean("disponible");
                        int usuario = rs.getInt("id_usuario");
                        Talle talle = obtenerTalle(rs.getInt("id_talle"));
                        Genero genero = obtenerGenero(rs.getInt("id_genero"));
                        String nombreFoto = rs.getString("nombre_foto");

                        lista.add(new Producto(id, nombre, categoria, precio, descripcion, disponible, obtenerUsuario(usuario), talle, genero, nombreFoto));
                }
                rs.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
        return lista;
    }
    
    public boolean modificarProducto(Producto producto) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "UPDATE Productos SET nombre=?,id_categoria=?, precio=?, descripcion=?, disponible=?, id_usuario=?, id_talle=?, id_genero=?, nombre_foto=? WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, producto.getNombre());
                        st.setInt(2, producto.getCategoria().getId());
                        st.setFloat(3, producto.getPrecio());
                        st.setString(4, producto.getDescripcion());
                        st.setBoolean(5, producto.getDisponible());
                        st.setInt(6, producto.getUsuario().getId());
                        st.setInt(7, producto.getTalle().getId());
                        st.setInt(8, producto.getGenero().getId());
                        st.setString(9, producto.getNombreFoto());
                        st.setInt(10, producto.getId());
                        
			st.executeUpdate();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}
    
    public void eliminarProducto(int idProducto) {
		Producto producto = null;
		try {
			abrirConexion();
			String sql = "DELETE FROM Productos WHERE id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
                        st.setInt(1, idProducto);
                        st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
    }
    
    public ArrayList<Venta> obtenerVentas(int idUsuario) {
        String sql;
        ArrayList<Venta> lista = new ArrayList<Venta>();
        try {
                abrirConexion();
                sql = "select * from Ventas where id_vendedor=" + idUsuario;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                        int id = rs.getInt("id");
                        Date fecha = rs.getDate("fecha");
                        Producto producto = obtenerProducto(rs.getInt("id_producto"));
                        FormaDePago formaDePago = obtenerFormaDePago(rs.getInt("id_forma_de_pago"));
                        Usuario comprador = obtenerUsuario(rs.getInt("id_comprador"));
                        Usuario vendedor = obtenerUsuario(rs.getInt("id_vendedor"));
                        boolean cancelado = rs.getBoolean("cancelado");
                        Reclamo reclamo = obtenerReclamoPorVenta(id);
                        String descripcionReclamo = "";
                        if (reclamo != null) {
                            descripcionReclamo = reclamo.getDescripcion();
                        }

                        lista.add(new Venta(id, fecha, producto, formaDePago, comprador, vendedor, cancelado, descripcionReclamo));
                }
                rs.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
        return lista;
    }
    
    public ArrayList<Venta> obtenerCompras(int idUsuario) {
        String sql;
        ArrayList<Venta> lista = new ArrayList<Venta>();
        try {
                abrirConexion();
                sql = "select * from Ventas where id_comprador=" + idUsuario;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                        int id = rs.getInt("id");
                        Date fecha = rs.getDate("fecha");
                        Producto producto = obtenerProducto(rs.getInt("id_producto"));
                        FormaDePago formaDePago = obtenerFormaDePago(rs.getInt("id_forma_de_pago"));
                        Usuario comprador = obtenerUsuario(rs.getInt("id_comprador"));
                        Usuario vendedor = obtenerUsuario(rs.getInt("id_vendedor"));
                        boolean cancelado = rs.getBoolean("cancelado");
                        Reclamo reclamo = obtenerReclamoPorVenta(id);
                        String descripcionReclamo = "";
                        if (reclamo != null) {
                            descripcionReclamo = reclamo.getDescripcion();
                        }
                        
                        lista.add(new Venta(id, fecha, producto, formaDePago, comprador, vendedor, cancelado, descripcionReclamo));
                }
                rs.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
        return lista;
    }
    
    /* COMPRAS DEL USUARIO*/

    public void actualizarProducto(Producto producto) {
        boolean inserto = false;
            try {
                abrirConexion();
                String sql = "UPDATE Productos "
                        + "SET nombre=?,id_categoria=?,"
                        + "precio=?,descripcion=?,disponible=?,"
                        + "id_usuario=?,id_talle=?,id_genero=?,"
                        + "nombre_foto=? WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, producto.getNombre());
                st.setInt(2, producto.getCategoria().getId());
                st.setFloat(3, producto.getPrecio());
                st.setString(4, producto.getDescripcion());
                st.setBoolean(5, producto.getDisponible());
                st.setInt(6, producto.getUsuario().getId());
                st.setInt(7, producto.getTalle().getId());
                st.setInt(8, producto.getGenero().getId());
                st.setString(9, producto.getNombreFoto());
                st.setInt(10, producto.getId());

                st.execute();
                inserto = true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                cerrarConexion();
            } 
    }

    public void insertarVenta(Venta venta) {
        boolean inserto = false;
        try {
                abrirConexion();
                String sql = "INSERT INTO Ventas (fecha,id_producto,id_forma_de_pago,id_comprador,id_vendedor, cancelado) VALUES (?,?,?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setDate(1, venta.getFecha());
                st.setInt(2, venta.getProducto().getId());
                st.setInt(3, venta.getFormaDePago().getId());
                st.setInt(4, venta.getComprador().getId());
                st.setInt(5, venta.getVendedor().getId());
                st.setBoolean(6, venta.isCancelado());

                st.execute();
                inserto = true;
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
    }

    public Venta obtenerVenta(int id) {
        String sql;
        Venta venta = null;
        try {
                abrirConexion();
                sql = "select * from Ventas where id=" + id;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                        Date fecha = rs.getDate("fecha");
                        Producto producto = obtenerProducto(rs.getInt("id_producto"));
                        FormaDePago formaDePago = obtenerFormaDePago(rs.getInt("id_forma_de_pago"));
                        Usuario comprador = obtenerUsuario(rs.getInt("id_comprador"));
                        Usuario vendedor = obtenerUsuario(rs.getInt("id_vendedor"));
                        boolean cancelado = rs.getBoolean("cancelado");
                        Reclamo reclamo = obtenerReclamoPorVenta(id);
                        String descripcionReclamo = "";
                        if (reclamo != null) {
                            descripcionReclamo = reclamo.getDescripcion();
                        }

                        venta = new Venta(id, fecha, producto, formaDePago, comprador, vendedor, cancelado, descripcionReclamo);
                }
                rs.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
        return venta;
    }

    public void actualizarVenta(Venta v) {
        try {
            abrirConexion();
            String sql = "UPDATE Ventas "
                    + "SET fecha=?,id_producto=?,"
                    + "id_forma_de_pago=?,id_comprador=?,id_vendedor=?,cancelado=?"
                    + " WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setDate(1, v.getFecha());
            st.setInt(2, v.getProducto().getId());
            st.setInt(3, v.getFormaDePago().getId());
            st.setInt(4, v.getComprador().getId());
            st.setInt(5, v.getVendedor().getId());
            st.setBoolean(6, v.isCancelado());
            st.setInt(7, v.getId());
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        } 
    }
    
    public Consulta obtenerConsulta(int id) {
        String sql;
        Consulta consulta = null;
        try {
                abrirConexion();
                sql = "select * from Consultas where id=" + id;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                        String con = rs.getString("consulta");
                        Producto producto = obtenerProducto(rs.getInt("id_producto"));
                        Usuario comprador = obtenerUsuario(rs.getInt("id_comprador"));
                        Usuario vendedor = obtenerUsuario(rs.getInt("id_vendedor"));

                        consulta = new Consulta(rs.getInt("id"), rs.getDate("fecha"), con, comprador, vendedor, producto);
                }
                rs.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
        return consulta;   
    }

    public ArrayList<Consulta> obtenerConsultas(int id) {
        String sql;
        ArrayList<Consulta> consultas = new ArrayList<Consulta>();
        try {
                abrirConexion();
                sql = "select * from Consultas where id_producto=" + id;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                        String consulta = rs.getString("consulta");
                        Producto producto = obtenerProducto(rs.getInt("id_producto"));
                        Usuario comprador = obtenerUsuario(rs.getInt("id_comprador"));
                        Usuario vendedor = obtenerUsuario(rs.getInt("id_vendedor"));

                        consultas.add(new Consulta(rs.getInt("id"), rs.getDate("fecha"), consulta, comprador, vendedor, producto));
                }
                rs.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
        return consultas;   
    }

    public void insertarConsulta(Consulta c) {
        boolean inserto = false;
        try {
                abrirConexion();
                String sql = "INSERT INTO Consultas (fecha,consulta,id_comprador,id_vendedor, id_producto) VALUES (?,?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setDate(1, c.getFecha());
                st.setString(2, c.getConsulta());
                st.setInt(3, c.getComprador().getId());
                st.setInt(4, c.getVendedor().getId());
                st.setInt(5, c.getProducto().getId());

                st.execute();
                inserto = true;
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
    }
    
    public void insertarReclamo(Reclamo r) {
        boolean inserto = false;
        try {
                abrirConexion();
                String sql = "INSERT INTO Reclamos (descripcion,id_venta,id_comprador,id_vendedor) VALUES (?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, r.getDescripcion());
                st.setInt(2, r.getVenta().getId());
                st.setInt(3, r.getComprador().getId());
                st.setInt(4, r.getVendedor().getId());

                st.execute();
                inserto = true;
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
    }

    public ArrayList<ReporteStockItem> obtenerReporteStockItems() {
        String sql;
        ArrayList<ReporteStockItem> items = new ArrayList<ReporteStockItem>();
        try {
            abrirConexion();
            sql = "SELECT id_categoria, id_talle, id_genero, COUNT(*) AS cantidad\n" +
                "FROM Productos\n" +
                "WHERE disponible=1\n" +
                "GROUP BY id_categoria, id_talle, id_genero";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Categoria categoria = obtenerCategoria(rs.getInt("id_categoria"));
                Talle talle = obtenerTalle(rs.getInt("id_talle"));
                Genero genero = obtenerGenero(rs.getInt("id_genero"));
                int cantidad = rs.getInt("cantidad");

                items.add(new ReporteStockItem(categoria, talle, genero, cantidad));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return items;
    }

    Consulta buscarRespuesta(int id) {
        String sql;
        Consulta consulta = null;
        try {
            abrirConexion();
            sql = "SELECT id, respuesta, fecha, id_comprador, id_vendedor\n" +
                "FROM Respuestas\n" +
                "WHERE id_consulta=" + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String respuesta = rs.getString("respuesta");
                
                Usuario comprador = obtenerUsuario(rs.getInt("id_comprador"));
                Usuario vendedor = obtenerUsuario(rs.getInt("id_vendedor"));

                consulta = new Consulta(rs.getInt("id"), rs.getDate("fecha"), respuesta, comprador, vendedor, null);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return consulta;
    }

    public void insertarRespuesta(Consulta respuesta, int idConsulta) {
        boolean inserto = false;
        try {
                abrirConexion();
                String sql = "INSERT INTO Respuestas (fecha,respuesta,id_comprador,id_vendedor, id_consulta) VALUES (?,?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setDate(1, respuesta.getFecha());
                st.setString(2, respuesta.getConsulta());
                st.setInt(3, respuesta.getComprador().getId());
                st.setInt(4, respuesta.getVendedor().getId());
                st.setInt(5, idConsulta);

                st.execute();
                inserto = true;
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
    }

    public void insertarValoracion(Valoracion v) {
        boolean inserto = false;
        try {
                abrirConexion();
                String sql = "INSERT INTO Valoraciones(puntaje, fecha, id_venta ,id_comprador, id_vendedor) VALUES (?,?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, v.getPuntaje());
                st.setDate(2, v.getFecha());
                st.setInt(3, v.getVenta().getId());
                st.setInt(4, v.getComprador().getId());
                st.setInt(5, v.getVendedor().getId());

                st.execute();
                inserto = true;
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
    }

    int buscarValoracion(int id) {
        String sql;
        int puntaje = 0;
        try {
            abrirConexion();
            sql = "SELECT puntaje\n" +
                "FROM Valoraciones\n" +
                "WHERE id_venta=" + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                puntaje = rs.getInt("puntaje");
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return puntaje;
    }

    public ArrayList<ReporteVendedoresItem> obtenerReporteVendedores(boolean ordenPorCantidad, java.sql.Date desde, java.sql.Date hasta) {
        String sql;
        int columnaOrden;
        String dateCondition = "";
        if (ordenPorCantidad) {
            columnaOrden = 4;
        } else {
            columnaOrden = 3;
        }
        if (desde != null) {
            dateCondition = "WHERE v.fecha BETWEEN '" + desde.toString() + "' AND '" + hasta.toString() + "'\n";
        }
        ArrayList<ReporteVendedoresItem> items = new ArrayList<ReporteVendedoresItem>();
        try {
            abrirConexion();
            sql = "SELECT u.nombre, u.apellido, COALESCE(AVG(va.puntaje), 0) as valoracion, COUNT(*) AS cantidad\n" +
                "FROM Ventas v JOIN Usuarios u ON v.id_vendedor=u.id LEFT JOIN Valoraciones va ON va.id_venta=v.id\n" +
                dateCondition +  
                "GROUP BY v.id_vendedor, u.nombre, u.apellido ORDER BY " + columnaOrden + " DESC";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String nombre = rs.getString("nombre") + " " + rs.getString("apellido");
                int cantidad = rs.getInt("cantidad");
                float valoracion = rs.getFloat("valoracion");

                items.add(new ReporteVendedoresItem(nombre, cantidad, valoracion));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        if (!ordenPorCantidad) {
            return new ArrayList(items.subList(0, Integer.min(items.size(), 10)));
        }
        return items;
    }

    public void actualizarUsuario(Usuario usuario, String clave) {
        String cadenaClave = "";
        if (!clave.equals("")) {
            cadenaClave = ", clave='" + clave + "'";
        }
        try {
                abrirConexion();
                String sql = "UPDATE Usuarios SET " +
                        "nombre=?, apellido=?, telefono=?" + cadenaClave +
                        " WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, usuario.getNombre());
                st.setString(2, usuario.getApellido());
                st.setString(3, usuario.getTelefono());
                st.setInt(4, usuario.getId());
                st.execute();
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
    }

    private Reclamo obtenerReclamoPorVenta(int id) {
        String sql;
        Reclamo reclamo = null;
        try {
                abrirConexion();
                sql = "select * from Reclamos where id_venta=" + id;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int idReclamo = rs.getInt("id");
                    String descripcion = rs.getString("descripcion");
                    Usuario comprador = obtenerUsuario(rs.getInt("id_comprador"));
                    Usuario vendedor = obtenerUsuario(rs.getInt("id_vendedor"));
                    Venta venta = new Venta();
                    venta.setId(id);

                    reclamo = new Reclamo(id, descripcion, venta, comprador, vendedor);
                }
                rs.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
                cerrarConexion();
        }
        return reclamo;
    }
        
    
}
