package to;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import modelo.Cliente;
import modelo.Produto;

public class VendasTo {

	private int codVenda;
	private Calendar date;
	private Cliente cliente;
	private List<Produto> produtos = new ArrayList<>();
	
	
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
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
