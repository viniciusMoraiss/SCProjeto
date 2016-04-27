package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Cliente;
import to.ClienteTo;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/Cliente.do")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pAcao = request.getParameter("acao");
		String pCod_cliente = request.getParameter("cod_cliente");
		String pNome = request.getParameter("nome");
		String pCpf = request.getParameter("cpf");
		String pTelefone = request.getParameter("telefone");
		String pEndereco = request.getParameter("endereco");
		String pCep = request.getParameter("cep");
		
		int cod_cliente = -1;
		try {
			cod_cliente = Integer.parseInt(pCod_cliente);
		} catch (NumberFormatException e) {

		}

		Cliente cliente = new Cliente(pCod_cliente, pNome, pTelefone, pEndereco, pCep);
		RequestDispatcher view = null;
		
		
		if (pAcao.equals("Criar")) {
			cliente.inserir();
			ArrayList<ClienteTo> lista = new ArrayList<>();
			lista.add(cliente.getTo());
			HttpSession session = request.getSession();
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarClientes.jsp");
		} else if (pAcao.equals("Excluir")) {
			cliente.deletar();
			HttpSession session = request.getSession();
			ArrayList<ClienteTo> lista = (ArrayList<ClienteTo>)session.getAttribute("lista");
			ClienteTo to;
			for(int i = 0; i < lista.size(); i++){
				to = lista.get(i);
				if(to.getCod_cliente() == cliente.getCod_cliente()){
					lista.remove(i);
					session.setAttribute("lista", lista);
					break;
				}
			}
			view = request.getRequestDispatcher("ListarClientes.jsp");			
		} else if (pAcao.equals("Alterar")) {
			cliente.atualizar();
			HttpSession session = request.getSession();
			ArrayList<ClienteTo> lista = (ArrayList<ClienteTo>)session.getAttribute("lista");
			ClienteTo to;
			for(int i = 0; i < lista.size(); i++){
				to = lista.get(i);
				if(to.getCod_cliente() == cliente.getCod_cliente()){
					to.setNome(cliente.getNome());
					to.setCpf(cliente.getCpf());
					to.setTelefone(cliente.getTelefone());
					to.setEndereco(cliente.getEndereco());
					to.setCep(cliente.getCep());
					session.setAttribute("lista", lista);
					break;
				}
			}
			request.setAttribute("cliente", cliente.getTo());
			view = request.getRequestDispatcher("VisualizarCliente.jsp");			
		} else if (pAcao.equals("Visualizar")) {
			cliente.carregar();
			request.setAttribute("cliente", cliente.getTo());
			view = request.getRequestDispatcher("VisualizarCliente.jsp");		
		} else if (pAcao.equals("Editar")) {
			cliente.carregar();
			request.setAttribute("cliente", cliente.getTo());
			view = request.getRequestDispatcher("AlterarCliente.jsp");		
		}
		
		view.forward(request, response);
		
	}
}