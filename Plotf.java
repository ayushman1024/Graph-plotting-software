import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Plotf extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public static JTextPane txtXvalue ,txtYvalue;
	Paper panel;
	public Plotf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1306, 689);	
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new Paper();
		panel.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent zm) {
				if(panel.zoom>=10)
					panel.zoom-=zm.getWheelRotation()*10;
				else {
					panel.zoom=10;
				}
				System.out.println(zm.getWheelRotation()*10+" "+panel.zoom);
				panel.repaint();
			}
		});
		panel.setBounds(10, 10, 1080, 600);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1100, 11, 180, 607);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFunc = new JLabel("Function");
		lblFunc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblFunc.setBounds(10, 11, 160, 30);
		panel_1.add(lblFunc);
		
		txtXvalue = new JTextPane();
		txtXvalue.setBounds(59, 116, 86, 20);
		panel_1.add(txtXvalue);
		
		txtYvalue = new JTextPane();
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
		btnReset.setBounds(84, 573, 86, 23);
		panel_1.add(btnReset);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmImportCsv = new JMenuItem("Import CSV");
		mntmImportCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ecsv) {
				new CSVreader();
			}
		});
		mnFile.add(mntmImportCsv);
		
		JMenu mnfunc = new JMenu("Function");
		menuBar.add(mnfunc);
		
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
		
		JMenu mnGraph = new JMenu("Properties");
		menuBar.add(mnGraph);
		
		JToggleButton tglinvert = new JToggleButton("Invert");
		mnGraph.add(tglinvert);
		tglinvert.setSelected(panel.invert);
		
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
}
