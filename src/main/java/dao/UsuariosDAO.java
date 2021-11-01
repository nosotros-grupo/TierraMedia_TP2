package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.TreeMap;

import jdbc.ConnectionProvider;
import tierraMedia.Usuario;
import tierraMedia.Atraccion;
import tierraMedia.TipoAtraccion;

public class UsuariosDAO {
	
	public static void cargarItinerario(Usuario usuario, TreeMap<Integer, LinkedList<Atraccion>> itinerarios) {
			for (Atraccion a : itinerarios.get(usuario.getId())){
				usuario.agregarAtraccion(a);
			}
	}
	
	public static LinkedList<Usuario> findAll() throws SQLException {
		String sql = "SELECT * FROM usuarios";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		while (resultados.next()) {
			usuarios.add(toUser(resultados));
		}
		conn.close();
		return usuarios;
	
	}
	
	public static void IngresarNuevoUsuario(LinkedList<String> usuarioNuevo) throws SQLException {
		String sql = "INSERT INTO usuarios (presupuesto, tiempoDisponible, tipoDeAtraccion, Nombre) VALUES (?,?,?,?)";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, Integer.valueOf(usuarioNuevo.get(0)));
		statement.setDouble(2, Double.valueOf(usuarioNuevo.get(1)));
		statement.setString(3, usuarioNuevo.get(2).toUpperCase());
		statement.setString(4, usuarioNuevo.get(3));
		statement.executeUpdate();
		
		conn.close();
	}
	
	
	
	private static Usuario toUser(ResultSet resultados) throws SQLException {
		return new Usuario(resultados.getInt(1), resultados.getDouble(2), TipoAtraccion.valueOf(resultados.getString(3)), resultados.getString(4), resultados.getInt(5));
	}
	
	public static void actualizarUsuarios(Usuario usuario) throws SQLException {
		String sql = "UPDATE usuarios SET presupuesto = ?, tiempoDisponible = ? WHERE Nombre = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, usuario.getPresupuesto());
		statement.setDouble(2, usuario.getTiempoDisponible());
		statement.setString(3, usuario.getName());
		statement.executeUpdate();
		
		conn.close();
	}
}

