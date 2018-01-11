import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class RunnableFiles: 
 * 
 * This class represents the text files to be read from program 3
 * 
 * @author Daniel Jordan
 * @version 1.0
 * @date 4/6/17
 */
public class RunnableFiles implements Runnable{

	/*
	 * Instance Data Section
	 */
		
	//JFrame for the result window
	private JFrame fileFrame;
	
	//JPanel for the result window
	private JPanel filePanel;
	
	//JLabels for the result window
	private JLabel fileNameLabel, letterCountLabel, wordCountLabel;
	
	//JTextArea to display the entire file in the result window
	private JTextArea fileDisplay;
	
	//Constants for the result window
	private final int HEIGHT, WIDTH;
	
	private String fileName;
	
	//Constructor for RunnableFiles
	public RunnableFiles(String _fileName){
		
		//Instantiating the constants for the result window
		HEIGHT = 400;
		WIDTH = 400;
		
		//Instantiating the fileName
		this.fileName = _fileName;
	}
	
	/**
	 * Method createResultWindow, creates the result window to display the counts of the letters and words
	 */
	public void createResultWindow(int wordCount, int letterCount, String fileContent){
	
		fileFrame = new JFrame("Results");
		filePanel = new JPanel();
		filePanel.setLayout(new FlowLayout());
		fileNameLabel = new JLabel("File read: " + getFileName());
		letterCountLabel = new JLabel("Total letter count: " + letterCount);
		wordCountLabel = new JLabel("Total word count: " + wordCount);
		fileDisplay = new JTextArea(fileContent);
		fileDisplay.setSize(300, 300);
		fileDisplay.setLineWrap(true);
		fileFrame.add(filePanel);
		filePanel.add(fileNameLabel);
		filePanel.add(letterCountLabel);
		filePanel.add(wordCountLabel);
		filePanel.add(fileDisplay);
		
		fileFrame.setSize(WIDTH, HEIGHT);
		fileFrame.setVisible(true);
	}
	
	/**
	 * Method getFileName, returns the String which will be the file name.
	 */
	public String getFileName(){
		
		return this.fileName;
	}
	
	/**
	 * Method run, will iterate over the ArrayList of file names, counting the letters and words
	 */
	public void run() {
			
		int wordCount = 0, letterCount = 0;
		String tempString = "", fileContent = "";
		File readable = new File(getFileName());
		try {
			Scanner in = new Scanner(readable);
			
			while(in.hasNextLine()){
				
				tempString = in.next();
				wordCount++;
				fileContent += tempString + " ";
				
				for(int i = 0; i < tempString.length(); i ++){
					
					if((tempString.charAt(i) >= 'a') && (tempString.charAt(i) <= 'z') ||
						(tempString.charAt(i) >= 'A') && (tempString.charAt(i) <= 'Z')){
						
						letterCount++;
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	
		//After the file is processed, display the results
		createResultWindow(wordCount, letterCount, fileContent);
	}

}
