package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConectionFactory;
import to.ClienteTo;

public class ClienteDao {
	
	private Connection con;

	public ClienteDao(){
		try {
			con = ConectionFactory.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inserir(ClienteTo to) {
		String sql = "INSERT INTO cliente (nome, cpf, telefone , endereco, cep) VALUES (?,?,?,?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, to.getNome());
			stmt.setString(2, to.getCpf());
			stmt.setString(3, to.getTelefone());
			stmt.setString(4, to.getEndereco());
			stmt.setString(5, to.getCep());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletar( ClienteTo to) {
		String sql = "DELETE FROM cliente WHERE cod_cliente = ? ";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, to.getCod_cliente());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public List<ClienteTo> lista() {
		List<ClienteTo> clientes = new ArrayList<>();
		String sql = " SELECT * FROM cliente";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				ClienteTo to;

				while (rs.next()) {
					to = new ClienteTo();
					to.setCod_cliente(rs.getInt("cod_cliente"));
					to.setNome(rs.getString("nome"));
					to.setCpf(rs.getString("cpf"));
					to.setTelefone(rs.getString("telefone"));
					to.setEndereco(rs.getString("endereco"));
					to.setCep(rs.getString("cep"));
					clientes.add(to);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return clientes;
	}
	
	
	public List<ClienteTo> lista(String chave) {
		List<ClienteTo> clientes = new ArrayList<>();
		String sql = " SELECT * FROM cliente WHERE UPPER(nome) LIKE ?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1,chave.toUpperCase()+ "%");
			try(ResultSet rs = stmt.executeQuery()) {
				ClienteTo to;

				while (rs.next()) {
					to = new ClienteTo();
					to.setCod_cliente(rs.getInt("cod_cliente"));
					to.setNome(rs.getString("nome"));
					to.setCpf(rs.getString("cpf"));
					to.setTelefone(rs.getString("telefone"));
					to.setEndereco(rs.getString("endereco"));
					to.setCep(rs.getString("cep"));
					clientes.add(to);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return clientes;
	}

	public void atualizar(ClienteTo to) {
		String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, endereco= ?, cep = ? WHERE cod_cliente = ?";
	
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, to.getNome());
			stmt.setString(2, to.getCpf());
			stmt.setString(3, to.getTelefone());
			stmt.setString(4, to.getEndereco());
			stmt.setString(5, to.getCep());
			stmt.setInt(6, to.getCod_cliente());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ClienteTo clientePorId(int id) {
		ClienteTo to = null;
		String sql = "SELECT * FROM cliente where id = ?";

		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			// executa a consulta sql
			try(ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					to = new ClienteTo();
					to.setCod_cliente(rs.getInt("cod_cliente"));
					to.setNome(rs.getString("nome"));
					to.setCpf(rs.getString("cpf"));
					to.setTelefone(rs.getString("telefone"));
					to.setEndereco(rs.getString("endereco"));
					to.setCep(rs.getString("cep"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return to;
	}
}
