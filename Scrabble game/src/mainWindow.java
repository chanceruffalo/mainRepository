import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class mainWindow {

	private JFrame frame;
	private JTextField userIn;
	private JButton btn;
	private Game game;
	private JTextArea txtArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
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
	public mainWindow() {
		initialize();
		game = new Game();
		btn.addActionListener( new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				start();
			}
		});
		
	}
	
	public void start() {
		game.newWord(userIn.getText());
		txtArea.setText(game.getResponse());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Scrabble Game");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 20));
		lblNewLabel.setBounds(124, 10, 196, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter four letters to see diffrent combinations.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Centaur", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(66, 43, 318, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		userIn = new JTextField();
		userIn.setBounds(175, 84, 96, 19);
		frame.getContentPane().add(userIn);
		userIn.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 167, 265, 56);
		frame.getContentPane().add(scrollPane);
		
		txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		
		btn = new JButton("Compute");
		btn.setBounds(175, 121, 95, 21);
		frame.getContentPane().add(btn);
	}
}
