import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;

public class box extends JLabel {
	public int mGenislik=20;
	public int mDirection=direction.sað;
box(){
	
	setBounds(100, 100, mGenislik, mGenislik);
	
	
}
public void paint(Graphics g) {

	Graphics2D g2= (Graphics2D)g;
	Rectangle2D rect = new Rectangle2D.Double(1,1,getWidth()-2,getHeight()-2);
	g2.setColor(Color.black);
	g2.setStroke(new BasicStroke(2));
	g2.draw(rect);
	g2.setColor(Color.red);
	g2.fill(rect);
}

public void goLeft() {
	int PosX=getX();
	int PosY=getY();
	PosX-=mGenislik;
	setBounds(PosX,PosY,mGenislik,mGenislik);
}
public void goRight() {

	int PosX=getX();
	int PosY=getY();
	PosX+=mGenislik;
	setBounds(PosX,PosY,mGenislik,mGenislik);

}
public void goUp() {

	int PosX=getX();
	int PosY=getY();
	PosY-=mGenislik;
	setBounds(PosX,PosY,mGenislik,mGenislik);
}
public void goDown() {

	int PosX=getX();
	int PosY=getY();
	PosY+=mGenislik;
	setBounds(PosX,PosY,mGenislik,mGenislik);
}
public box createBox() {
	box K=new box();
	
	int X=getX();
	int Y=getY();
	K.setBounds(X,Y, mGenislik, mGenislik);
	K.mDirection= -mDirection;
	K.motion();
	K.mDirection=mDirection;
	return K;
	
}
public void motion() {
	if(mDirection ==direction.sol)
		goLeft();
	else if(mDirection==direction.sað)
		goRight();
	else if(mDirection==direction.yukarý)
		goUp();
	else if(mDirection==direction.asagi)
		goDown();
	
	
}
}

