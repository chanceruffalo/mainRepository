package Ruffalo;

public class Checker {
	
	//ATTRIBUTES 
	private String user;
	private String response;
	
	//CONSTRUCTOR
	public Checker() {
		user = user;
		response = "";
	}
	
	public void check(String user) {
		this.user = user;
		//methods are created to keep clean the different checks
		//that are being performed
		if(checkLength()) {
			if(checkSpace()) {
				checkBlocks();
			}
		}
		
		
	}
	
	/**
	 * Method checkLength() will check the password length
	 */
	public boolean checkLength() {
		if(user.length() < 8 || user.length()>12) {
			response = "Please enter a password between the size \n of 8 and 12";
			return false;
		}
		return true;
	}
	
	/**
	 * Method checkSpace() will check to see if the user added a space 
	 */
	public boolean checkSpace() {
		for(int i = 0; i < user.length(); i ++) {
			if(user.charAt(i) == ' ') {
				response = "Please do not add any spaces to\n your password.";
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method checkBlocks will check for the letter blocks
	 */
	public void checkBlocks() {
		String temp = "";
		int count = 0;
		for(int i = 0; i < user.length(); i ++) {
			if (i != user.length()-1) {
				if(user.charAt(i) == user.charAt(i + 1)) {
					int tempCount = 0;
					for(int j = i ; j <user.length(); j ++) {
						if (j!= user.length()-1) {
							if(user.charAt(j) == user.charAt(j+1)) {
								tempCount += 1;
								i ++;
							}
						}
						else {
							if(count < tempCount) {
								count = tempCount;
							}
							break;
						}
					}
				}
			}
			
		}
		
		if(count <= 2) {
			response = "The largest block in the password is " + count + ".\n This is a decent password";
		}
		else {
			response = "The largest block in the password is " + count + 
					 ". \n this passwrod can be made \n stronger by reducing this block by " + (count - 2) + " .";
		}
	}
	
	public String getResponse() {
		return response;
	}
		
	

}
