
public class Board {
	
	private int[] boardarray;
	
	//constructor for Board class
	public Board(int boardsize) {
		boardarray = new int[boardsize];
	}
	
	//method returns the current game state
	public int[] getGameState() {
		return boardarray;
	}
	
	//method prints the current board to the console
	public void printBoard() {
		System.out.println("  " + boardarray[0] + "  |  " + boardarray[1] +  "  |  " + boardarray[2]);
		System.out.println("-----|-----|-----");
		System.out.println("  " + boardarray[3] + "  |  " + boardarray[4] +  "  |  " + boardarray[5]);
		System.out.println("-----|-----|-----");
		System.out.println("  " + boardarray[6] + "  |  " + boardarray[7] +  "  |  " + boardarray[8]);

	}
	
	//method adds a human player's move to the board
	public void addPlayerMove(Player player, int location) {
		int mark;
		mark = player.getPlayerNumber();
		boardarray[location] = mark;
	}
	
	//method adds the AI move to the board
	public void addAIMove(AI ai, int location) {
		
	}
	
	//method checks for a valid player move
	public boolean isValidMove(int location) {
		if(boardarray[location] > 0)
			return false;
		else 
			return true;
	}
	
	//method checks if there is a win condition on the current board
	public boolean checkWinCondition() {
		//check verticals
		if((boardarray[0] == boardarray[3] && boardarray[3] == boardarray[6] && boardarray[0] > 0) || (boardarray[1] == boardarray[4] && boardarray[4] == boardarray[7] && boardarray[1] > 0) || (boardarray[2] == boardarray[5] && boardarray[5] == boardarray[8] && boardarray[2] > 0))
			return true;
		//check horizontals
		else if((boardarray[0] == boardarray[1] && boardarray[1] == boardarray[2] && boardarray[0] > 0) || (boardarray[3] == boardarray[4] && boardarray[4] == boardarray[5] && boardarray[3] > 0) || (boardarray[6] == boardarray[7] && boardarray[7] == boardarray[8] && boardarray[6] > 0)) 
			return true;
		//check diagonals
		else if((boardarray[0] == boardarray[4] && boardarray[4] == boardarray[8] && boardarray[0] > 0) || (boardarray[2] == boardarray[4] && boardarray[4] == boardarray[6] && boardarray[2] > 0))
			return true;
		//otherwise no win condition
		else
			return false;
	}

}
