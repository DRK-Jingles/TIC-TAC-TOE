/**
 * The grid represents the game board.
 */
public class Grid {
	// Define the amount of rows and columns
	public static final int ROWS = 3;			// Rows
	public static final int COLUMNS = 3;		// Columns
	Box[][] board;								// Represents the game board as a grid
	int currentRow;								// Row that was played last
	int currentCol;								// Column that was played last
	int boxCount;								//Total amount of boxes in grid 
	
	/**
	 * Constructor
	 */
   public Grid() {
	  board = new Box[ROWS][COLUMNS];				//INITIATE board
	  
      for (int row = 0; row < ROWS; ++row) {			//FOR EVERY ROW...
         for (int col = 0; col < COLUMNS; ++col) {		//AND COLUMN index
            board[row][col] = new Box(row, col);		//INITIATE a BOX
            ++boxCount;									//add to box total count
         }
      }
   } 
   /**
    * Checks if the game has ended in a draw
    * One way to do this is to check that there are no empty positions left
    */
   public boolean isDraw() {
	   int fillCount = 0;										//create COUNTER for filled boxes
	   for(int row = 0; row < ROWS;++row) {						//FOR EVERY ROW..AND COLUMN index
		   for(int col = 0; col < COLUMNS; ++col) {
			   if(board[row][col].content != Player.EMPTY) {	//IF box is filled
				   ++fillCount;									//ADD to fill count
			   }
		   }
	   }
	   if(fillCount == boxCount) {		//IF the amount of boxes filled matches the total amount of boxes
		   return true;
	   }else {
		   return false;
	   }
   } 
   /**
    * Return true if the turn player has won after making their move at the coordinate given
    */
   public boolean hasWon(Player player) {		//check these conditions to see if winner
	   // Row check
	   if(board[currentRow][0].content == player && board[currentRow][1].content == player && board[currentRow][2].content == player) {
		   return true;
	   }
	   // Column check
	   if(board[0][currentCol].content == player && board[1][currentCol].content == player && board[2][currentCol].content == player) {
		   return true;
	   }
	   // Diagonal check one way
	   if(board[0][0].content == player && board[1][1].content == player && board[2][2].content == player) {
		   return true;
	   }
	   // Diagonal the other way
	   if(board[0][2].content == player && board[1][1].content == player && board[2][0].content == player) {
		   return true;
	   }
	   return false;			//if no matches for winner, Return false
   } 
   /**
    * Draws the tic-tac-toe board to the screen
    */
   public void display() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
        	 
        	 board[row][col].display();			// Draw the contents of the box
        	         	 
        	 if (col < COLUMNS - 1) System.out.print("|");	// Draw the vertical line        	 
    	 }
         System.out.println();         
         // Draw the horizontal line
         if (row < ROWS - 1) {
        	 System.out.println("-----------");
         }
      }
   }
}