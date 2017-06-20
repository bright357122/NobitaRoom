package ntou.cs.wbse;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class QuizContextListener implements ServletContextListener {

	private ReadQuiz readQuiz;
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try
        {
    		readQuiz.closeFile();
        }
        catch (Exception exception)
        {
          exception.printStackTrace();
          System.exit(1);
        }
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext sc = sce.getServletContext();
        String filename = sc.getInitParameter("filename");
        filename = sc.getRealPath(filename);
        readQuiz = new ReadQuiz();
        
        readQuiz.openFile(filename);
        Quiz[] allQuizzes = readQuiz.readQuestions();
        
        sc.setAttribute("allQuizzes", allQuizzes);
    }
    
}
