package to;

public class UsuarioTo {
	
	private int codigo;
	private String nome;
	private String senha;
	private boolean administrador;
	
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isAdministrador() {
		return administrador;
	}
	
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
}
