/**
 * The Box class models each individual box of the Grid
 */
public class Box {

   Player content;			// The move this box holds (Empty, X, or O)
   int row, col; 			// Row and column of this box (Not currently used but possibly useful in future updates)
 
   /**
    * Constructor
    */
   public Box(int row, int col) {
	   this.row = row;				//CREATE BOX with passed ROW COL and clear content
	   this.col = col;
	   clear();
   } 
   /**
    * Clear the box content to EMPTY
    */
   public void clear() {
	   content = Player.EMPTY;			//set content to empty
   } 
   /**
    * Display the content of the box
    */
   public void display() {	   
	   switch(content) {				//use Contents of box to trigger case
	   case X: { 						//and print appropriate mark
		   System.out.print(" X ");		//in CASE of X 
		   break;
	   }
	   case O: { 
		   System.out.print(" O ");		//in CASE of O
		   break;
		   }
	   case EMPTY: { 
		   System.out.print("   ");		//in CASE of EMPTY
		   break;}
	   }
   }
}