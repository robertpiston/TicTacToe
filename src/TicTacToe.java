import java.io.*;

public class TicTacToe {
	
	public static void main(String[] args) {
		
		//game selection text
		System.out.println("Welcome to Tic Tac Toe. Please select a game.");
		System.out.println("1: Human vs. Human");
		System.out.println("2: Human vs. AI");
		System.out.println("3: AI vs. Human");
		System.out.print("Please enter your choice: ");
		
		String gamechoice;
		int choice = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//loop to read game choice input and parse string to an integer
		//asks for new input if the input is not a valid game choice i.e. 1, 2, or 3
		while(choice <= 0 || choice > 3) {
			try{
				gamechoice = br.readLine();				
				choice = Integer.parseInt(gamechoice);
				if(choice <= 0 || choice > 3) {
					System.out.print("That is not a valid choice.  Please enter a 1, 2, or 3: ");
				}
			}
			catch(Exception e){
				System.out.print("That is not an integer.  Please enter a 1, 2, or 3: ");
			}
		}
		
		//instantiate a new Board object with a board size
		int boardsize = 9;
		Board board = new Board(boardsize);
		
		switch(choice) {
			case 1:
				String name1 = "Player 1";
				String name2 = "Player 2";
				Player player1 = new Player(name1, 1);
				Player player2 = new Player(name2, 2);
				int location1;
				int location2;
				String currentplayer;
				boolean winCondition = false;
				boolean validMove = false;
				
				board.printBoard();
				
				do {
					currentplayer = player1.getPlayerName();
					location1 = player1.takePlayerTurn();
					validMove = board.isValidMove(location1);
					board.addPlayerMove(player1, location1);
					winCondition = board.checkWinCondition();
					if(winCondition)
						break;
					board.printBoard();
					currentplayer = player2.getPlayerName();
					location2 = player2.takePlayerTurn();
					validMove = board.isValidMove(location2);
					board.addPlayerMove(player2, location2);
					board.printBoard();
					winCondition = board.checkWinCondition();
				}while(!winCondition);
				board.printBoard();
				System.out.println(currentplayer + " wins!");
				break;
				
			case 2:
				break;
				
			case 3:
				break;
		}
		

	}

}
