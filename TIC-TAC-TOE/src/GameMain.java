import java.util.Scanner;				// Scanner required for player input
/**
 * The main class for the game Tic-Tac-Toe.
 * Controls the flow of the game, allowing each player to enter an option until the game ends.
 */
public class GameMain {
	private static Scanner scanner = new Scanner(System.in);  // Scanner for input
	
	private Grid grid;					// The game board
	private boolean gameOver;			// Whether game is playing or over
	private Player winner;				// Winner of the game
	private Player currentPlayer;		// Current player (enum) 
   /**
    * Constructor
    * Sets up the game. Creates the grid and sets the values of the variables before calling the play method.
    */
   public GameMain() {
	   grid = new Grid();				//create instance of new grid
	   gameOver = false;				//reset gameOver to false
	   winner = null;					//set winner to null
	   currentPlayer = Player.X;		//set first player - change THIS to change first player
	   play();							//call play method
   }   
   /**
    * Controls the game play, rotates between player turns until a winner is decided.
    */
   public void play() {
	   do {
	         playerMove(currentPlayer);			// Have the player perform their move
	         grid.display();					// Display the current game board
	         checkForWinner(currentPlayer);		// Checks if the game has been won
	         
	         if(gameOver) {									// Display results if game is over
	        	 if(winner == Player.X) {					//if winner is X
		        	 System.out.println("Player X wins!");
		         }
	        	 else if(winner == Player.O) {				//if winner is O
	        		 System.out.println("Player O wins!");
	        	 }
	        	 else if(winner == Player.EMPTY){
	        		 System.out.println("It's a Draw!");	//if its a DRAW
	        	 }
	         }
	         if(currentPlayer == Player.X) {				// SWITCH turn to the next player
	        	 currentPlayer = Player.O;
	         } else {
	        	 currentPlayer = Player.X;
	         }	         
	      } while (!gameOver);  							// REPEAT until game-over
   } 
   /** 
    * Handles the player making their move, checks if the move is valid before making it.
    */
   public void playerMove(Player turnPlayer) {	   
      boolean validInput = false;      
      do {									// Display instructions to the player X,O
         if (turnPlayer == Player.X) {
            System.out.print("Player 'X', enter your move (row[1-"+Grid.ROWS+"] column[1-"+Grid.COLUMNS+"]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-"+Grid.ROWS+"] column[1-"+Grid.COLUMNS+"]): ");      	 
         }
         int row = scanner.nextInt();		//get ROW and COLUMN from PLAYER
         int col = scanner.nextInt();
         
         row--;								// -1 to allow for ARRAY INDEX
         col--;
         
         if (row >= 0 && row < Grid.ROWS && col >= 0 && col < Grid.COLUMNS && grid.board[row][col].content == Player.EMPTY) {
        	 grid.board[row][col].content = turnPlayer;
        	 grid.currentRow = row;						// check PLAYER entered values are valid
        	 grid.currentCol = col;						//if OK then set values for location and PLAYER MOVE
        	 validInput = true;							//ELSE ask for valid input
         } else {
        	 System.out.println("Sorry that move ["+(row+1)+","+(col+1)+" was not valid, Please try again.");
        	 validInput = false;
         }         
      } while (!validInput);   // Repeat until input is valid
   } 
   /**
    * Checks if the game has ended
    */
   public void checkForWinner(Player turnPlayer) {
      if (grid.hasWon(turnPlayer)) {	//IF PLAYER has WON
    	  winner = turnPlayer;			//set winner
    	  gameOver = true;				//set gameover
      }
      if (grid.isDraw()) {				//IF GAME is DRAW
    	  winner = Player.EMPTY;		//set winner
    	  gameOver = true;				//set gameover
      }
   } 
   /**
    * The main() method
    */
   public static void main(String[] args) {
	   boolean playAgain = true;
	   do {													//LOOP start
		   System.out.println("WELCOME TO TIC-TAC-TOE!");
		   new GameMain();									//welcome and INITIATE game, finishes and then...
		   System.out.println("Do you want to play again?");
		   System.out.println("(Enter Y/y for yes or any other key to exit)");
		   String input = scanner.next();
		   if(input.equals("Y")||input.equals("y")) {		//IF Y or y is pressed, then play again
			   playAgain = true;
		   }else {											//any other letter, then exit
			   playAgain = false;
			   System.out.print("GoodBye!!");
		   }
	   }while(playAgain);	   								//WHILE playAgain is TRUE
	}
}