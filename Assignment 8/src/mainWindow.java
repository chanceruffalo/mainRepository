import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class mainWindow {
	private JLabel Title;
	private JFrame frame;
	private JButton addBtn;
	private JButton subBtn; 
	private JButton listBtn;
	private static JLabel fileStatus;
	private AddBookWindow addPopUp;
	//FIELDS FOR POPWINDOW "list"
	private InventoryWindow invWindow;
	public static JTextArea inventoryTxt;
	public static JFrame invPopUp;
	private static InventorySystem inventory;
	public SubWindow subWindow;
	
	
	public mainWindow(InventorySystem inv) {
		inventory = inv;
		initialize();
		//Create inventory from storage
			//Button listeners
			//ADD BOOK BTN
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						addBook();
					}
				});
				
				subBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						subBook();
					}
				});
				//LIST INVENTORY BTN
				listBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
						list();
					}
				});
	}
	
	//ADDBOOK-WINDOW METHOD
	public void addBook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addPopUp= new AddBookWindow(inventory);
					addPopUp.getFrame().setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//LISTBOOKS-WINDOW METHOD
	public void list() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					invWindow = new InventoryWindow(inventory);
					invWindow.getFrame().setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//SUBBOOK-WINDOW METHOD
	public void subBook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					subWindow = new SubWindow(inventory);
					subWindow.getFrame().setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.setBounds(100, 100, 1018, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Title = new JLabel("Inventory System");
		Title.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(275, 10, 448, 23);
		frame.getContentPane().add(Title);
		
		addBtn = new JButton("Add book");
		addBtn.setFont(new Font("Rockwell Condensed", Font.PLAIN, 22));
		addBtn.setBounds(77, 114, 208, 181);
		frame.getContentPane().add(addBtn);
		
		subBtn = new JButton("Remove Book");
		subBtn.setFont(new Font("Rockwell Condensed", Font.PLAIN, 22));
		subBtn.setBounds(396, 114, 208, 181);
		frame.getContentPane().add(subBtn);
		
		listBtn = new JButton("List Inventory");
		listBtn.setFont(new Font("Rockwell Condensed", Font.PLAIN, 24));
		listBtn.setBounds(727, 114, 208, 181);
		frame.getContentPane().add(listBtn);
		
		fileStatus = new JLabel("");
		fileStatus.setHorizontalAlignment(SwingConstants.CENTER);
		fileStatus.setFont(new Font("Rockwell Condensed", Font.PLAIN, 18));
		fileStatus.setBounds(275, 376, 448, 35);
		frame.getContentPane().add(fileStatus);
	}
	public JFrame getFrame() {
		return frame;
	}
	public static void fileStatusSetText(String str) {
		fileStatus.setText(str);
	}
	public static void setInventory(InventorySystem inv) {
		inventory = inv;
	}



}
