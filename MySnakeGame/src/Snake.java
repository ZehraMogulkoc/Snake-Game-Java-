import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Snake extends JLabel{
	public box mHead= new box();
	public bait myem=new bait();
	public Timer mTimer= null;
	public Random mrandom=null;
	public ArrayList<box> liste =new ArrayList<box>();
	@Override
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2= (Graphics2D)g;
		Rectangle2D rect = new Rectangle2D.Double(5,5,getWidth()-10,getHeight()-10);
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(10));
		g2.draw(rect);
		
	}
Snake(){
	mrandom=new Random(System.currentTimeMillis());
	addKeyListener(new keyboardControl());
	setFocusable(true);
	
	mTimer= new Timer(100,new timerControl());
	mTimer.start();
	liste.add(mHead);
	for(int i=1;i<10;i++) {
		addTail();
	}
	add(myem);
	
	
	add(mHead);
	
	
}
public void addTail() {
	box K= liste.get(liste.size()-1).createBox();
	liste.add(K);
	add(K);
}
public void addBait() {
	int width=getWidth()-30-myem.mgenislik;
	int height =getHeight()-30-myem.mgenislik;
	int posX=10+Math.abs(mrandom.nextInt())%width;
	int posY=10+Math.abs(mrandom.nextInt()) %height;
	posX=posX-(posX%20);
	posY=posY-(posY%20);
	myem.setPosition(posX, posY);
			}

public void executeAll() {
	
	for(int i=liste.size()-1;i>0;i--) {
		box before =liste.get(i-1);
		box after=liste.get(i);
	
		
		liste.get(i).motion();
		after.mDirection=before.mDirection;
	}
	mHead.motion();
}
public boolean hasCollision(){
	int pencil =10;
	int genislik=getWidth();
	int yukseklik=getHeight();
	if(mHead.getX()<=10) {
		return true;
	}
	if(mHead.getX()+mHead.mGenislik>=genislik-pencil) {
		return true;
	}
	if(mHead.getY()<=10) {
		return true;
	}
	if(mHead.getY()+mHead.mGenislik>=yukseklik-pencil) {
		return true;
	}
	for(int i=1;i<liste.size();i++)
	{
		int x=liste.get(i).getX();
		int y=liste.get(i).getY();
		if(x==mHead.getX()&& y==mHead.getY()) {
			return true;
		}
	}
	
	if(myem.getX()==mHead.getX()&& myem.getY()==mHead.getY()) {
		addTail();
		addBait();
	}
	return false;
}
class keyboardControl implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	if(e.getKeyCode()==KeyEvent.VK_LEFT)
	{
		if(mHead.mDirection!=direction.sað)
		   mHead.mDirection=direction.sol;
	}
	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
	{
		if(mHead.mDirection!=direction.sol)
           mHead.mDirection=direction.sað;
	}
	if(e.getKeyCode()==KeyEvent.VK_UP)	
	{
		if(mHead.mDirection!=direction.asagi)
		   mHead.mDirection=direction.yukarý;
	}
	if(e.getKeyCode()==KeyEvent.VK_DOWN)
	{
		if(mHead.mDirection!=direction.yukarý)
		   mHead.mDirection=direction.asagi;
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
class timerControl implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
	
			
	executeAll();
	
	if(hasCollision())
		mTimer.stop();
	}
	
}
}
