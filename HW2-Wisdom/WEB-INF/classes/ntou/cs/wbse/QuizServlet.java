package ntou.cs.wbse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class QuizServlet extends HttpServlet {
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = getServletContext();
		Quiz[] allQuizzes = (Quiz[])sc.getAttribute("allQuizzes");
		
		HttpSession session = request.getSession();
		ArrayList<Integer> finishedID;
		int correctNum;
		if (session.getAttribute("myFinishedID") == null || session.getAttribute("myCorrectNum") == null)
		{
			System.out.println("Create finished ID array!");
			session.setAttribute("myFinishedID", new ArrayList<Integer>());
			session.setAttribute("myCorrectNum", 0);
			
		}
		finishedID = (ArrayList<Integer>) session.getAttribute("myFinishedID");
		correctNum = (int) session.getAttribute("myCorrectNum");
		
		if(finishedID.size() != allQuizzes.length){
			QuizSelector quizSelector = new QuizSelector(allQuizzes);
			Quiz selectedQuiz;
			do{
				selectedQuiz = quizSelector.getQuiz();
			}while(finishedID.contains(selectedQuiz.getId()));

			finishedID.add(selectedQuiz.getId());
			System.out.println("Finished ID: " + finishedID);
			System.out.println("Answer: " + selectedQuiz.getAnswer());
			
			request.setAttribute("quiz", selectedQuiz);
			request.setAttribute("quizNumber", finishedID.size());
			    
			RequestDispatcher view = request.getRequestDispatcher("Quiz-form.jsp");
			view.forward(request, response);
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<h1>總共答題數: " + finishedID.size() + "</h1><br>");
			out.println("<h1>共答對" + correctNum + "題</h1>");
			session.removeAttribute("myFinishedID");
			session.removeAttribute("myCorrectNum");
		}
		
	}

}
