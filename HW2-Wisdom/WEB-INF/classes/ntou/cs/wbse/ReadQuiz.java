package ntou.cs.wbse;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadQuiz
{
	private Scanner input;
//	private String filename = "quiz.txt";

	// enable user to open file
	public void openFile (String filename)
	{
		try
		{
			input = new Scanner(new File(filename), "utf-8");
		} // end try
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file.");
			System.exit(1);
		} // end catch
	} // end method openFile

	public void shuffleArray(ArrayList<Quiz> allQuizzesList)
	{
	    int index;
	    Quiz temp;
	    Random random = new Random();
	    for (int i = allQuizzesList.size() - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = allQuizzesList.get(index);
	        allQuizzesList.set(index,allQuizzesList.get(i));
	        allQuizzesList.set(i, temp);
	    }
	}
	
	// read quiz from file
	public Quiz[] readQuestions ()
	{
		ArrayList<Quiz> allQuizzesList = new ArrayList<Quiz>();
		int count = 0;

		try
		// read records from file using Scanner object
		{
			while (input.hasNextLine())
			{
				StringTokenizer tokens = new StringTokenizer(input.nextLine());
				Quiz quiz = new Quiz(count++);
				if (tokens.hasMoreTokens())
				{
					String token = tokens.nextToken();
					System.out.println("Question-" + count + ": " + token);
					quiz.setQuestion( token );
					quiz.setAnswer(1);
				}
				while (tokens.hasMoreTokens())
				{
					String token = tokens.nextToken();
					token = token.replace("-", " ");
					quiz.addOption( token );
					System.out.println("Option: " + token);
				}
				System.out.println(quiz);
		        allQuizzesList.add(quiz);
			} // end while
		} // end try
		catch (IllegalStateException stateException)
		{
			System.err.println("Error reading from file.");
			System.exit(1);
		} // end catch
//		shuffleArray(allQuizzesList);
		
		System.out.println("shuffleIndex: ");
	    for(int i=0; i<allQuizzesList.size(); i++)
	    	System.out.print(allQuizzesList.get(i).getId() + " ");
	    System.out.println();
	      
	      
		return (Quiz[])allQuizzesList.toArray(new Quiz[count]);
	} // end method readRecords

	// close file and terminate application
	public void closeFile ()
	{
		if (input != null)
			input.close(); // close file
	} // end method closeFile

/*	public static void main (String args[])
	{
		ReadQuiz rq = new ReadQuiz();
		rq.openFile();
		rq.readQuestions();
		rq.closeFile();
	} // end main
*/
} // end class ReadTextFile

