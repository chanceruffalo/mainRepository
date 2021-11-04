
public class BiSearchTree {
	private MethodNode root;
	private String ans;
	//CONSTRUCTOR - SETS ANS WITH USER FRIENDLY INFORMATION
	public BiSearchTree() {
		root = null;
		ans = "Methods will only show the first 3 letters";
	}

	public void addNode(String str) {
		String temp = "";
		for(int i = 0; i < str.length(); i ++) {
			if(str.charAt(i) != '(') {
				temp += str.charAt(i);
			}
			else {
				break;
			}
		}
		//WE USE SUBSTRING TO AVOID DATA STRUCTOR PARAMETERS SINCE WE ARE ONLY CONCERNED WITH THE STRUCTURE IT SELF
		MethodNode x = new MethodNode(temp);
		if(root == null) {
			root = x;
		}
		else {
			insertAtLocation(root, x);
		}
	}

	private void insertAtLocation(MethodNode root, MethodNode x) {
		while(true) {
			int check = root.method.compareToIgnoreCase(x.method);
			if(check > 0) {
				if(root.left != null) {
					root = root.left;
				}
				else {
					root.left = x;
					break;
				}
			}
			//INCREMENT COUNT SINCE WE SEE A DUPLICATE
			else if(check == 0) {
				root.increment();
				break;
			}
			else {
				if(root.right != null) {
					root = root.right;
				}
				else {
					root.right = x;
					break;
				}
			}
		}
	}
	public String traverseTree() {
		return inOrderRecursive(root);
	}
	//RETURNS ANSWER STRING
	private String inOrderRecursive(MethodNode ptr) {
		
		if(ptr != null) {
			inOrderRecursive(ptr.left);
			ans += "\n" + ptr.method + ": Count: " + ptr.count + "\n";
			inOrderRecursive(ptr.right);

		}
		return ans;
	}
}

