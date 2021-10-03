package Ruffalo;

public class Item {
	/**
	 *  This object will contain the item information from the user
	 */
	//ATTRIBUTES
	private String name;
	private double price;
	private double quantity;
	public Item next;
	//CONSTRUCTOR
	public Item(String name, String price, String quantity) {
		this.name = name;
		this.quantity = Double.parseDouble(quantity);
		this.price = Double.parseDouble(price) * this.quantity;
		next = null;
	}
	//toString()
	public String toString() {
		String ans = "";
		if(name.length() < 20) {
			ans = name;
			while(ans.length() < 20) {
				ans += " ";
			}
		}
		else {
			ans = name.substring(0,18) + "    ";
		}
		ans += quantity + "       ";
		ans += "$" + price  + "\n";
		return ans;
		
	}
	//Getters - Did not create setters since we never go back to alter items
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public double getQuantity() {
		return quantity;
	}
}
