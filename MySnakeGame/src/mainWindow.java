import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
public class mainWindow extends JFrame {
	private int mWidth=600;
	private int mHeight=600;
	private static mainWindow pencere=null;
private mainWindow(){
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	setDimension( mWidth, mHeight);
	
	Snake y=new Snake();
	add(y);
	
}
public static mainWindow getWindow() {
	if(pencere==null)
		pencere=new mainWindow();
	
	return pencere;
	
}
public void setDimension(int genislik, int yuseklik ) {
	Dimension Dim= Toolkit.getDefaultToolkit().getScreenSize();
	int PosX=0;
	int PosY=0;
	if(mWidth+100>Dim.width) {
		mWidth=Dim.width-100;
	}
	if(mHeight +100>Dim.height ) {
		mHeight=Dim.height-100;
	}
 PosX= (Dim.width-mWidth)/2;
 PosY= (Dim.height-mHeight)/2;
 setBounds(PosX, PosY, mWidth, mHeight);
}
}
