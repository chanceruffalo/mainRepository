import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class Control {
	
	private JLabel Title;
	private JFrame frame;
	private JButton addBtn;
	private JButton subBtn; 
	private JButton listBtn;
	private static JLabel fileStatus;
	//FIELDS FOR ADDPOPUP
	private AddBookWindow addPopUp;
	//FIELDS FOR POPWINDOW "list"
	private InventoryWindow invWindow;
	public static JTextArea inventoryTxt;
	public static JFrame invPopUp;
	
	public SubWindow subWindow;
	
	private static File bookStorage;
	private static InventorySystem inventory;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// OPENS INVENTORY STORE FILE
					bookStorage = new File("bookInventory.txt");
					//Create inventory from storage
					inventory = new InventorySystem(bookStorage);
					control();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void control() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow main = new mainWindow(inventory);
					main.getFrame().setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
