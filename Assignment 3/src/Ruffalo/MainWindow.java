package Ruffalo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class MainWindow {

	private JFrame frmSaleListApp;
	private JTextField itemArea;
	private JTextField priceArea;
	private JTextField quantityArea;
	private JTextField totalArea;
	private JButton btn;
	private JTextArea txtArea;
	private ItemList list;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmSaleListApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		list = new ItemList();
		btn.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e) {
				generate();
			}
		});

	}
	public void generate() {
		list.addItem(itemArea.getText(), priceArea.getText(), quantityArea.getText());
		String[] response = list.getTotals();
		totalArea.setText(response[1]);
		txtArea.setText(response[0]);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSaleListApp = new JFrame();
		frmSaleListApp.setTitle("Sale List App");
		frmSaleListApp.getContentPane().setBackground(new Color(204, 204, 255));
		frmSaleListApp.getContentPane().setForeground(new Color(255, 204, 255));
		frmSaleListApp.setForeground(new Color(255, 204, 255));
		frmSaleListApp.setBackground(new Color(255, 204, 255));
		frmSaleListApp.setBounds(100, 100, 450, 300);
		frmSaleListApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSaleListApp.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("~ Sales List ~");
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel.setBounds(10, 10, 416, 32);
		frmSaleListApp.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(137, 52, 45, 13);
		frmSaleListApp.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price: $");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(137, 75, 45, 24);
		frmSaleListApp.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(137, 109, 65, 24);
		frmSaleListApp.getContentPane().add(lblNewLabel_3);
		
		itemArea = new JTextField();
		itemArea.setBounds(210, 50, 124, 19);
		frmSaleListApp.getContentPane().add(itemArea);
		itemArea.setColumns(10);
		
		priceArea = new JTextField();
		priceArea.setBounds(210, 79, 124, 19);
		frmSaleListApp.getContentPane().add(priceArea);
		priceArea.setColumns(10);
		
		quantityArea = new JTextField();
		quantityArea.setBounds(212, 113, 122, 19);
		frmSaleListApp.getContentPane().add(quantityArea);
		quantityArea.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Total Price:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(124, 225, 78, 28);
		frmSaleListApp.getContentPane().add(lblNewLabel_4);
		
		totalArea = new JTextField();
		totalArea.setBounds(210, 231, 124, 19);
		frmSaleListApp.getContentPane().add(totalArea);
		totalArea.setColumns(10);
		
		btn = new JButton("Generate\r\n ");
		btn.setBounds(35, 143, 117, 72);
		frmSaleListApp.getContentPane().add(btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 143, 221, 72);
		frmSaleListApp.getContentPane().add(scrollPane);
		
		txtArea = new JTextArea();
		txtArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtArea.setText("Item:             Quantity:   Price: ");
		scrollPane.setViewportView(txtArea);
	}
}
