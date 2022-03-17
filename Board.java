/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /* your code here - constructor(s) */
  public Board()
  {
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue();
  }
  
  /* your code here - accessor(s) */
  public String getSolvedPhrase() { return solvedPhrase; }

  public int getLetterValue() { return currentLetterValue; }

  /* your code here - mutator(s)  */
  public void setLetterVal(int val) { /* incomplete */ }

  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  /* Checks for a given letter guess in the phrase, returns whether or not the letter was in the phrase
    Precondition:
      phrase exists and is populated
      solvedPhrase exists and is popult\ated
    Postcondition:
      solvedPhrase is updated with any instances of the guessed letter revealed
  */
  public boolean guessLetter(String guess)
  {
    boolean foundLetter = false;
    String newSolvedPhrase = "";
    
    // iterate through the phrase
    for (int i = 0; i < phrase.length(); i++)
    {
      // if the guess is this character in the phrase
      if (phrase.substring(i, i + 1).equals(guess))
      {
        // add the guess and a space to the new solved phrase
        newSolvedPhrase += guess + " ";
        // letter has been found
        foundLetter = true;
      }
      else
      {
        // add the character from the solved phrase,
        // multiplying i by 2 to compensate for a space being after every character slot
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    // update the solved phrase
    solvedPhrase = newSolvedPhrase;
    // return whether or not the letter was found
    return foundLetter;
  } 
} 