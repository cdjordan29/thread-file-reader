import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Class WordLetterCount: 
 * 
 * This class represents the main window and the controller of program 3
 * 
 * @author Daniel Jordan
 * @version 1.0
 * @date 4/6/17
 */
public class WordLetterCount {

	/*
	 * Instance Data Section
	 */

	//RunnableFiles reference
	private RunnableFiles file;

	//JFrame for the main application window 
	private JFrame mainFrame;

	//JPanel for the main application window 
	private JPanel mainPanel1, mainPanel2;

	//JLabels for the text fields 
	private JLabel mainLabel1, mainLabel2, f1Label, f2Label, f3Label, f4Label, f5Label,
	f6Label, f7Label, f8Label, f9Label, f10Label; 

	//JTextFields for specific files to be typed into the program
	private JTextField f1TextField, f2TextField, f3TextField, f4TextField, f5TextField,
	f6TextField, f7TextField, f8TextField, f9TextField, f10TextField;

	//JButton for the main application window 
	private JButton scanButton;

	//Thread used to scan the files that are input
	private Thread thread;

	//Constants for the main application window
	private final int HEIGHT, WIDTH;
	
	//ArrayList used to store the file names
	private ArrayList<String> fileList;

	//Constructor for WordLetterCount
	public WordLetterCount(){

		//Instantiating the ArrayList
		fileList = new ArrayList<String>();
		
		//Instantiating the main window
		mainFrame = new JFrame("Program 3");
		mainPanel1 = new JPanel();
		mainPanel2 = new JPanel();
		mainLabel1 = new JLabel("Please input the following files you wish to scan.");
		mainLabel2 = new JLabel("(t1.txt, t2.txt ... t10.txt)");
		f1Label = new JLabel("Input file:");
		f2Label = new JLabel("Input file:");
		f3Label = new JLabel("Input file:");
		f4Label = new JLabel("Input file:");
		f5Label = new JLabel("Input file:");
		f6Label = new JLabel("Input file:");
		f7Label = new JLabel("Input file:");
		f8Label = new JLabel("Input file:");
		f9Label = new JLabel("Input file:");
		f10Label = new JLabel("Input file:");
		f1TextField = new JTextField("");
		f2TextField = new JTextField("");
		f3TextField = new JTextField("");
		f4TextField = new JTextField("");
		f5TextField = new JTextField("");
		f6TextField = new JTextField("");
		f7TextField = new JTextField("");
		f8TextField = new JTextField("");
		f9TextField = new JTextField("");
		f10TextField = new JTextField("");
		scanButton = new JButton("Scan Files");

		//Instantiating the constant for the main application window
		HEIGHT = 200;
		WIDTH = 900;
	}

	/**
	 * Method prepareGUI, adds all the components to the main frame. 
	 */
	public void prepareGUI(){

		//Setting up the components for the main frame
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.add(mainPanel1, BorderLayout.NORTH);
		mainFrame.add(mainPanel2, BorderLayout.CENTER);
		//Setting up the components to be put on the main panel
		mainPanel1.setLayout(new FlowLayout());
		mainPanel1.add(mainLabel1);
		mainPanel1.add(mainLabel2);
		//Setting up the text fields
		mainPanel2.setLayout(new FlowLayout());
		mainPanel2.add(f1Label);
		f1TextField.setColumns(10);
		mainPanel2.add(f1TextField);
		mainPanel2.add(f2Label);
		f2TextField.setColumns(10);
		mainPanel2.add(f2TextField);
		mainPanel2.add(f3Label);
		f3TextField.setColumns(10);
		mainPanel2.add(f3TextField);
		mainPanel2.add(f4Label);
		f4TextField.setColumns(10);
		mainPanel2.add(f4TextField);
		mainPanel2.add(f5Label);
		f5TextField.setColumns(10);
		mainPanel2.add(f5TextField);
		mainPanel2.add(f6Label);
		f6TextField.setColumns(10);
		mainPanel2.add(f6TextField);
		mainPanel2.add(f7Label);
		f7TextField.setColumns(10);
		mainPanel2.add(f7TextField);
		mainPanel2.add(f8Label);
		f8TextField.setColumns(10);
		mainPanel2.add(f8TextField);
		mainPanel2.add(f9Label);
		f9TextField.setColumns(10);
		mainPanel2.add(f9TextField);
		mainPanel2.add(f10Label);
		f10TextField.setColumns(10);
		mainPanel2.add(f10TextField);
		scanButton.setPreferredSize(new Dimension(100, 20));
		mainPanel2.add(scanButton);
		mainFrame.setVisible(true);

		setScanButtonAction();
	}

	/**
	 * Method setScanButtonAction, adds an ActionListener to the scanButton
	 */
	public void setScanButtonAction(){

		scanButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				System.out.println("SCAN BUTTON PRESSED!!!");
				String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10 = new String();

				s1 = f1TextField.getText();
				s2 = f2TextField.getText();
				s3 = f3TextField.getText();
				s4 = f4TextField.getText();
				s5 = f5TextField.getText();
				s6 = f6TextField.getText();
				s7 = f7TextField.getText();
				s8 = f8TextField.getText();
				s9 = f9TextField.getText();
				s10 = f10TextField.getText();

				if(!s1.isEmpty()){
					addToFileList(s1);
				}
				if(!s2.isEmpty()){
					addToFileList(s2);
				}
				if(!s3.isEmpty()){
					addToFileList(s3);
				}
				if(!s4.isEmpty()){
					addToFileList(s4);
				}
				if(!s5.isEmpty()){
					addToFileList(s5);
				}
				if(!s6.isEmpty()){
					addToFileList(s6);
				}
				if(!s7.isEmpty()){
					addToFileList(s7);
				}
				if(!s8.isEmpty()){
					addToFileList(s8);
				}
				if(!s9.isEmpty()){
					addToFileList(s9);
				}
				if(!s10.isEmpty()){
					addToFileList(s10);
				}	
				
				for(String s : fileList){
					
					RunnableFiles f = new RunnableFiles(s);
					thread = new Thread(f);
					thread.start();
				}				
			}
		});
	}
	
	/**
	 * Method addToFileList, takes in a file name as a string add it to the ArrayList
	 */
	public void addToFileList(String s){
		
		fileList.add(s);
	}
}
