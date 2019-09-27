package prin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Ventana extends JFrame{

	JPanel panelCentro, panelBotones, panelInterface;
	JButton bAcelerar, bFrenar, bGirarIz, bGirarDe;
	CocheJuego grafCoche;
	Hilo miHilo = null;
	
	
	public Ventana() {
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		this.setSize(800, 800);
		panelCentro = new JPanel(null);
		
		
		
		grafCoche = new CocheJuego();
		
		panelCentro.add(grafCoche.getGrafico());
		
		Container panelPrincipal = getContentPane();
		panelPrincipal.add(panelCentro);
		panelPrincipal.add(crearBotonera(), BorderLayout.SOUTH);
		
		
		this.setVisible(true);
	}
	
	private JPanel crearBotonera() {
		panelBotones = new JPanel();
		
		bAcelerar = new JButton("Acelerar");
		bAcelerar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				grafCoche.acelera(5);
				System.out.println(grafCoche.getMiVelocidad());
			}
			
		});
		bFrenar = new JButton("Frenar");
		bFrenar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				grafCoche.acelera(-5);
				System.out.println(grafCoche.getMiVelocidad());
			}
			
		});
		
		
		bGirarIz = new JButton("Girar izquierda");
		bGirarIz.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				grafCoche.gira(10);
				System.out.println(grafCoche.getMiDireccionActual());
			}
			
		});
		bGirarDe = new JButton("Girar derecha");
		bGirarDe.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				grafCoche.gira(-10);
				System.out.println(grafCoche.getMiDireccionActual());
			}
			
		});
		
		panelBotones.add(bAcelerar);
		panelBotones.add(bFrenar);
		panelBotones.add(bGirarIz);
		panelBotones.add(bGirarDe);
		return panelBotones;
		
	}
	class Hilo implements Runnable{
		boolean seguir = true;
		
		Hilo(){
		}
		public void bucle() {
			while (seguir){
				Ventana.this.grafCoche.mueve(0.04);
				Ventana.this.grafCoche.toString();
			}
			
		}
	}
	
}
