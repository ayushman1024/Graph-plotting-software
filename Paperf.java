package graph;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JToolBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class Paperf extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JLabel txtXvalue ,txtYvalue;
	Paper panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paperf frame = new Paperf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Paperf() {
		
		/////////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,5, 1406, 739);	
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		
		panel = new Paper();
		panel.setBounds(15, 15, 1080, 600);
		panel.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent zm) {
				if(panel.zoom>=10)
					panel.zoom-=zm.getWheelRotation()*10;
				else {
					panel.zoom=10;
				}
				panel.repaint();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1105, 15, 252, 600);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFunc = new JLabel("Function");
		lblFunc.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFunc.setBounds(10, 11, 232, 58);
		panel_1.add(lblFunc);
		
		txtXvalue = new JLabel();
		txtXvalue.setBounds(59, 116, 86, 20);
		panel_1.add(txtXvalue);
		
		txtYvalue = new JLabel();
		txtYvalue.setBounds(59, 146, 86, 20);
		panel_1.add(txtYvalue);
		
		JLabel lblY = new JLabel("Y =");
		lblY.setBounds(10, 152, 46, 14);
		panel_1.add(lblY);
		
		JLabel lblX = new JLabel("X  =");
		lblX.setBounds(10, 122, 46, 14);
		panel_1.add(lblX);
		
		JLabel lblCoordinates = new JLabel("Coordinates");
		lblCoordinates.setBounds(31, 177, 96, 14);
		panel_1.add(lblCoordinates);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ereset) {
				panel.func=0;
				panel.repaint();
			}
		});
		btnReset.setBounds(20, 271, 86, 23);
		panel_1.add(btnReset);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmImportCsv = new JMenuItem("Import CSV");
		mntmImportCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ecsv) {
				//new CSVreader();
			}
		});
		mnFile.add(mntmImportCsv);
		
		JMenu mnNewMenu = new JMenu("Create");
		menuBar.add(mnNewMenu);
		
		JMenu mnfunc = new JMenu("Function");
		mnNewMenu.add(mnfunc);
		
		JMenuItem mntmYSine = new JMenuItem("y = sin(x)");
		mntmYSine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent esin) {
				panel.func =1;
				panel.repaint();
				lblFunc.setText("y = sin(x)");
			}
		});
		mnfunc.add(mntmYSine);
		
		JMenuItem mntmYCos = new JMenuItem("y = cos(x)");
		mntmYCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ecos) {
				panel.func =2;
				panel.repaint();
				lblFunc.setText("y = cos(x)");
			}
		});
		mnfunc.add(mntmYCos);
		
		JMenuItem mntmYTan = new JMenuItem("y = tan(x)");
		mntmYTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent etan) {
				panel.func =3;
				panel.repaint();
				lblFunc.setText("y = tan(x)");
			}
		});
		
		mnfunc.add(mntmYTan);
		
		JMenuItem mntmYLog = new JMenuItem("y = log(x)");
		mntmYLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent elog) {
				panel.func =4;
				panel.repaint();
				lblFunc.setText("y = log(x)");
			}
		});
		mnfunc.add(mntmYLog);
		
		JMenuItem mntmYSin2 = new JMenuItem("y = sin^2(x)");
		mntmYSin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent esin2) {
				panel.func =5;
				panel.repaint();
				lblFunc.setText("y = sin^2(x)");
			}
		});
		mnfunc.add(mntmYSin2);
		
		JMenuItem mntmCharts = new JMenuItem("Charts");
		mntmCharts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chart chart = new Chart();
			}
		});
		mnNewMenu.add(mntmCharts);
		
		JMenuItem mntmPaint = new JMenuItem("Paint");
		mntmPaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu.add(mntmPaint);
		
		JMenu mnGraph = new JMenu("Properties");
		menuBar.add(mnGraph);
		
		JToggleButton tglinvert = new JToggleButton("Invert");
		mnGraph.add(tglinvert);
		tglinvert.setSelected(panel.invert);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(panel, popupMenu);
		
		JToggleButton tglcursor = new JToggleButton();
		tglcursor.setHorizontalAlignment(SwingConstants.LEFT);
		tglcursor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tglcursor.setSelected(panel.highlightCursor);
		if(tglcursor.isSelected())
			tglcursor.setText("Cursor   ON");
		else
			tglcursor.setText("Cursor OFF");
		tglcursor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.highlightCursor= tglcursor.isSelected();
				if(tglcursor.isSelected())
					tglcursor.setText("Cursor ON");
				else
				tglcursor.setText("Cursor OFF");
			}
		});
		popupMenu.add(tglcursor);
		
		JToggleButton toggleButton = new JToggleButton("Invert");
		toggleButton.setSelected(false);
		//popupMenu.add(tglinvert);
		
		//popupMenu.add(btnReset);
		
		JMenu mnCntrl = new JMenu("Controls");
		menuBar.add(mnCntrl);
		
		JMenuItem mntmZoomMouse = new JMenuItem("Zoom : Mouse wheel rotation");
		mnCntrl.add(mntmZoomMouse);
		tglinvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.invert=tglinvert.isSelected();
				panel.repaint();
			}
		});
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


