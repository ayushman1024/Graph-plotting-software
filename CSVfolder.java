package graph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Font;

public class CSVfolder extends JFrame {

	public static JPanel contentPane;
	public String loc;
	JMenuItem open=new JMenuItem("Open File"); 
	private JTextField textloc;
	public static File file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSVfolder frame = new CSVfolder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public File getFile() 
	{	
		return file;		
	}
	public CSVfolder() {
		setTitle("Select CSV File to Import");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textloc = new JTextField();
		textloc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textloc.setToolTipText("Selected File");
		textloc.setBackground(new Color(255, 248, 220));
		textloc.setBounds(30, 5, 637, 35);
		contentPane.add(textloc);
		textloc.setColumns(10);
		
		JFileChooser fc = new JFileChooser("D:\\GraphPlottingSuite\\DataCSV\\");
		fc.setFileFilter(new FileNameExtensionFilter(".csv","csv"));
		fc.setApproveButtonToolTipText("Click here select FILE");
		fc.setAcceptAllFileFilterUsed(false);
		fc.setApproveButtonText("IMPORT");
		fc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   
				   int i=JFileChooser.APPROVE_OPTION;
				   if(i==JFileChooser.APPROVE_OPTION){      
				        try
				        {    					          
					        file = fc.getSelectedFile();
					        loc =file.getPath();
					        textloc.setText(loc);
					        TableView.txtImport.setText(loc);
					        if(TableView.selected)
					        	TableView.tablelabel.setText(loc);
							JOptionPane.showMessageDialog(null, "Selected");
							dispose();
				        }
				        catch (Exception ex) {ex.printStackTrace();  }                 
				    }    				   
			}
		});
		fc.setBounds(30, 51, 637, 333);
		
		contentPane.add(fc);
		
		JLabel lblNewLabel_1 = new JLabel("File Selected");
		lblNewLabel_1.setBounds(5, 5, 708, 466);
		contentPane.add(lblNewLabel_1);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734, 515);
	}

}
