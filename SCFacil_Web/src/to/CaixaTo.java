package to;

import modelo.Produto;
import modelo.Vendas;

public class CaixaTo {
	
	private Vendas venda;
	private Produto produto;
	private Integer quantidade;
	
	
	public Vendas getVenda() {
		return venda;
	}
	
	public void setVenda(Vendas venda) {
		this.venda = venda;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
