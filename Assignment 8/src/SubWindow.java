import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SubWindow {
	private JFrame frame;
	private JTextField skuArea;
	private JButton btn;
	private JLabel response;
	private InventorySystem inv;

	public SubWindow(InventorySystem inv) {
		this.inv = inv;
		initialize();
		//BUTTON LISTENERS
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subSku();
			}
		});
		
	}
	
	public void subSku() {
		Integer res = Integer.parseInt(skuArea.getText());
		response.setText(inv.subSku(res));
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 502);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		btn = new JButton("Remove");
		btn.setBounds(295, 248, 131, 37);
		frame.getContentPane().add(btn);
		
		response = new JLabel("");
		response.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		response.setHorizontalAlignment(SwingConstants.CENTER);
		response.setBounds(10, 322, 646, 53);
		frame.getContentPane().add(response);

		}
	public JFrame getFrame() {
		return frame;
	}
}
