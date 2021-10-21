package Ruffalo;

public class List {
	//	ATTRIBUTES
	private Node head;
	private Node tail;
	private Double nNodes;

	//CONSTRUCTOR
	public List() {
		head = null;
		tail = null;
		nNodes = 0.0;
	}

	//METHODS----------------------
	//ADDING NODES
	public void addNode(int num) {
		Node temp = new Node(num);
		if(head == null) {
			head = temp;
			tail = temp;
			nNodes ++;
		}
		else {
			tail.next = temp;
			tail = temp;
			nNodes++;
		}
	}
	//TRAVERSE LIST AND ADD NODES
	public Double sum() {
		Double sum = 0.0;
		Node trv = head;
		while(trv != null) {
			sum += trv.num;
			trv = trv.next;
		}
		return sum;
	}
	//CALCULATE MEAN
	public Double mean(Double x) {
		return (x / nNodes);
	}
	//CALCULATE STD
	public Double std() {
		Double sum = 0.0;
		Double sumOfList = sum();
		Node trv = head;
		while(trv != null) {
			sum += (trv.num - mean(sumOfList))*(trv.num - mean(sumOfList));
			trv = trv.next;
		}
		return Math.sqrt(mean(sum));
	}

}
