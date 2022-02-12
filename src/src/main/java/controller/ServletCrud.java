package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carro;
import model.DAO;

/**
 * Servlet implementation class ServletCrud
 */
@WebServlet("/ServletCrud")
public class ServletCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private DAO daoCrud;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrud() {
        super();
        // TODO Auto-generated constructor stub
        this.daoCrud = new DAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		         ////////// SWITCH-CASE /////////////

		String opcoesVeiculo = request.getParameter("option");
		if (opcoesVeiculo == null) {
			opcoesVeiculo = "Opção Invalida";
		}
		switch(opcoesVeiculo) {
			case ("insertForm"):
				exibirTelaDeInsercaoVeiculo(request, response);
			break;
			
			case ("updateForm"):
				exibirTelaDeAtualizacaoVeiculo(request, response);
			break;
			case ("update"):
				atualizarVeiculo(request, response);
			break;
			case ("delete"):
				apagarVeiculo(request, response);
		break;
			case ("insert"):
				adicionarVeiculo(request, response);
			break;
			default:
			selecionarTodosVeiculos(request, response);
		}
			
	}
	

	
	
	private void exibirTelaDeInsercaoVeiculo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("formVeiculo.jsp").forward(request, response);
	}
	
	private void exibirTelaDeAtualizacaoVeiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("carroID"));
		Carro carro = this.daoCrud.buscarCarro(id);
		request.setAttribute("listaVeiculoForEach",carro);
		request.getRequestDispatcher("formVeiculo.jsp").forward(request, response);
	}
	
	private void adicionarVeiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nomeModeloB = request.getParameter("modeloDocarro");
		Integer anoCarroB  = Integer.parseInt(request.getParameter("anoDoCarro"));
		
		if ((nomeModeloB != null) && (anoCarroB != null) ) {
			if (!nomeModeloB.equals("")){
				Carro carro1 = new Carro(nomeModeloB, anoCarroB);
			this.daoCrud.novoCarro(carro1);
	}
		}
		response.sendRedirect("ServletCrud");
	}
	
	private void selecionarTodosVeiculos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	    request.setAttribute("itemsVeiculo", this.daoCrud.listaDeCarro());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	
	private void apagarVeiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCarro= request.getParameter("carroID");
		if (idCarro != null) {
			Integer id = Integer.parseInt(idCarro);
			this.daoCrud.removerCarro(id);
		}
		response.sendRedirect("ServletCrud");
	}
	
	private void atualizarVeiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String modeloCarro = request.getParameter("modeloCarroAlterar");
		String carroAno = request.getParameter("anoCarroAlterar");
		String idCarro = request.getParameter("carroID");
		if ((modeloCarro != null) && (carroAno != null) && (idCarro != null)) {
			if ( !modeloCarro.equals("") && !carroAno.equals("")  && !idCarro.equals("")  ){
		    Integer anoV = Integer.parseInt(carroAno);
			Integer id = Integer.parseInt(idCarro);
				Carro carro = new Carro(modeloCarro, anoV);
				carro.setIdcarro(id);
				this.daoCrud.updateCarro(carro);
			}
	}
		response.sendRedirect("ServletCrud");
	}

}
