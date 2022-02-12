package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DAOipva;
import model.Ipva;

/**
 * Servlet implementation class ServletIpva
 */
@WebServlet("/ServletIpva")
public class ServletIpva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private DAOipva dI;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIpva() {
        super();
        // TODO Auto-generated constructor stub
        this.dI = new DAOipva();
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

        ////////// SWITCH-CASE /////////////

String opcoesipva = request.getParameter("option");
if (opcoesipva == null) {
	opcoesipva = "Opção Invalida";
}
switch(opcoesipva) {
	case ("insertForm"):
		exibirTelaDeInsercaoipva(request, response);
	break;
	
	case ("updateForm"):
		exibirTelaDeAtualizacaoipva(request, response);
	break;
	case ("update"):
		atualizaripva(request, response);
	break;
	case ("delete"):
		apagaripva(request, response);
break;
	case ("insert"):
		adicionaripva(request, response);
	break;
	default:
	selecionarTodosipvas(request, response);
}
	
	}





private void exibirTelaDeInsercaoipva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
request.getRequestDispatcher("formIpva.jsp").forward(request, response);
}

private void exibirTelaDeAtualizacaoipva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
Integer id = Integer.parseInt(request.getParameter("ipvaID"));
Ipva ipva= this.dI.buscarIpva(id);
request.setAttribute("listaIpvaForEach",ipva);
request.getRequestDispatcher("formIpva.jsp").forward(request, response);
}

private void adicionaripva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
Integer anoIpva  = Integer.parseInt(request.getParameter("anoIpva"));

if ((anoIpva != null) ) {
		Ipva ipva = new Ipva(anoIpva);
	this.dI.newIpva(ipva);
}
response.sendRedirect("ServletIpva");
}

private void selecionarTodosipvas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

request.setAttribute("itemsIpva", this.dI.ipvaList());
request.getRequestDispatcher("ipva.jsp").forward(request, response);
}


private void apagaripva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String idIpva= request.getParameter("ipvaID");
if (idIpva!= null) {
	Integer id = Integer.parseInt(idIpva);
	this.dI.excluirIpva(id);;
}
response.sendRedirect("ServletIpva");
}

private void atualizaripva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String anoIpva = request.getParameter("ipvaAno");
String idipva = request.getParameter("ipvaID");
if ((idipva  != null)) {
	if (!idipva.equals("") && !anoIpva.equals("") ){
		
   Integer anoI = Integer.parseInt(anoIpva);
	Integer id = Integer.parseInt(idipva);
		Ipva ipva = new Ipva(anoI);
		ipva.setId(id);
		this.dI.atualizaIpva(ipva);
	}
}
response.sendRedirect("ServletIpva");
}


}
