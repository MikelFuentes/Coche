package prin;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{

	JPanel panelCentro, panelBotones, panelInterface;
	JButton bAcelerar, bFrenar, bGirarIz, bGirarDe;
	JLabelCoche grafCoche;
	
	public Ventana() {
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		this.setSize(800, 800);
		panelCentro = new JPanel(new BorderLayout());
		
		panelCentro.add(crearBotonera(), BorderLayout.SOUTH);
		this.setVisible(true);
		
		grafCoche = new JLabelCoche();
		
		
		
		Container panelPrincipal = getContentPane();
		panelPrincipal.add(panelCentro);
	}
	
	private JPanel crearBotonera() {
		panelBotones = new JPanel();
		bAcelerar = new JButton("Acelerar");
		bFrenar = new JButton("Frenar");
		bGirarIz = new JButton("Girar izquierda");
		bGirarDe = new JButton("Girar derecha");
		
		panelBotones.add(bAcelerar);
		panelBotones.add(bFrenar);
		panelBotones.add(bGirarIz);
		panelBotones.add(bGirarDe);
		return panelBotones;
		
	}
}
