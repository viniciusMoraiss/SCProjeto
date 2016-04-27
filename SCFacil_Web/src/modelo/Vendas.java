package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dao.ClienteDao;
import dao.ProdutoDao;
import factory.ConectionFactory;
import to.ClienteTo;

public class Vendas {

	private int codVenda;
	private Calendar date;
	private Cliente cliente;
	private List<Produto> produtos = new ArrayList<>();
	
	public Vendas() {
	}

	public Vendas(Cliente cliente, Calendar date) {
		this.date = date;
		this.cliente = cliente;
	}

	public int getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void addProdutos(Produto produto, Integer quantidade) {
		
		try {
			Connection con = ConectionFactory.conectar(); 
			// recupera quantidade de produtos do banco de dados
			int quantidadeBanco = new ProdutoDao().produtoPorId(con, produto.getCod_produto()).getQuantidade();
			
			if (produtos.size() > 0) {
				// verificar se produto já está na lista, se nao estiver retorna nulo
				if (getProdutoLista(produto, produtos) != null) {
					if (quantidade + produto.getQuantidade() <= quantidadeBanco) {
						produto.setQuantidade(quantidade + produto.getQuantidade());
					} else {
						throw new IllegalArgumentException("Quantidade insuficiente");
					}
				} else if (quantidade <= quantidadeBanco) {
					produto.setQuantidade(quantidade);
					produtos.add(produto);
				} else {
					throw new IllegalArgumentException("Quantidade insuficiente");
				}

			} else if (quantidade <= quantidadeBanco) {
				produto.setQuantidade(quantidade);
				produtos.add(produto);
			} else {
				throw new IllegalArgumentException("Quantidade insuficiente");
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private Produto getProdutoLista(Produto produto, List<Produto> produtos) {
		// verificar se produto já está na lista
		for (int i = 0; i < produtos.size(); i++) {
			// se estiver soma a quantidade com a já inserida
			if (produto.getCod_produto() == produtos.get(i).getCod_produto()) {
				return produto;
			}
		}
		return null;
	}
	
	public ArrayList<ClienteTo> listarClientes(){
		ArrayList<ClienteTo> lista;
		ClienteDao dao = new ClienteDao();
		lista = (ArrayList<ClienteTo>) dao.lista();
		return lista;
	}
	
	public ArrayList<ClienteTo> listarClientes(String chave){
		ArrayList<ClienteTo> lista;
		ClienteDao dao = new ClienteDao();
		lista = (ArrayList<ClienteTo>) dao.lista(chave);
		return lista;
	}


}
