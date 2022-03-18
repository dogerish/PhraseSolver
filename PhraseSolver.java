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
    
    String guesses = "";
    while (!solved)
    {

      // show partially solved phrase
      System.out.println(game.getSolvedPhrase());
      // show point value of next guess
      game.setLetterValue();
      System.out.println("Point value is " + game.getLetterValue());
      // display current player name
      System.out.println(current.getName() + " is guessing:");
      
      String guess = input.nextLine();
      //Gets a valid guess
      while (guess.length() == 0 || guesses.contains(guess))
      {
        System.out.println("Invalid guess. Try again");
        guess = input.nextLine();
      }
      //keeps track of past guesses
      guesses += guess;
      boolean correct = false;
      //checks a guessed phrase
      if (guess.length() > 1) 
      {
        if (game.isSolved(guess))
          correct = solved = true;
      }
      //checks a guessed letter
      else if (game.guessLetter(guess))
      {
        correct = true;
        if (!game.getSolvedPhrase().contains("_")) solved = true;
      }
      //updates score or swaps players
      if (correct) current.setScore(game.getLetterValue());
      else current = (current == player1) ? player2 : player1;
    }
    current = (player1.getScore() > player2.getScore()) ? player1 : player2;
    System.out.println(current.getName() + " won with " + current.getScore() + "!");
  }

}