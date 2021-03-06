package control.gestioneAmministratore;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AmministratoreManager;

/**
 * Servlet implementation class CambiaTipo
 */
@WebServlet("/CambiaTipo")
public class CambiaTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static AmministratoreManager am= new AmministratoreManager();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiaTipo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		String tipo= request.getParameter("tipo");
		
		try {
			am.cambiaTipo(email, tipo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("ricercaAccount?email="+email);
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
