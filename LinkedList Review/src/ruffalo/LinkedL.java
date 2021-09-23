package ruffalo;

public class LinkedL {
	
	//ATTRIBUTES
	private Node header;
	private Node tail;
	
	public LinkedL() {
		header = null;
		tail = null;
	}
	
	public void addNode(String x) {
		Node y = new Node(Integer.parseInt(x));
		if(header == null) {
			header = y;
			tail = y;
		}
		else {
		
			tail.next = y;
			y.prev = tail;
			tail = y;
		}
		
	}
	
	public String toStringReverse() {
		String ans = "";
		Node traverse = tail;
		
		while (traverse != null) {
			ans += traverse.num + " " ;
			traverse = traverse.prev;
		}
		return ans;
	}
	
	public String toStringOrdered() {
		String ans = "";
		Node traverse = header;
		
		while (traverse != null) {
			ans += traverse.num + " " ;
			traverse = traverse.next;
		}
		return ans;
	}
	
	public void pop() {
		if(header == tail) {
			header = null;
			tail = null;
		}
		else {
			header.next.prev = null;
			header = header.next;
		}
	}
	public Node getHead() {
		return header;
	}

}
