package ntou.cs.wbse;

import java.util.Random;

public class QuizSelector
{
  private Quiz[] allQuizzes;
  private Random rand = new Random();
  
  public QuizSelector(Quiz[] allQuizzes)
  {
    this.allQuizzes = allQuizzes;
  }
  
  public Quiz getQuiz()
  {
    int choice = rand.nextInt(allQuizzes.length);
    allQuizzes[choice].shuffleOptions();
    return allQuizzes[choice];
  }
}
