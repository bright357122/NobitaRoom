package ntou.cs.wbse;

import java.util.ArrayList;
import java.util.Random;

public class Quiz
{
  private int id;
  private String question;
  private ArrayList<String> options;
  private int answer = 0;
  private Random randomNumbers;
  
  public Quiz(int id)
  {
    this.id = id;
    this.question = "";
    this.options = new ArrayList<String>();
    this.randomNumbers = new Random();
  }
  
  public void setQuestion(String q)
  {
    this.question = q;
  }
  
  public void setAnswer(int ans)
  {
    this.answer = ans;
  }
  
  public void addOption(String text)
  {
	  this.options.add(text);
  }
  
  public void shuffleOptions()
  {
    System.out.println("Question: " + question);
    int index = randomNumbers.nextInt(options.size());
    
    String temp = options.get(index);
    options.set(index, options.get(answer-1));
    options.set(answer-1, temp);
    setAnswer(index+1);
  }
  
  
  public int getId()
  {
    return id;
  }
  
  public String getQuestion()
  {
    return question;
  }
  
  public ArrayList<String> getOptions()
  {
    return options;
  }
  
  public int getAnswer()
  {
    return answer;
  }
  
  public String getAnswerText()
  {
    return options.get(answer-1);
  }
  
}
