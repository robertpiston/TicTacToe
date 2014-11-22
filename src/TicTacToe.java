import java.io.*;

public class TicTacToe {
	
	public static void main(String[] args) {
		
		int choice = Intro();
		
		//instantiate a new Board object with a board size of 9 for Tic Tac Toe
		final int boardsize = 9;
		Board board = new Board(boardsize);
		
		switch(choice) {
			case 1:
				HumanvsHuman(board);
				break;
				
			case 2:
				HumanvsAI(board);
				break;
				
			case 3:
				AIvsHuman(board);
				break;
		}
	}
	
	public static int Intro() {
		
		//game selection text
		System.out.println("Welcome to Tic Tac Toe. Please select a game.");
		System.out.println("1: Human vs. Human");
		System.out.println("2: Human vs. AI");
		System.out.println("3: AI vs. Human");
		System.out.print("Please enter your choice: ");
		
		String gamechoice;
		int c = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//loop to read game choice input and parse string to an integer
		//asks for new input if the input is not a valid game choice i.e. 1, 2, or 3
		while(c <= 0 || c > 3) {
			try{
			    gamechoice = br.readLine();				
				c = Integer.parseInt(gamechoice);
				if(c <= 0 || c > 3)
					System.out.print("That is not a valid choice.  Please enter a 1, 2, or 3: ");
			}
			catch(Exception e) {
				System.out.print("That is not an integer.  Please enter a 1, 2, or 3: ");
			}
		}
		
		return c;
	}

	public static void HumanvsHuman(Board board) {
		String currentplayer = null;
		boolean winCondition = false;
		int location1 = 0;
		int location2 = 0;
		String name1 = "Player 1";
		String name2 = "Player 2";
		Player player1 = new Player(name1, 1);
		Player player2 = new Player(name2, 2);
		
		board.printBoard();
		
		while(!winCondition) {
			boolean p1validMove = false;
			boolean p2validMove = false;
			currentplayer = player1.getPlayerName();
			while(!p1validMove) {
				location1 = player1.takePlayerTurn();
				p1validMove = board.isValidMove(location1);
			}
			board.addPlayerMove(player1, location1);
			winCondition = board.checkWinCondition();
			if(winCondition)
				break;
			board.printBoard();
			currentplayer = player2.getPlayerName();
			while(!p2validMove) {
				location2 = player2.takePlayerTurn();
				p2validMove = board.isValidMove(location2);
			}
			board.addPlayerMove(player2, location2);
			board.printBoard();
			winCondition = board.checkWinCondition();
		}
		board.printBoard();
		System.out.println(currentplayer + " wins!");
		
	}
	
	public static void HumanvsAI(Board board) {
		
	}
	
	public static void AIvsHuman(Board board) {
		
	}
}


