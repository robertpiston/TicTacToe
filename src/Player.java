import java.io.*;

public class Player {
	
	String playername;
	int playernumber;
	
	//constructor for Player class
	public Player(String name, int number){
		playername = name;
		playernumber = number;
	}
	
	//method returns the human player number
	public int getPlayerNumber() {
		return playernumber;
	}
	
	//method returns the human player's name
	public String getPlayerName() {
		return playername;
	}
	
	//method for asking the human player where they would like to place their 'X' or 'O'
	public int takePlayerTurn() {
		
		String mark = null;
		
		if(playernumber == 1)
			mark = "X";
		else
			mark = "O";
		
		System.out.print(playername + ": Where would you like to place a '" + mark + "': ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String locationstring = null;
		int location = -1;
		
		while(location < 0 || location > 8) {
			try{
				locationstring = br.readLine();				
				location = Integer.parseInt(locationstring);
				if(location < 0 || location > 8) {
					System.out.print("That is not a valid choice.  Please enter a number between 0 and 8: ");
				}
			}
			catch(Exception e){
				System.out.print("That is not a valid choice.  Please enter a number between 0 and 8: ");
			}
		}
		
		return location;
	}
	

}
