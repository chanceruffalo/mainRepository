import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class InventoryWindow {
	private JFrame frame;
	private InventorySystem inventory;
	private JTable table;
	
	public InventoryWindow(InventorySystem inventory) {
		this.inventory = inventory;
		initialize();

	}
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 889, 522);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel titlePopup = new JLabel("Book Inventory");
		titlePopup.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		titlePopup.setHorizontalAlignment(SwingConstants.CENTER);
		titlePopup.setBounds(10, 10, 855, 22);
		getFrame().getContentPane().add(titlePopup);
		
		String[] columnNames = {"SKU","Title","Price","Quantity"};
		Object[][] data = inventory.bookData();	
		table = new JTable(data,columnNames);
		table.setBounds(40,40,800,500);
		getFrame().getContentPane().add(table);
	}
	

	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
}
