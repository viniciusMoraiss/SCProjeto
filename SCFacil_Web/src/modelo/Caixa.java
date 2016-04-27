package modelo;

public class Caixa {

	private Vendas venda;
	private Produto produto;
	private Integer quantidade;
	
	public Caixa() {
	}

	public Caixa(Vendas venda, Produto produto, Integer quantidade) {
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
	}

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
