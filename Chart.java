package graph;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.ButtonGroup;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;

public class Chart extends JFrame {

	private JPanel contentPane;
	public static double data[][];
	public static String header[][];
	JLabel ctlabel;
	/**
	 * @wbp.nonvisual location=112,159
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public int cType;

	/**
	 * cType :
	 * Column 1
	 * Line 2
	 * Bubble 3
	 * 
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chart frame = new Chart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public int chartType()
	{
		return cType;
	}
	void updateCtypeLabel(int ct)
	{
		String[] cts = {"Column Chart","Line Chart","Bubble Chart"};
		ctlabel.setText(cts[ct-1]);	
	}
	/**
	 * Create the frame.
	 */
	public Chart() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1201, 548);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 263, 487);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btndraw = new JButton("DRAW CHART");
		btndraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///////////////////
			}
		});
		btndraw.setBounds(30, 264, 191, 23);
		btndraw.setEnabled(false);
		panel.add(btndraw);
		
		JButton btnSelectDataTable = new JButton("Select Data Table");
		btnSelectDataTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TableView();
			}
		});
		btnSelectDataTable.setBounds(30, 230, 191, 23);
		panel.add(btnSelectDataTable);
		
		JButton btnCreateDataTable = new JButton("Create Data Table");
		btnCreateDataTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableView tb = new TableView();
				data = TableView.data;
				btndraw.setEnabled(true);
			}
		});
		btnCreateDataTable.setBounds(30, 196, 191, 23);
		panel.add(btnCreateDataTable);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 82, 49);
		panel.add(menuBar);
		
		JMenu mnCharts = new JMenu("CHARTS");
		menuBar.add(mnCharts);
		
		JMenuItem mntmColumn = new JMenuItem("Column");
		mntmColumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cType =1;
				updateCtypeLabel(cType);
			}
		});
		mnCharts.add(mntmColumn);
		
		JMenuItem mntmLine = new JMenuItem("Line");
		mntmLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cType =2;
				updateCtypeLabel(cType);
			}
		});
		mnCharts.add(mntmLine);
		
		JMenuItem mntmBubble = new JMenuItem("Bubble");
		mntmBubble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cType = 3;
				updateCtypeLabel(cType);
			}
		});
		mnCharts.add(mntmBubble);
		
		ctlabel = new JLabel();
		ctlabel.setBounds(30, 133, 191, 33);
		panel.add(ctlabel);
			
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
