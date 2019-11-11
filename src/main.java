import java.util.*;

public class main {

	public static void main(String[] args) {
		System.out.println("Welcome to the TIC-TAC-TOE game");
		System.out.println("Please choose an option on the menu screen");
		
		int option = 0;
		int gamesPlayed = 0;
	         
		
		
		      do{
		         
		         option = Menu(gamesPlayed);
		         
		         switch(option){
		         case 1:
		        	  gameboard.main(args);
		            break;
		            
		         case 2:
		            break;
		            
		         case 3:
		            break;
		    
		         case 4:
		            break;
		                 
		          case 5:
		            break;
		            
		         default:
		         System.out.println("You need to insert a valid option!");
		         }
		   
		      }while(option != 5);
	
		}
	
	   static int Menu(int gamesPlayed) {
		    
		   
		      Scanner myObj = new Scanner(System.in);
		      
		      
		      int gamePlayed = gamesPlayed;
		      
		      System.out.println("*****Menu*****\n");
		      System.out.println("Total persons inside the Array: " +gamePlayed);
		      System.out.println("");
		      System.out.println("1 - New Game");
		      System.out.println("2 - ScoreBoard");
		      System.out.println("3 - Reset all preferences");
		      System.out.println("5 - Exit");
		      System.out.println("Choose an operation: ");
		      int option = myObj.nextInt();
		      
		      return option;
		   }
	
	

}
