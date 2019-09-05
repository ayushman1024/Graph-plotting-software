package graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class Paper extends JPanel {
	/**
	 * 
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean invert,highlightCursor=true;	
	static Graphics2D gi;
	int func;double zoom=10;
	int posx,posy;
	/**
	 * Create the panel.
	 */
	public void initChart(String[] header,double[][] table,int r,int c)
	{
		
	}
	public Paper() {
		invert=false;
		addMouseMotionListener(new MouseMotionAdapter() {
	         public void mouseMoved(MouseEvent e) {
	            posx=e.getX() ;
	            posy=e.getY() ;
	            Paperf.txtXvalue.setText(String.valueOf((posx - getWidth()/2)/(zoom)));
	            Paperf.txtYvalue.setText(String.valueOf(-(posy - getHeight()/2)/(zoom)));
	            repaint();
	         }
	      });
	}
	public void PaperBar() {
		new TableView();
		double data[][] = new double[100][100];
		
	}
	public void resetPaper() {	
		this.zoom=10;
		Stroke s2 = new BasicStroke(1f);
		gi.setStroke(s2);
	}
	
	public void highlightCursor(Graphics2D gh)
	{
		gh.setColor(Color.RED);
		gh.drawLine(posx,0,posx,getHeight());
		gh.drawLine(0,posy,getWidth(),posy);
	}
	/////////
	public void sine(double x,double y,Graphics2D gi)
	{
		
		for(double i=-250;i<250;i+=0.001) 
		{
			x = zoom*i;	double x2 = zoom*(i+1);    y = -zoom*Math.sin(i); double y2 = -zoom*Math.sin(i+1);
			Line2D ln = new Line2D.Double(this.getWidth()/2+x,this.getHeight()/2+y,this.getWidth()/2+x,this.getHeight()/2+y);
			gi.draw(ln);
		}
	}
	public void cos(double x,double y,Graphics2D gi)
	{
		
		for(double i=-250;i<250;i+=0.001) 
		{
			x = zoom*i;	    y = -zoom*Math.cos(i);
			Line2D ln = new Line2D.Double(this.getWidth()/2+x,this.getHeight()/2+y,this.getWidth()/2+x,this.getHeight()/2+y);
			gi.draw(ln);		
		}
	}
	public void tan(double x,double y,Graphics2D gi)
	{
		
		for(double i=-250;i<250;i+=0.001) 
		{
			x = zoom*i;	    y = -zoom*Math.tan(i);
			Line2D ln = new Line2D.Double(this.getWidth()/2+x,this.getHeight()/2+y,this.getWidth()/2+x,this.getHeight()/2+y);
			gi.draw(ln);		
		}
	}
	public void log(double x,double y,Graphics2D gi)
	{		
		for(double i=-250;i<250;i+=0.001) 
		{
			x = zoom*i;	    y = -zoom*Math.log(i);
			Line2D ln = new Line2D.Double(this.getWidth()/2+x,this.getHeight()/2+y,this.getWidth()/2+x,this.getHeight()/2+y);
			gi.draw(ln);
		}
	}
	public void sin2(double x,double y,Graphics2D gi)
	{
		for(double i=-250;i<250;i+=0.001) 
		{
			x = zoom*i;	    y = -zoom*Math.sin(i); y=-1*y*y;
			Line2D ln = new Line2D.Double(this.getWidth()/2+x,this.getHeight()/2+y,this.getWidth()/2+x,this.getHeight()/2+y);
			gi.draw(ln);		
		}
	}
	
	/////
	public void paintComponent(Graphics g) {
		Color grid = new Color(5,190,40),paper = Color.BLACK,curve=Color.WHITE;
		gi = (Graphics2D) g;
		if(true)
			gi.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);		
		super.paintComponent(gi);	
		int height =this.getHeight();
		int width = this.getWidth();
		if(invert) {
			curve = Color.BLACK;
			paper = Color.WHITE;
			grid = new Color(5,200,50);
			}
		gi.setColor(curve);
		setBackground(paper);
		if(func==1)
			sine(0,0,gi);	
		else if(func==2)
			cos(0,0,gi);
		else if(func==3)
			tan(0,0,gi);
		else if(func==4)
			log(0,0,gi);
		else if(func==5)
			sin2(0,0,gi);	
		///////////////
		
		Stroke s1 = new BasicStroke(0.2f);gi.setStroke(s1);
		gi.setColor(grid);
		/*Preparing Gridlines of size 10Pixels*/
		for(int i=0;i<this.getWidth();i=i+10) {
			gi.drawLine(i, 0, i, this.getHeight());	
			}
		for(int i=0;i<this.getHeight();i=i+10)
			gi.drawLine(0, i, this.getWidth(),i);
																//To highlight Origin
		gi.setStroke(new BasicStroke(1));
		gi.drawLine(this.getWidth()/2,0,this.getWidth()/2,this.getHeight());
		gi.drawLine(0,this.getHeight()/2,this.getWidth(),this.getHeight()/2);
		/*Mouse Position*/
		if(highlightCursor)
			highlightCursor(gi);
	}

}
