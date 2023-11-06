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
  private Board board;
  private boolean solved;

  /* your code here - constructor(s) */
  public PhraseSolver() {
    this.player1 = new Player();
    this.player2 = new Player();
    this.board = new Board();
    solved = false;
  }

  /* your code here - accessor(s) */
  public Player getPlayer(int playerNum) {
    if (playerNum == 1) {
      return player1;
    } else if (playerNum == 2) {
      return player2;
    }
    return player2;
  }
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;

    int currentNum = 1;
    Player currentPlayer = getPlayer(currentNum);


    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    
    while (!solved) 
    {
      
      /* your code here - game logic */
      System.out.println("Its your turn "+ currentPlayer.getName());
      System.out.println(this.board.getSolvedPhrase());
      String guess = input.nextLine();
      solved = this.board.isSolved(guess);     
      
      /* your code here - determine how game ends */
      if (guess.length() == 1) {
        if (this.board.guessLetter(guess)) {
          System.out.println("You guessed a letter!");
          currentPlayer.setPoints(currentPlayer.getPoints() + 2);
        }
        else{
        currentNum = (currentNum == 1) ? 2 : 1;
        }
      } 
      else {
        if (this.board.isSolved(guess)) {
          System.out.println("Phrase solved!");
          break;
        }
        currentPlayer.setPoints(currentPlayer.getPoints() + 5);
      }
      if (!(this.board.getSolvedPhrase().contains("_"))) {
        solved = true;
        break;
      }
    } 
    System.out.println("You solved the phrase "+ this.board.getPhrase());
    System.out.println ("winner: " + currentPlayer.getName());
    System.out.println("Score: "+ currentPlayer.getPoints());

   
  }
  
}