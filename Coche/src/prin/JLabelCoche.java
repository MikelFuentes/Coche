package prin;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCoche extends JLabel{
	private double rotacion = Math.PI;
	private Coche datCoche;
	
	public JLabelCoche() {
		ImageIcon image = new ImageIcon("src/Img/coche.png");
		this.setIcon(image);
		this.setBounds(0, 0, 100, 100);	
		
		
		
		
		
	}

	 public void setRotacion(double rotacion) {
		this.rotacion = rotacion * Math.PI / 180 ;
	}
	 
	@Override
	    protected void paintComponent(Graphics g) {
	        Image img = ((ImageIcon)this.getIcon()).getImage();
	        Graphics2D g2 = (Graphics2D)g;
	        g2.rotate(this.rotacion, 50.0, 50.0);
	        g2.drawImage(img, 0, 0, 100, 100, null);
	    }
	

}	




