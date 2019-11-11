import java.util.*;

public class gameboard {
	
	public static int main(String[] args, int games) {
		
		int[][] board = new int[3][3];
		int move = 0;
		int player = 0;
		int playerWin = 0;
		
		System.out.println("*****Game Board****\n");
		System.out.println("Choose your move, but remember, first choose a letter and then a number!\n");
		
		
		do {
		showboard(board);
		
		
		if(move % 2 == 0) {
			System.out.println("Player X please choose your move");
			player = 1;
			move = playerMove(board, move, player);
		}else {
			System.out.println("Player O please choose your move");
			player = 2;
			move = playerMove(board, move, player);
		}
		
		playerWin = checkPlays(board, playerWin);
		
		
		}while(move <= 9 && playerWin != 1 && playerWin != 2);
		
		
		
		if(playerWin == 1) {
			System.out.println("The player X won the game!");
		}else {
			System.out.println("The player O won the game!");
		}
	
		
		games = games + 1;
		return games;
		
		}


	static void showboard(int board[][]) {
		
		System.out.println("  1 2 3");
		
		int check = 1;
		
		
		for(int i = 0; i < 3; i++) {
			//System.out.println(i+1);
			for(int j = 0; j < 3; j++) {
				if (check == 1 && board[i][j] != 0) {
					if(i+1 == 1) {
						if(board[i][j] == 1) {
							System.out.print("A " + "X" + " "); 
							check = 0;
						}else {
							System.out.print("A " + "O" + " "); 
							check = 0;
						}
					}else if (i+1 == 2){
						if(board[i][j] == 1) {
							System.out.print("B " + "X" + " "); 
							check = 0;
						}else {
							System.out.print("B " + "O" + " "); 
							check = 0;
						}
					}else if (i+1 == 3){
						if(board[i][j] == 1) {
							System.out.print("C " + "X" + " "); 
							check = 0;
						}else {
							System.out.print("C " + "O" + " "); 
							check = 0;
						}
					}
				}else if(check == 0 && board[i][j] != 0){
					if(board[i][j] == 1) {
						System.out.print("X" + " "); 
					}else {
						System.out.print("O" + " ");	
					}
				}else if(check == 1 && board[i][j] == 0) {
					if(i+1 == 1) {
						System.out.print("A " + "*" + " "); 
						check = 0;
					}else if (i+1 == 2){
						System.out.print("B " + "*" + " "); 
						check = 0;
					}else if (i+1 == 3){
						System.out.print("C " + "*" + " "); 
						check = 0;
					}
				}else {
					System.out.print("*" + " "); 
				}
			}
			check = 1;
			System.out.println();
		}	
	}
	
	static int playerMove(int board[][], int move, int player) {
		
		Scanner myObj = new Scanner(System.in);
		
		String letter;
		int row = 0;
		int col = 0;
		int cond = 0;
		int confirm = 0;
		
		do {
		do {
		do {
		System.out.println("\nInsert the letter that you want to play: ");
		letter = myObj.nextLine();
		letter = letter.toUpperCase();
		}while(!Arrays.asList("A", "B", "C").contains(letter));
		
		if(letter.equals("A")) {
			row = 0;
		}else if(letter.equals("B")){
			row = 1;
		}else {
			row = 2;
		}
		
		do {
		System.out.println("\nInsert the number that you want to play: ");
		col = myObj.nextInt();
		}while(col != 1 && col != 2 && col != 3);
		
		prevMove(board, player, row, col);
		
		System.out.println("\nIs this move correct? (digit 1 to continue)");
		cond = myObj.nextInt();
		
	
		
		
		}while(cond != 1);
		
		confirm = confirmDuplicated(board, player, row, col);
		
		}while(confirm == 1);
		
		regMatrix(board, player, row, col);
		
		move = move + 1;
		
			//myObj.close();
			
			return move;
		}
	
	static void prevMove(int board[][], int player, int row, int col) {
		

		System.out.println("  1 2 3");
		
		int check = 1;
		
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == row && j == col-1 && player == 1) {
					if (check == 1) {
						if(i+1 == 1) {
							System.out.print("A " + "X" + " "); 
							check = 0;
						}else if (i+1 == 2){
							System.out.print("B " + "X" + " "); 
							check = 0;
						}else if (i+1 == 3){
							System.out.print("C " + "X" + " "); 
							check = 0;
						}
					}else {
						System.out.print("X" + " "); 
					}
			}else if (i == row && j == col-1 && player == 2) {
				if (check == 1) {
					if(i+1 == 1) {
						System.out.print("A " + "O" + " "); 
						check = 0;
					}else if (i+1 == 2){
						System.out.print("B " + "O" + " "); 
						check = 0;
					}else if (i+1 == 3){
						System.out.print("C " + "O" + " "); 
						check = 0;
					}
				}else {
					System.out.print("O" + " "); 
				}
			}else {
				if (check == 1) {
					if(i+1 == 1) {
						System.out.print("A " + "*" + " "); 
						check = 0;
					}else if (i+1 == 2){
						System.out.print("B " + "*" + " "); 
						check = 0;
					}else if (i+1 == 3){
						System.out.print("C " + "*" + " "); 
						check = 0;
					}
				}else {
					System.out.print("*" + " "); 
				}
			}
			}
			check = 1;
			System.out.println();
		}	

		}
	
	static void regMatrix(int board[][], int player, int row, int col) {
			
			
			board[row][col-1] = player;
		
		
			
		System.out.println("Succefully registered!");
			
			
			}
	
	static int confirmDuplicated(int board[][], int player, int row, int col) {
		
		int confirm = 0;
		
		
		if (board[row][col-1] == 1 || board[row][col-1] == 2) {
			confirm = 1;
			System.out.println("You can't play in a position already played!");
			System.out.println("Choose another move!");
		}else {
		confirm = 5;
		}
		
		return confirm;
		
		
		}
	
	static int checkPlays(int board[][], int player) {
		
		int confirm = 0;
		
		if (board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1) {
			confirm = 1;
		}else if (board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1){
			confirm = 1;
		}else if (board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1){
			confirm = 1;
		}else if (board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1){
			confirm = 1;
		}else if (board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1){
			confirm = 1;
		}else if (board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1){
			confirm = 1;
		}else if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1){
			confirm = 1;
		}else if (board[2][0] == 1 && board[1][1] == 1 && board[0][2] == 1){
			confirm = 1;
		}else if (board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 2) {
			confirm = 2;
		}else if (board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 2){
			confirm = 2;
		}else if (board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 2){
			confirm = 2;
		}else if (board[0][0] == 2 && board[1][0] == 2 && board[2][0] == 2){
			confirm = 2;
		}else if (board[0][1] == 2 && board[1][1] == 2 && board[2][1] == 2){
			confirm = 2;
		}else if (board[0][2] == 2 && board[1][2] == 2 && board[2][2] == 2){
			confirm = 2;
		}else if (board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2){
			confirm = 2;
		}else if (board[2][0] == 2 && board[1][1] == 2 && board[0][2] == 2){
			confirm = 2;
		}else {
			confirm = 0;
		}
		
		
		return confirm;
		
		
		}
}
