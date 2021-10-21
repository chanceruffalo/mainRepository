package Ruffalo;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.filechooser.FileSystemView;

import java.awt.Font;
import javax.swing.JButton;

public class MainWindow {

	private JFrame frame;
	private JLabel textBox;
	private JLabel results;
	private JButton btn;
	static 	JFileChooser j;
	private String fileName;
	private Scanner pt;
	private File nums;
	private List list;

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
		btn.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e) {
				openFileChooser();
			}

		});
	}

	public void openFileChooser() {
		fileName = "";
		JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int r = j.showSaveDialog(null);
		// if the user selects a file
		if (r == JFileChooser.APPROVE_OPTION)
		{
			// set the label to the path of the selected file
			fileName = (j.getSelectedFile().getAbsolutePath());
			displayResults();
		}
		// if the user cancelled the operation
		else
			textBox.setText("The user cancelled the operation...");
	}

	public void displayResults() {
		List list = new List();
		try {
			//FINDING FILE AND CREATE LIST
			nums = new File(fileName);
			pt = new Scanner(nums);
		}catch (Exception e) {
			e.printStackTrace();
		}
		int x;
		while(pt.hasNextInt()) {
			x = pt.nextInt();
			list.addNode(x);
		}
		textBox.setText("Results:");
		results.setText("Mean: " + String.format("%.2f", list.mean(list.sum())) + " Standard deviation: " + String.format("%.2f", list.std()));
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(85, 107, 47));
		frame.getContentPane().setLayout(null);

		textBox = new JLabel("Push button to select your number file:");
		textBox.setForeground(new Color(240, 255, 240));
		textBox.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		textBox.setBounds(67, 10, 307, 45);
		frame.getContentPane().add(textBox);

		btn = new JButton("Choose file");
		btn.setBounds(159, 171, 142, 21);
		frame.getContentPane().add(btn);

		results = new JLabel("");
		results.setFont(new Font("Tahoma", Font.PLAIN, 15));
		results.setBounds(67, 65, 307, 34);
		frame.getContentPane().add(results);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
