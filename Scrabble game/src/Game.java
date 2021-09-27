
public class Game {

	/**
	 * Game class
	 * @author Chance Ruffalo
	 * @title Assignment 2
	 * @param word => This variable will store our user's word
	 * @param response => This variable will store our answer to the user
	 */
	//ATTRIBUTES OF GAME
	private String word;
	private String response;
	
	/**
	 * Game()
 - Does not take in an variables	 */
	//CONSTRUCTING GAME
	public Game() {
		word = "";
		response = "";
	}
	
	/**
	 * 
	 * @param user => user input
	 */
	public void newWord(String user) {
		if(checkWord(user)) {
			populateResponse(user);
		}
		else {
			response = "The wizards at scrabble can't use that!";
		}
	}
	
	
	public void populateResponse(String user) {
		
		for(int i = 0 ; i < user.length(); i ++) {
			for(int j = 0 ; j < user.length(); j ++) {
				for(int x = 0 ; x < user.length(); x ++) {
					for(int y = 0 ; y < user.length(); y ++) {
						response += user.substring(i, i + 1) + user.substring(j, j + 1) + user.substring(x, x + 1) + user.substring(y, y + 1) + " "; 
					}	
					response +="\n";
				}	
			}	
		}
		
		
		 
	}
	
	public boolean checkWord(String x) {
		if(x.matches(".*\\d.*") || (x.length() !=4 )) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String getResponse() {
		return response;
	}
	
}




