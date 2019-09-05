package graph;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Imgpanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4132039561254576854L;
	Image image;

	  public Imgpanel() {
	    image = Toolkit.getDefaultToolkit().createImage("img.gif");
	  }

	  @Override
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    if (image != null) {
	      g.drawImage(image, 0, 0, this);
	    }
	  }

	/**
	 * Create the panel.
	 */

}
