import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddBookWindow {
	private JFrame frame;
	private JTextField skuTxt;
	private JTextField textBookTxt;
	private JTextField quantityTxt;
	private JTextField priceTxt;
	private JButton addBook;
	private JLabel response;
	private InventorySystem inventory;
	
	public AddBookWindow(InventorySystem inventory) {
		initialize();
		this.inventory = inventory;
		addBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pushBook();
			}
		});
	}
	
	public void pushBook() {
		String res = inventory.addBook(skuTxt.getText(),textBookTxt.getText(),priceTxt.getText(),quantityTxt.getText());
		mainWindow.fileStatusSetText(res);
		mainWindow.setInventory(inventory);
		response.setText(res);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 680, 502);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add book");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.PLAIN, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 646, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel skuLabel = new JLabel("SKU:");
		skuLabel.setHorizontalAlignment(SwingConstants.LEFT);
		skuLabel.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		skuLabel.setBounds(58, 77, 63, 27);
		frame.getContentPane().add(skuLabel);
		
		JLabel titleLabel = new JLabel("Title: ");
		titleLabel.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		titleLabel.setBounds(58, 187, 63, 35);
		frame.getContentPane().add(titleLabel);
		
		JLabel priceLabel = new JLabel("Price: ");
		priceLabel.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		priceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		priceLabel.setBounds(376, 77, 63, 27);
		frame.getContentPane().add(priceLabel);
		
		JLabel quantityLabel = new JLabel("Quantity:");
		quantityLabel.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		quantityLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quantityLabel.setBounds(353, 192, 86, 25);
		frame.getContentPane().add(quantityLabel);
		
		skuTxt = new JTextField();
		skuTxt.setBounds(131, 77, 183, 26);
		frame.getContentPane().add(skuTxt);
		skuTxt.setColumns(10);
		
		textBookTxt = new JTextField();
		textBookTxt.setColumns(10);
		textBookTxt.setBounds(131, 191, 183, 26);
		frame.getContentPane().add(textBookTxt);
		
		quantityTxt = new JTextField();
		quantityTxt.setColumns(10);
		quantityTxt.setBounds(448, 191, 183, 26);
		frame.getContentPane().add(quantityTxt);
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		priceTxt.setBounds(448, 77, 183, 26);
		frame.getContentPane().add(priceTxt);
		
		addBook = new JButton("Add Book");
		addBook.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		addBook.setBounds(256, 255, 183, 130);
		frame.getContentPane().add(addBook);
		
		response = new JLabel("");
		response.setFont(new Font("Sitka Heading", Font.PLAIN, 12));
		response.setHorizontalAlignment(SwingConstants.CENTER);
		response.setBounds(181, 417, 321, 13);
		frame.getContentPane().add(response);
	}

	public JButton getAddBook() {
		return addBook;
	}

	public void setAddBook(JButton addBook) {
		this.addBook = addBook;
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getSkuTxt() {
		return skuTxt;
	}

	public void setSkuTxt(JTextField skuTxt) {
		this.skuTxt = skuTxt;
	}

	public JTextField getTextBookTxt() {
		return textBookTxt;
	}

	public void setTextBookTxt(JTextField textBookTxt) {
		this.textBookTxt = textBookTxt;
	}

	public JTextField getQuantityTxt() {
		return quantityTxt;
	}

	public void setQuantityTxt(JTextField quantityTxt) {
		this.quantityTxt = quantityTxt;
	}

	public JTextField getPriceTxt() {
		return priceTxt;
	}

	public void setPriceTxt(JTextField priceTxt) {
		this.priceTxt = priceTxt;
	}

	public JLabel getResponse() {
		return response;
	}

	public void setResponse(JLabel response) {
		this.response = response;
	}
}
