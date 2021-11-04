
public class MethodNode {
	//ATTRIBUTES
	public String method;
	public int count;
	public MethodNode left;
	public MethodNode right;

	//CONSTRUCTOR
	public MethodNode(String str) {
		method = str;
		count = 1;
		left = null;
		right = null;
	}

	//ADDING METHOD - COUNTING HOW MANY DUPLICATES
	public void increment() {
		count++;
	}
}
