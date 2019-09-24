package prin;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCoche extends JLabel{
	
	private Coche datCoche;
	
	public JLabelCoche() {
		ImageIcon image = new ImageIcon("/img/coche.png");
		this.setIcon(image);
		this.setBounds(0, 0, 100, 100);	
		
	}

}	




