package teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import modelo.Cliente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ClienteTeste {
	Cliente cliente,copia;
	
	@Before
	public void setUp() throws Exception {
		cliente = new Cliente("Bela Lugosi", "123456789", "01111122333","Rua:aaaaa","08323-213");
		copia = new Cliente("Bela Lugosi", "123456789", "01111122333","Rua:aaaaa","08323-213");
	}
	
	public void test00Carregar() {
		Cliente fixture = new Cliente("nome1", "cpf1", "telefone1","endereco1","cep1");
		Cliente novo = new Cliente(null, null, null,null,null);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		cliente.inserir();
		cliente.carregar();
		copia.setCod_cliente(cliente.getCod_cliente());
		assertEquals("testa criacao", cliente, copia);
	}

	@Test
	public void test02Atualizar() {
		cliente.setTelefone("999999");
		copia.setTelefone("999999");		
		cliente.atualizar();
		assertEquals("testa inclusao", cliente, copia);
	}

	@Test
	public void test03Excluir() {
		cliente.setNome(null);
		cliente.setTelefone(null);
		copia.setNome(null);
		copia.setTelefone(null);
		cliente.deletar();
		assertEquals("testa inclusao", cliente, copia);
	}

}
