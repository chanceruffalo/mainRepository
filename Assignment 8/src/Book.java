
public class Book {
	private int sku;
	private String title;
	private Double price;
	private int quantity;
	
	public Book(int sku, String title, Double price, int quantity) {
		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	//METHOD: RETURN STRING FOR BOOK MENU
	public String toString() {
		return  "SKU: " + sku + "\n" +
				"Title: " + title + "\n" +
				"Price: " + price + "\n" +
				"Stock: " + quantity + "\n";
	}
	public int getSku() {
		return sku;
	}
	public void setSku(int sku) {
		this.sku = sku;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
