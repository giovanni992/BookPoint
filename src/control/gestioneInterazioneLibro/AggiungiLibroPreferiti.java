package control.gestioneInterazioneLibro;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DataManager;

/**
 * Servlet implementation class AggiungiLibroPreferiti
 */
@WebServlet("/AggiungiLibroPreferiti")
public class AggiungiLibroPreferiti extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static DataManager dm= new DataManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiLibroPreferiti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn= request.getParameter("isbn");
		String email= request.getParameter("email");

		try {
			dm.aggiungiLibroPreferiti(isbn, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("VisualizzaLibro.jsp");
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
