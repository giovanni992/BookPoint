package control.gestioneOrdine;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Ordine;
import model.DataManager;
import model.GestioneOrdineManager;

/**
 * Servlet implementation class VisualizzaStorico
 */
@WebServlet("/VisualizzaStorico")
public class VisualizzaStorico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestioneOrdineManager manager = new GestioneOrdineManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaStorico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		Collection<Ordine> ordini=null;
		try {
			ordini= manager.visualizzaStorico(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("ordini", ordini);
		RequestDispatcher dispatcher= request.getRequestDispatcher("IMieiOrdini.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
