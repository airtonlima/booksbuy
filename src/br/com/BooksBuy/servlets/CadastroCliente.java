package br.com.BooksBuy.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BooksBuy.bean.Cliente;
import br.com.BooksBuy.bean.Endereco;
import br.com.BooksBuy.classes.ConsistenciaFisica;
import br.com.BooksBuy.classes.CriptoSHA_256;
import br.com.BooksBuy.dao.ClienteDAO;
import br.com.BooksBuy.dao.EnderecoDAO;

@WebServlet("/CadastroCliente")
public class CadastroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Cliente cl = new Cliente();
	
    public CadastroCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}

	protected void requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pagina = "";
		
		ConsistenciaFisica cF = new ConsistenciaFisica();
		
		String btnProsseguir = request.getParameter("btnProsseguir");
		
		if(btnProsseguir != null){
			
			String emailDigitado = request.getParameter("txtEmail");
			
			if (cF.validaEmail(emailDigitado)){
				
				pagina = "cadastroCliente.jsp";
				
				cl.setEmailCliente(emailDigitado);
				request.setAttribute("emailValidado", emailDigitado);
			}
			else
				pagina = "login.jsp";
		}
		else{
			String btnEnviarCadCli = request.getParameter("btnEnviarCadCli");
			if(btnEnviarCadCli != null){
				
				String txtCpf = request.getParameter("txtCpf");
				
				if(cF.validaCPF(txtCpf)){
					setDadosPessoais(request, response);
					setDadosEndereco(request, response);
				}
				else{
					pagina = "cadastroCliente.jsp";
					request.setAttribute("emailValidado", request.getParameter("txtEmail"));
					request.setAttribute("mensagem", "Consistência inválida. Favor inserir um CPF válido.");
				}
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
	
	protected void setDadosPessoais(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CriptoSHA_256 ck = new CriptoSHA_256();
		
		cl.setCpfCliente(request.getParameter("txtCpf"));
		cl.setNomeCompleto(request.getParameter("txtNomeCompleto"));
		cl.setEmailCliente(request.getParameter("txtEmail"));
		cl.setDataNascCliente(request.getParameter("txtDataNasc"));
		cl.setSexoCliente(request.getParameter("txtSexo"));
		cl.setCelularCliente(request.getParameter("txtCelular"));
		cl.setTelefoneCliente(request.getParameter("txtTelefoneFixo"));
		cl.setUsuarioCLiente(request.getParameter("txtUsuario"));
		cl.setSenhaCliente(ck.criptString(request.getParameter("txtSenha")));
		
		ClienteDAO dao = new ClienteDAO();
		dao.insert(cl);
	}
	
	protected void setDadosEndereco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Endereco en = new Endereco();
		
		en.setLogradouroEndereco(request.getParameter("txtLogradouro"));
		en.setNumeroResidenciaEndereco(request.getParameter("txtNumeroResid"));
		en.setCepEndereco(request.getParameter("txtCep"));
		en.setBairroEndereco(request.getParameter("txtBairro"));
		en.setComplementoEndereco(request.getParameter("txtComplemento"));
		en.setMunicipioEndereco(request.getParameter("txtMunicipio"));
		en.setEstadoEndereco(request.getParameter("txtEstado"));
		
		EnderecoDAO dao = new EnderecoDAO();
		dao.insert(en, cl);
	}
}