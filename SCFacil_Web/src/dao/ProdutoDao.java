package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import to.ProdutoTo;

public class ProdutoDao {
	
	
	public void inserir(Connection conn, ProdutoTo to) {
		String sql = "INSERT INTO produto(nome, quantidade, valor_custo, valor_venda) VALUES (?,?,?,?)";

		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, to.getNome());
			stm.setInt(2, to.getQuantidade());
			stm.setDouble(3, to.getValorCusto());
			stm.setDouble(4, to.getValorVenda());
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
	
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System. out .print(e1.getStackTrace());
				}
			}
		}
	}
	
	public void atualizar (Connection conn, ProdutoTo to) {
		
		String sqlUpdate = "UPDATE produto SET nome = ?, quantidade = ?, valor_custo = ?, valor_venda = ? WHERE cod_produto = ?";

		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlUpdate);
			stm.setString(1, to.getNome());
			stm.setInt(2, to.getQuantidade());
			stm.setDouble(3, to.getValorCusto());
			stm.setDouble(4, to.getValorVenda());
			stm.setInt(5, to.getCodProduto());
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System. out .print(e1.getStackTrace());
				}
			}
		}
	}
	
	public void excluir(Connection conn, ProdutoTo to) {
		String sqlDelete = "DELETE FROM produto WHERE cod_produto = ?";

		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlDelete);
			stm.setInt(1, to.getCodProduto());
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (SQLException e1) {	
				System. out .print(e1.getStackTrace());
			}	
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System. out .print(e1.getStackTrace());
				}
			}
		}
	}
	
	
	public List<ProdutoTo> lista(Connection conn) {
		List<ProdutoTo> produtos = new ArrayList<>();
		String sql = " SELECT * FROM produto";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				ProdutoTo to;

				while (rs.next()) {
					to = new ProdutoTo();
					to.setCodProduto(rs.getInt("cod_produto"));
					to.setNome(rs.getString("nome"));
					to.setQuantidade(rs.getInt("quantidade"));
					to.setValorCusto(rs.getDouble("valor_custo"));
					to.setValorVenda(rs.getDouble("valor_venda"));
					produtos.add(to);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return produtos;
	}
	
	public ProdutoTo produtoPorId(Connection conn, int id) {
		ProdutoTo to = null;
		String sql = "SELECT * FROM produto where cod_produto = ?";

		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			// executa a consulta sql
			try(ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					to = new ProdutoTo();
					to.setCodProduto(rs.getInt("cod_produto"));
					to.setNome(rs.getString("nome"));
					to.setQuantidade(rs.getInt("quantidade"));
					to.setValorCusto(rs.getDouble("valor_custo"));
					to.setValorVenda(rs.getDouble("valor_venda"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return to;
	}
}
