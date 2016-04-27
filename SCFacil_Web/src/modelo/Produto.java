package modelo;

//import java.awt.Component;

public class Produto {

	private int codProduto;
	private String nome;
	private int quantidade;
	private double valorCusto;
	private double valorVenda;
	
	public Produto(){
		
	}

	public Produto(String nome, int quantidade, double valorCusto, double valorVenda) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
	}

	public int getCod_produto() {
		return codProduto;
	}

	public void setCod_produto(int cod_produto) {
		this.codProduto = cod_produto;
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
	
	@Override
	public String toString() {
		return nome;
	}

	public Double getValorTotal() {
		return valorVenda * quantidade;
	}

}
