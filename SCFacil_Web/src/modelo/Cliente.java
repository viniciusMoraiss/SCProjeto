package modelo;

import dao.ClienteDao;
import to.ClienteTo;

public class Cliente {
	private int cod_cliente;
	private String nome;
	private String cpf ;
	private String telefone;
	private String endereco;	
	private String cep;
	
	public Cliente(int cod_cliente, String nome) {
		this.cod_cliente = cod_cliente;
		this.nome = nome;
	}

	public Cliente(String nome, String cpf, String telefone, String endereco, String cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cep = cep;
	}

	
	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public void inserir(){
		ClienteDao dao = new ClienteDao();
		ClienteTo to = new ClienteTo();
		to.setCod_cliente(cod_cliente);
		to.setNome(nome);
		to.setCpf(cpf);
		to.setTelefone(telefone);
		to.setEndereco(endereco);
		to.setCep(cep);
		dao.inserir(to);
		}
	
	public ClienteTo getTo() {
		ClienteTo to = new ClienteTo();
		to.setCod_cliente(cod_cliente);
		to.setNome(nome);
		to.setCpf(cpf);
		to.setTelefone(telefone);
		to.setEndereco(endereco);
		to.setCep(cep);
		return to;
	}
	
		public void atualizar(){
		ClienteDao dao = new ClienteDao();
		ClienteTo to = new ClienteTo();
		to.setCod_cliente(cod_cliente);
		to.setNome(nome);
		to.setCpf(cpf);
		to.setTelefone(telefone);
		to.setEndereco(endereco);
		to.setCep(cep);
		dao.atualizar(to);
		}
		
		public void deletar(){
		ClienteDao dao = new ClienteDao();
		ClienteTo to = new ClienteTo();
		to.setCod_cliente(cod_cliente);
		dao.deletar(to);
		}
		
		public void carregar(){
		ClienteDao dao = new ClienteDao();
		ClienteTo to = dao.clientePorId(cod_cliente);
		nome = to.getNome();
		cpf = to.getCpf();
		telefone = to.getTelefone();
		endereco = to.getEndereco();
		cep = to.getCep();
		}
		
		@Override
		public String toString() {
			return "Cliente [cod_cliente=" + cod_cliente + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone
					+ ", endereco=" + endereco + ", cep=" + cep + "]";
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cliente other = (Cliente) obj;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
					return false;
			if (cpf == null) {
				if (other.cpf != null)
					return false;
			} else if (!cpf.equals(other.cpf))
					return false;
			if (telefone == null) {
				if (other.telefone != null)
					return false;
			} else if (!telefone.equals(other.telefone))
					return false;
			if (cod_cliente != other.cod_cliente)
					return false;
			if (endereco == null) {
				if (other.endereco != null)
					return false;
			} else if (!endereco.equals(other.endereco))
					return false;
			if (cep == null) {
				if (other.cep != null)
					return false;
			} else if (!cep.equals(other.cep))
					return false;
			return true;
		}
}