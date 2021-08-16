import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class bait extends JLabel {
	public int mgenislik=20;
	bait(){
		
		setPosition(20,20);
		
	}
	public void paint(Graphics g) {

		Graphics2D g2= (Graphics2D)g;
	Ellipse2D  ellipse = new Ellipse2D.Double(1,1,mgenislik-2,mgenislik-2);
		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(2));
		g2.draw(ellipse);
		g2.setColor(Color.red);
		g2.fill(ellipse);
	}
	public void setPosition(int x,int y ) {
		setBounds(x,y,mgenislik,mgenislik);
	}

}
