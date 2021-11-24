import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;


public class InventorySystem{
	
	private HashMap<Integer, Book> inv;
	private File file;
	
	//CONSTRUCTOR
	public InventorySystem(File file) {
		inv = new HashMap<Integer,Book>();
		this.file = file;
		populate();
	}
	
	//adds books from database file
	public void populate() {
		try {
			Scanner read = new Scanner(file);
			while(read.hasNextLine()) {
				String sku = read.nextLine();
				Book temp = new Book(Integer.parseInt(sku),read.nextLine(),Double.parseDouble(read.nextLine()),Integer.parseInt(read.nextLine()));
				inv.put(Integer.parseInt(sku), temp);
			}
			read.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//ADD NEW BOOK TO HASHMAP SEND TO FILE
	public String addBook(String sku, String title, String price, String quantity) {
		if(sku.contains("[a-zA-Z]+") || price.contains("[a-zA-Z]+") || quantity.contains("[a-zA-Z]+")) {
			return "SKU, Price, and quantity only should contain numbers.";
		}
		else if(quantity.contains(".")) {
			return "Quantity field should be only whole numbers";
		}
		Integer SKU = Integer.parseInt(sku);
		if (inv.containsKey(SKU)) {
			return "This SKU is already taken.";
		}
		Book temp = new Book(SKU,title ,Double.parseDouble(price),Integer.parseInt(quantity));
		inv.put(SKU, temp);
		addToDataBase(temp);
		return "Successfully added book to dataBase.";
	}
	
	public void addToDataBase(Book temp) {
		FileWriter fw = null;
		BufferedWriter bw =  null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			pw.println(temp.getSku() + "\n" +temp.getTitle() + "\n" +temp.getPrice() + "\n" +temp.getQuantity());
			pw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				pw.close();
				bw.close();
				fw.close();
			}catch(IOException io) {
				io.printStackTrace();
			}
		}
	}
	
	public Object[][] bookData() {
		Object[][] data = new Object[inv.size()+1][4];
		data[0][0]="SKU";
		data[0][1]="Title";
		data[0][2]="Price";
		data[0][3]="Quantity";
		int i = 1;
		int j = 0;
		for(Integer key : inv.keySet()) {
			Book temp = inv.get(key);
			data[i][j] = temp.getSku();j++;
			data[i][j] = temp.getTitle();j++;
			data[i][j] = temp.getPrice();j++;
			data[i][j] = temp.getQuantity();
			j = 0;
			i ++;
		}
		return data;
	}
	
	public String subSku(Integer temp) {
		if(inv.containsKey(temp)) {
			inv.remove(temp);
			return "Removed that book with SKU:" + temp.toString();
		}
		return "No book found with the SKU:" + temp.toString();
	}
}