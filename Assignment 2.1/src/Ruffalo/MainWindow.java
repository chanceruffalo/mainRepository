package Ruffalo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainWindow {

	private JFrame frame;
	private JTextField user;
	private JButton btn;
	private JTextArea response;
	private Checker checker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
		checker = new Checker();
		btn.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e) {
				commenceCheck();
			}
			
		});
	}
	
	public void commenceCheck() {
		checker.check(user.getText());
		response.setText(checker.getResponse());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Password Checker");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 21, 227, 30);
		frame.getContentPane().add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(100, 93, 231, 19);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		btn = new JButton("Check");
		btn.setBounds(171, 135, 85, 21);
		frame.getContentPane().add(btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(104, 201, 231, 52);
		frame.getContentPane().add(scrollPane);
		
		response = new JTextArea();
		scrollPane.setViewportView(response);
	}
}
