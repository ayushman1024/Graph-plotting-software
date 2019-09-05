package graph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.JWindow;
import javax.swing.UIManager;

public class SplashG extends JWindow {
	private static final long serialVersionUID = 1L;
	private JTextPane connect;
	/**
	 * Launch the application.
	 */
	 public void showSplash(int duration) {  
		    JPanel content = (JPanel) getContentPane();
		    content.setBackground(Color.black);
		    JLabel label = new JLabel(new ImageIcon("1.gif"));
		    content.add(label, BorderLayout.CENTER);
		    content.setBorder(BorderFactory.createLineBorder(new Color(90,90,200), 6));
		    //content.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED,Color.ORANGE,Color.GRAY));    
		    setVisible(true);
		    
		 	JProgressBar progressBar = new JProgressBar();
		  	progressBar.setBounds(65, 475, 680, 8);
		  	getContentPane().add(progressBar);
		  	for(int i =0;i<100;i++) 
		  	{
		  		progressBar.setStringPainted(true);
		  		progressBar.setValue(i);
		  		try {
		  			Thread.sleep(duration);
			    } catch (Exception e) {}
		  	}
	    setVisible(false);
	  }
	//////////
	public static void main(String[] args) {
		SplashG splash = new SplashG();
		splash.setVisible(true);
		splash.showSplash(60);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {				 
					new Paperf();
					/*Checks and create following Directory*/
				File directory = new File("D:\\GraphPlottingSuite\\");
				File directory1 = new File("D:\\GraphPlottingSuite\\Screenshot\\");
				File directory2 = new File("D:\\GraphPlottingSuite\\DataCSV\\");
				File sample = new File("D:\\GraphPlottingSuite\\DataCSV\\sample.csv");
				if (! sample.exists()){
			        sample.createNewFile();
				}
			    if (! directory.exists()){
			        directory.mkdir();
			    }
			    if (! directory1.exists()){
			        directory1.mkdir();
			    }
			    if (! directory2.exists()){
			        directory2.mkdir();
			    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SplashG() {	
		getContentPane().setForeground(new Color(0, 0, 0));
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 820;
		int height = 480;
		    int x = (screen.width - width) / 2;
		    int y = (screen.height - height) / 2;
		    setBounds(x, y, 820, 512);	
		    getContentPane().setLayout(null);
		    
		    /*Animated LOGO*/
		Imgpanel panel = new Imgpanel();
		  	panel.setBounds(172, 98, 397, 253);
		  	getContentPane().add(panel);
	  	
	  	JLabel lblFractalArts = new JLabel("Graph Plotting \nSoftware Suite");
	  	lblFractalArts.setForeground(new Color(153, 204, 204));
	  	lblFractalArts.setFont(new Font("Pristina", Font.BOLD, 48));
	  	lblFractalArts.setBounds(72, 11, 668, 122);
	  	getContentPane().add(lblFractalArts); 
	  	
	  	connect = new JTextPane();
	  	connect.setFont(new Font("Verdana", Font.PLAIN, 16));
	  	connect.setForeground(UIManager.getColor("CheckBox.background"));
	  	connect.setBackground(SystemColor.activeCaptionText);
	  	connect.setBounds(10, 374, 680, 108);
	  	getContentPane().add(connect);
	  	
	try{		
		URL url_name = new URL("http://bot.whatismyipaddress.com"); 
		BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
		String systemipaddress = sc.readLine().trim();
		InetAddress localhost = InetAddress.getLocalHost();
		String connectionstatus = "Connected to internet\r\nSystem IP Address"+systemipaddress+"\nPublic IP Address:"+localhost ;
	  	connect.setText(connectionstatus);
	    	}catch(Exception e){
	    		connect.setText("\tYou are not connected to internet\n"+"Some of the Tools may not work.");
	    		e.printStackTrace();} 	
	  }
}
