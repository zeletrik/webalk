package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Greetings
 */
@WebServlet("/Greetings")
public class Greetings extends HttpServlet {
	private static final int DEFAULT_MAX_TRIAL = 5;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Greetings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = (String) (request.getParameter("word") ==null ? "default" : request.getParameter("word"));
		String tryNo = (String) (request.getParameter("tryNo") ==null ? "5" : request.getParameter("tryNo"));
	
		int maxtrial;
		try{
		maxtrial = Integer.parseInt(tryNo);
		}catch(NumberFormatException ex){
			maxtrial = DEFAULT_MAX_TRIAL;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
