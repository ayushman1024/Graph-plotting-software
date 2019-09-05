package graph;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.univocity.parsers.csv.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JCheckBox;
public class TableView extends JFrame {

	/**
	 * 
	 */
	String[] row;
	public File folderCSV,file;
	JButton btnimport, btnViewTable;
	static boolean selected=false;
	DefaultTableModel tableModel;
	static double [][] data=new double[100][100];
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtselectrow;
	private JTextField txtselectcol;
	private int rowselect,colselect;
	public static JLabel txtImport, tablelabel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableView frame = new TableView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Utility Methods
	 * get and set methods 
	 */
	public double[][] getArrayTable(int r,int c)
	{	
		for(int i=0;i<r;i++)
		{
			for(int j =0;j<c;j++) {
				data[i][j]=Double.parseDouble( (String) table.getValueAt(i, j));
				System.out.print(data[i][j]+" ");
			}System.out.println();
		}
		double[][] dataOut = data;
		return dataOut;
	}
	void setPreview(File filex)
	{
		file = new File(filex.getAbsolutePath());
		///
		CsvParserSettings setting = new CsvParserSettings();
		setting.getFormat().setLineSeparator("\r\n");
		setting.setMaxColumns(2000);
		CsvParser parser=new CsvParser(setting);
		ArrayList<String[]> l =  (ArrayList<String[]>) parser.parseAll(file);
		Object[] columnnames = (String[]) l.get(0);
		tableModel = new DefaultTableModel(columnnames, l.size()-1);
		////
		tableModel.addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent tme) {
                if (tme.getType() == TableModelEvent.UPDATE) {
                    System.out.println("Change");
                    selected=true;
                }
            }
        });
		////
		parser.beginParsing(file);
		String datas[][] = new String[2000][2000];		
		int rowcount = tableModel.getRowCount();int columnnumber=0;
	      for (int x = 0; x<rowcount+1; x++)
	       {
	         columnnumber = 0;
	         if (x>0)
	         {
		       for (String thiscellvalue : (String[])l.get(x))
		       {
		           tableModel.setValueAt(thiscellvalue, x-1, columnnumber);
		           datas[x-1][columnnumber] = thiscellvalue;
		           columnnumber++;
		       }
	         }
	       }
	      table.setModel(tableModel);
	      txtselectrow.setText(String.valueOf(rowcount));
	      txtselectcol.setText(String.valueOf(columnnumber));
	      repaint();
		
	}
	public void setViewTable(File filex)
	{
		file = new File(filex.getAbsolutePath());
		///
		CsvParserSettings setting = new CsvParserSettings();
		setting.getFormat().setLineSeparator("\r\n");
		CsvParser parser=new CsvParser(setting);
		ArrayList<String[]> l =  (ArrayList<String[]>) parser.parseAll(file);
		Object[] columnnames = (String[]) l.get(0);
		tableModel = new DefaultTableModel(columnnames, l.size()-1);
		////
		tableModel.addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent tme) {
                if (tme.getType() == TableModelEvent.UPDATE) {
                    System.out.println("Change");
                    selected=true;
                }
            }
        });
		////
		parser.beginParsing(file);
		String datas[][] = new String[200][200];		
		int rowcount = tableModel.getRowCount();int columnnumber=0;
	      for (int x = 0; x<rowcount+1; x++)
	       {
	         columnnumber = 0;
	         if (x>0)
	         {
		       for (String thiscellvalue : (String[])l.get(x))
		       {
		           tableModel.setValueAt(thiscellvalue, x-1, columnnumber);
		           datas[x-1][columnnumber] = thiscellvalue;
		           columnnumber++;
		       }
	         }
	       }
	      table.setModel(tableModel);
	      txtselectrow.setText(String.valueOf(rowcount));
	      txtselectcol.setText(String.valueOf(columnnumber));
	      repaint();
	}
	public TableView() {
		setVisible(true);
		////////////
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 1215, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 36, 1016, 579);
		contentPane.add(scrollPane);
		
		table = new JTable(100,20);
		table.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setAutoscrolls(true);
		table.setEnabled(true);
			
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(1036, 12, 153, 357);
		contentPane.add(tabbedPane);
		
		JPanel folderpanel = new JPanel();
		tabbedPane.addTab("Import", null, folderpanel, null);
		folderpanel.setLayout(null);
		
		JButton btnSearchFile = new JButton("Search File");
		btnSearchFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CSVfolder();
				file = CSVfolder.file;
				btnimport.setEnabled(true);
				selected=true;
				//setViewTable(file);
				//file = folderCSV;
				//txtImport.setText(csv.loc);
			}
		});
		btnSearchFile.setBounds(10, 144, 128, 23);
		folderpanel.add(btnSearchFile);
		
		txtImport = new JLabel();
		txtImport.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtImport.setBounds(10, 27, 128, 20);
		folderpanel.add(txtImport);
		//txtImport.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Selected File        .csv");
		lblNewLabel.setBounds(10, 55, 128, 14);
		folderpanel.add(lblNewLabel);
		
		btnimport = new JButton("Import");
		btnimport.setBounds(10, 273, 128, 23);
		btnimport.setEnabled(false);
		folderpanel.add(btnimport);		
		
		btnViewTable = new JButton("Preview");
		btnViewTable.setBounds(10, 189, 128, 23);
		folderpanel.add(btnViewTable);
		
		JPanel extractionpanel = new JPanel();
		tabbedPane.addTab("View Table", null, extractionpanel, null);
		extractionpanel.setLayout(null);
		
		txtselectrow = new JTextField();
		txtselectrow.setBounds(10, 71, 56, 20);
		extractionpanel.add(txtselectrow);
		txtselectrow.setColumns(10);
		
		txtselectcol = new JTextField();
		txtselectcol.setBounds(10, 102, 56, 20);
		extractionpanel.add(txtselectcol);
		txtselectcol.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Row");
		lblNewLabel_1.setBounds(76, 74, 46, 14);
		extractionpanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Column");
		lblNewLabel_2.setBounds(76, 105, 46, 20);
		extractionpanel.add(lblNewLabel_2);
		
		JLabel lblSelectRowAnd = new JLabel("Select Row and Column");
		lblSelectRowAnd.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSelectRowAnd.setBounds(10, 29, 128, 20);
		extractionpanel.add(lblSelectRowAnd);
		
		JLabel lblToPreview = new JLabel("to Preview");
		lblToPreview.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblToPreview.setBounds(10, 48, 128, 14);
		extractionpanel.add(lblToPreview);
		btnViewTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selected)
					setViewTable(CSVfolder.file);
				else
					JOptionPane.showMessageDialog(null, "None of the File/DataTable selected\nSelect or Create DataTable","Message",2);
			}
		});
		
		JButton btnDone = new JButton("Select This File");
		btnDone.setToolTipText("Click to Draw Graph of This DataTable");
		btnDone.setBounds(1046, 380, 131, 23);
		contentPane.add(btnDone);
		
		tablelabel = new JLabel();
		tablelabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		tablelabel.setBounds(10, 12, 681, 20);
		contentPane.add(tablelabel);
		
		JCheckBox chkbox = new JCheckBox("Manually Insert Cell");
		chkbox.setBounds(1046, 420, 132, 23);
		contentPane.add(chkbox);
		chkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkbox.isSelected()) 
				{
					selected =true;
					btnViewTable.setEnabled(false);
				}
				else
				{
					selected = false;
					btnViewTable.setEnabled(true);
				}
			}
		});
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selected)
					getArrayTable(rowselect=Integer.parseInt(txtselectrow.getText()),colselect=Integer.parseInt(txtselectcol.getText()));	
				else
					JOptionPane.showMessageDialog(null, "None of the File/DataTable selected\nSelect or Create DataTable","Message",2);
			}
		});
		table.setValueAt(row, 0, 0);	
	}
}
