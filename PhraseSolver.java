/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;

public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;
  /* your code here - constructor(s) */ 
  public PhraseSolver()
  {
    player1 = new Player();
    player2 = new Player();
    game    = new Board();
    solved  = false;
  }
  /* your code here - accessor(s) */
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    Player current = player1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      /* your code here - game logic */
      // display current player name
      System.out.println(current.getName() + " is guessing.");
      // show partially solved phrase
      System.out.println(game.getSolvedPhrase());
      // show point value of next guess
      game.setLetterValue();
      System.out.println("Point value is " + game.getLetterValue());
      /* your code here - determine how game ends */
      solved = true; 
    } 
   
  }
  
}