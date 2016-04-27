package teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import factory.ConectionFactory;

public class ConectionFactoryTeste {

	@Test
	public void testObterConexao() {
		try {
			Connection con =  ConectionFactory.conectar();
			assertNotNull("testa se a conexao nao e nula", ConectionFactory.conectar());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("gerou SQLException");
		}
	}

}
