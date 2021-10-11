package Ruffalo;

public class WordNode {
	//ATTRIBUTES
	public String word;
	public WordNode left;
	public WordNode right;
	
	//CONSTRUCTOR
	public WordNode(String str) {
		word = str;
		left = null;
		right = null;
	}
	
}
