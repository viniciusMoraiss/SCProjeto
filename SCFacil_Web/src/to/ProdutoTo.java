package to;

public class ProdutoTo {

	private int codProduto;
	private String nome;
	private int quantidade;
	private double valorCusto;
	private double valorVenda;
	
	
	public int getCodProduto() {
		return codProduto;
	}
	
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getValorCusto() {
		return valorCusto;
	}
	
	public void setValorCusto(double valorCusto) {
		this.valorCusto = valorCusto;
	}
	
	public double getValorVenda() {
		return valorVenda;
	}
	
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
}
