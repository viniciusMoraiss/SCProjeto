package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Produto;
import modelo.Vendas;
import to.CaixaTo;

public class CaixaDao {
	
	public void cadastrar(Connection con, CaixaTo to, Vendas venda, Produto produto) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO caixa (quantidade, cod_venda, cod_produto) values (?, ?, ?)";
		
		try {
			// Salva caixa (itens venda)
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, to.getQuantidade());
			stmt.setInt(2, to.getVenda().getCodVenda());
			stmt.setInt(3, to.getProduto().getCod_produto());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
		}
	}

}
