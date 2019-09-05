import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class CSVreader extends JFrame {

	private JPanel contentPane;
	//public File file;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSVreader frame = new CSVreader();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void drawTable(File file)
	{

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 706, 430);
		contentPane.add(scrollPane);
		
		CSVextract extract = new CSVextract(file);
		try {
			extract.readCSV(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table = new JTable();
		table.setBounds(810, 60, 31, 49);
		scrollPane.add(table);
		
	}
	public CSVreader() 
	{
		File file;
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 854, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JFileChooser fc = new JFileChooser("D:\\GraphPlottingSuite\\DataCSV\\");
		fc.setFileFilter(new FileNameExtensionFilter("*.csv",".csv","csv","CSV",".CSV"));
		int result = fc.showOpenDialog(this);
		if (result == JFileChooser.OPEN_DIALOG) {
			file = fc.getSelectedFile();
			drawTable(file);
		} else if (result == JFileChooser.CANCEL_OPTION) {
		    System.out.println("Cancel was selected");
		}
		fc.setBounds(0, 0, 761, 286);	
		//contentPane.add(fc);	
		//////////////	
	}
}
