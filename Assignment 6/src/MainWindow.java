import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MainWindow {

	private JFrame frmCodeAnaly;
	// this btn will open file chooser;
	private JButton btn;
	private JLabel lblNewLabel;
	// this stirng will hold file name that we want;
	private String fileName;
	private CodeCounter codeCounter;
	JTextArea txt;
	JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextArea txt2;


	// Main window opener
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmCodeAnaly.setVisible(true);
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
		//BUTTON LISTENER
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileChooser();
			}
		});
	}


	public void openFileChooser() {
		//USER CHOOSES FILE AND IS STORED IN filename
		fileName = "";
		JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int r = j.showSaveDialog(null);
		if (r == JFileChooser.APPROVE_OPTION)
		{
			//IF USER SELECT SUCCESSFUL BEGIN ANALYSIS
			fileName = (j.getSelectedFile().getAbsolutePath());
			displayResults(fileName);
		}
		else {
			txt.setText("Please try agian.");
		}
	}
	//ANAYLSIS OF CODEFILE
	public void displayResults(String fileName) {
		//CodeCounter IS OBJECT THAT ANALIZES CODE 
		codeCounter = new CodeCounter(fileName);
		ArrayList<String> list = codeCounter.getList();
		//PRINT RESULTS BY STORING ANSWERS IN STRINGS THEN SETTING THOSE STRINGS
		String temp = "";
		for(int i = 0; i <list.size(); i ++) {
			temp += (list.get(i)) + "\n";
		}
		//STRING SETTING
		txt.setText(temp + "Lines of Code: " + codeCounter.getLinesOfCode());
		txt2.setText(CodeCounter.getCounts());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCodeAnaly = new JFrame();
		frmCodeAnaly.getContentPane().setBackground(new Color(255, 255, 204));
		SpringLayout springLayout = new SpringLayout();
		frmCodeAnaly.getContentPane().setLayout(springLayout);

		JLabel Title = new JLabel("<HTML><U>Code Analyser</U></HTML>");
		springLayout.putConstraint(SpringLayout.NORTH, Title, 20, SpringLayout.NORTH, frmCodeAnaly.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, Title, 424, SpringLayout.WEST, frmCodeAnaly.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, Title, 63, SpringLayout.NORTH, frmCodeAnaly.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, Title, -424, SpringLayout.EAST, frmCodeAnaly.getContentPane());
		Title.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		frmCodeAnaly.getContentPane().add(Title);

		lblNewLabel = new JLabel("<HTML><U>Please select a file to analyze</U></HTML>");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 18, SpringLayout.SOUTH, Title);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 365, SpringLayout.WEST, frmCodeAnaly.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -298, SpringLayout.SOUTH, frmCodeAnaly.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -371, SpringLayout.EAST, frmCodeAnaly.getContentPane());
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmCodeAnaly.getContentPane().add(lblNewLabel);

		btn = new JButton("Choose...");
		springLayout.putConstraint(SpringLayout.NORTH, btn, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, btn, 474, SpringLayout.WEST, frmCodeAnaly.getContentPane());
		btn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmCodeAnaly.getContentPane().add(btn);

		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 47, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 41, SpringLayout.WEST, frmCodeAnaly.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -12, SpringLayout.SOUTH, frmCodeAnaly.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 429, SpringLayout.WEST, frmCodeAnaly.getContentPane());
		frmCodeAnaly.getContentPane().add(scrollPane);

		txt = new JTextArea();
		txt.setEditable(false);
		txt.setBackground(new Color(255, 255, 204));
		scrollPane.setViewportView(txt);

		scrollPane_1 = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 0, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 174, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, 0, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -28, SpringLayout.EAST, frmCodeAnaly.getContentPane());
		frmCodeAnaly.getContentPane().add(scrollPane_1);

		txt2 = new JTextArea();
		txt2.setBackground(new Color(255, 255, 204));
		scrollPane_1.setViewportView(txt2);
		frmCodeAnaly.setForeground(new Color(255, 255, 204));
		frmCodeAnaly.setBackground(new Color(255, 255, 204));
		frmCodeAnaly.setResizable(false);
		frmCodeAnaly.setTitle("Code Analyser");
		frmCodeAnaly.setBounds(100, 100, 1051, 467);
		frmCodeAnaly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
