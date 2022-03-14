/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  Scanner sc = new Scanner(System.in);
  private String name;
  private int score;

  /* your code here - constructor(s) */
  public Player()
  {
    score = 0;
    System.out.println("Enter player name: ");
    name = sc.nextLine();
    System.out.println("Hello and welcome to the game " + name + "!");
  }

  public Player(String name)
  {
    score = 0;
    this.name = name;
    System.out.println("Hello and welcome to the game " + this.name + "!");
  }

  /* your code here - accessor(s) */
  public int getScore()
  {
    return score;
  }
  
  public String getName()
  {
    return name;
  }

  /* your code here - mutator(s) */ 
  public void setScore(int score)
  {
    this.score += score;
  }

  public void setName(String name)
  {
    this.name = name;
  }

}