package control.gestioneRicerca;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Libro;
import bean.Utente;
import model.LibroManager;

/**
 * Servlet implementation class Ricerca
 */
@WebServlet("/Ricerca")
public class Ricerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroManager manager = new LibroManager();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ricerca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String testo= request.getParameter("testo");
		String categoria= request.getParameter("categoria");
		
		Collection<Libro> libri=null;
		boolean nessunLibroTrovato=false;
		
		try {
			libri= manager.ricerca(testo, categoria);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(libri.size()==0) {
			nessunLibroTrovato= true;
		}
		request.getSession().setAttribute("nessunLibroTrovato", nessunLibroTrovato);
		request.getSession().setAttribute("libri", libri);
		
		String redirect="";
		Utente utente=(Utente)request.getSession().getAttribute("utente");
		
		if(utente==null){
			redirect="Libri.jsp";
		}
		else if(utente.getTipo().equalsIgnoreCase("cliente")){
			redirect="Libri.jsp";
		}
		else if(utente.getTipo().equalsIgnoreCase("amministratore")){
			redirect="AmministratoreCatalogo.jsp";
		}
		
		response.sendRedirect(redirect);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
