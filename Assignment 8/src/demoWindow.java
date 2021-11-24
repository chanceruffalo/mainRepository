import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class demoWindow {

	private JFrame frame;
	private JTextField skuTxt;
	private JTextField textBookTxt;
	private JTextField quantityTxt;
	private JTextField priceTxt;
	private JTextField skuArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demoWindow window = new demoWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public demoWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel header = new JLabel("Remove a book");
		header.setFont(new Font("Sitka Subheading", Font.PLAIN, 24));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setBounds(10, 10, 646, 26);
		frame.getContentPane().add(header);
		
		JLabel lbl = new JLabel("Item SKU:");
		lbl.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		lbl.setBounds(249, 145, 91, 26);
		frame.getContentPane().add(lbl);
		
		skuArea = new JTextField();
		skuArea.setBounds(354, 148, 96, 19);
		frame.getContentPane().add(skuArea);
		skuArea.setColumns(10);
		
		JButton btn = new JButton("Remove");
		btn.setBounds(295, 248, 131, 37);
		frame.getContentPane().add(btn);
		
		JLabel response = new JLabel("");
		response.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		response.setHorizontalAlignment(SwingConstants.CENTER);
		response.setBounds(10, 322, 646, 53);
		frame.getContentPane().add(response);

		}
}
