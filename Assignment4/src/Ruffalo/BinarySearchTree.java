package Ruffalo;

public class BinarySearchTree {
	//ATTRIBUTES
	private WordNode root;
	
	//CONSTRUCTOR
	public BinarySearchTree() {
		root = null;
	}
	
	//ADDING NODES
	public void addNode(String str) {
		WordNode x = new WordNode(str);
		if(root == null) {
			root = x;
			
		}
		else {
			insertAtLocation(root, x);
		}
	}
	//TRAVERSE - CALLING HELPER METHOD FOR TRAVERSAL
	public void traverseTree() {
		inOrderRecursion(root);
	}
	//CHECKWORD - NODE REMOVAL
	public void checkWord(String str) {
		deleteNode(root,str);
	}
	//SPELLCHECK - CHECK IF WORD IN TREE	
	public boolean spellCheck(String str) {
		WordNode ptr = root;
		while(ptr != null) {
			int check = ptr.word.compareToIgnoreCase(str);
			if(check > 0) {
				ptr = ptr.left;
			}
			else if(check < 0) {
				ptr = ptr.right;
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	private WordNode deleteNode(WordNode root, String str) {
		//BASE CASE
		if (root == null) {
			return root;
		}
		
		if(root.word.compareToIgnoreCase(str) > 0) {
			root.left = deleteNode(root.left, str);
			return root;
		}
		else if( root.word.compareToIgnoreCase(str) < 0) {
			root.right = deleteNode(root.right, str);
			return root;
		}
		
		
		if(root.left == null) {
			WordNode temp = root.right;
			return temp;
		}
		else if (root.right == null) {
			WordNode temp = root.left;
			return temp;
		}
		
		else {
			WordNode succParent = root;
			
			WordNode succ = root.right;
			
			while (succ.left != null) {
				succParent = succ;
				succ = succ.left;
			}
			
			if(succParent != root) {
				succParent.left = succ.right;
			}
			else {
				succParent.right = succ.right;
			}
			root.word = succ.word;
			
			return root;
		}
	}
	
	//HELPER METHOD: 
	private void insertAtLocation(WordNode tempRoot, WordNode x) {
		//SEARCHING THROUGH MOVING LEFT IF GREATER THAN OR RIGHT IF LESS
		while(true) {
			int checker = tempRoot.word.compareToIgnoreCase(x.word);
			//IF CHECKER IS GREATER THAN 0 WE MOVE LEFT
			if(checker > 0) {
				assert checker < 0: "Error when checker is shoudl be greater; is less than";
				if(tempRoot.left != null) {
					tempRoot = tempRoot.left;
				}
				else {
					tempRoot.left = x;
					break;
				}
			}
			//IF CHECKER EQUALS 0 WE DO NOTHING DUE TO DUPLICATION
			else if(checker == 0) {
				assert checker != 0: "Error when checker is shoudl be 0; is not";
				break;
			}
			//IF CHECKER LESS THAN 0 WE MOVE RIGHT
			else {
				assert checker > 0: "Error when checker is should be lesser; is greater than";
				if(tempRoot.right != null) {
					tempRoot = tempRoot.right;
				}
				else {
					tempRoot.right = x;
					break;
				}
			}
		}
	}
	//HELPER METHOD
	private void inOrderRecursion(WordNode ptr) {
		if(ptr != null) {
			inOrderRecursion(ptr.left);
			System.out.println(ptr.word);
			inOrderRecursion(ptr.right);
		}
	}
	
	
	
	
	
}
