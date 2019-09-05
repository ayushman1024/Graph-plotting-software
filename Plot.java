import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Plot {

	private Plotf frame;
	public static int a[] = new int[20];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plot window = new Plot();
				//	window.frame.setVisible(true);
					JOptionPane.showMessageDialog(null,"Use Mouse Wheel to Zoom into graph");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Plot() 
	{
		initialize();
		BufferedReader br = null;
	}

	private void initialize() 
	{	
		frame = new Plotf();
		frame.setBounds(10, 10, 1288, 690);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
