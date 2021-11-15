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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


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
                        st.setString(5, producto.getDisponible());
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
                                String disponible = rs.getString("disponible");
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
    
    public ArrayList<Producto> obtenerProductos(int idUsuario) {
        String sql;
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {
                abrirConexion();
                if (idUsuario == 0)
                    sql = "select * from Productos";
                else
                    sql = "select * from Productos where id_usuario=" + idUsuario;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                        int id = rs.getInt("id");
                        String nombre = rs.getString("nombre");
                        Categoria categoria = obtenerCategoria(rs.getInt("id_categoria"));
                        float precio = rs.getFloat("precio");
                        String descripcion = rs.getString("descripcion");
                        String disponible = rs.getString("disponible");
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
}
