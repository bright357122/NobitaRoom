package ntou.cs.wbse;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SolutionServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Quiz[] allQuizzes = (Quiz[])getServletContext().getAttribute("allQuizzes");
	    int id = Integer.parseInt(request.getParameter("id"));
	    int solution = allQuizzes[id].getAnswer();
	    int ans = Integer.parseInt(request.getParameter("ans"));
	    
	    HttpSession session = request.getSession();
	    int correctNum;
	    
	    correctNum = (int) session.getAttribute("myCorrectNum");
	    
	    if (ans == solution)
	    {
	      request.setAttribute("correct", "yes");
	      correctNum++;
	      session.setAttribute("myCorrectNum", correctNum);
	      
	    }
	    else
	    {
	      request.setAttribute("correct", "no");
	      request.setAttribute("answer", allQuizzes[id].getAnswerText());
	    }
	    
	    RequestDispatcher view = request.getRequestDispatcher("result.jsp");
	    view.forward(request, response);
	}

}
