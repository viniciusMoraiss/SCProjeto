package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConectionFactory;
import to.UsuarioTo;

public class UsuarioDao {
	private Connection conn;

	public UsuarioDao() throws SQLException {
		conn = ConectionFactory.conectar();
	}

	public void inserir(UsuarioTo to) {
		String sql = "INSERT INTO usuarios(nome, senha, administrador) VALUES (?,?,?)";

		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, to.getNome());
			stm.setString(2, to.getSenha());
			stm.setBoolean(3, to.isAdministrador());
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UsuarioTo getUsuario(String nome, String senha) {
		UsuarioTo to = null;
		String sql = "SELECT * FROM usuarios where nome = ? and senha = ?";

		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, nome);
			stm.setString(2, senha);
			// executa a consulta sql
			rs = stm.executeQuery();

			while (rs.next()) {
				String nomeBanco = rs.getString("nome");
				String senhaBanco = rs.getString("senha");

				// retorna usuario se a senha e login for igual ao banco de
				// dados
				if (nomeBanco.equals(nome) && senhaBanco.equals(senha)) {
					to = new UsuarioTo();
					to.setNome(rs.getString("nome"));
					to.setAdministrador(rs.getBoolean("administrador"));
					return to;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return to;
	}

	public List<UsuarioTo> listar() {
		List<UsuarioTo> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM usuarios";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement(sql);

			// executa a consulta sql
			rs = stmt.executeQuery();

			UsuarioTo to;

			while (rs.next()) {
				// cria um objeto usuario com id, nome e admin
				to = new UsuarioTo();
				to.setCodigo(rs.getInt("codigo"));
				to.setNome(rs.getString("nome"));
				to.setAdministrador(rs.getBoolean("administrador"));

				// adiciona usuario na lista
				usuarios.add(to);
			}
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public void deletar(UsuarioTo to) {
		String sql = "DELETE FROM usuarios WHERE codigo = ? ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, to.getCodigo());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
