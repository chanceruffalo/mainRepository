package Ruffalo;

public class ItemList {
	//ATTRIBUTES
	private Item head;
	private Item tail;
	
	//CONSTRUCTOR
	public ItemList() {
		head = null;
		tail = null;
	}
	
	//POPULATION OF LIST
	public void addItem(String item, String price, String quantity) {
		Item temp = new Item(item, price, quantity);
		if(head == null) {
			head = temp;
			tail = temp;
		}
		else {
			tail.next = temp;
			tail = temp;
		}
	}
	
	//TRAVERSAL OF LIST - this will make ticket sheet and total price
	public String[] getTotals() {
		String[] totals = new String[2];
		totals[0] = "Item:             Quantity:   Price: \n";
		double totalPrice = 0.00;
		Item ptr = head;
		while(ptr != null) {
			totals[0] += ptr.toString();
			totalPrice += ptr.getPrice();
			ptr = ptr.next;
		}
		totals[1] = "$" + String.format("%.2f", totalPrice);
		return totals;
	}
	
	
	

}
