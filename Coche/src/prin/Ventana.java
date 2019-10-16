package prin;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Ventana extends JFrame{

	JPanel panelCentro, panelBotones, panelInterface;
	JButton bAcelerar, bFrenar, bGirarIz, bGirarDe;
	CocheJuego coche;
	JLabelCoche grafCoche;
	Hilo hiloVen;
	
	
	public Ventana() {
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		this.setSize(800, 800);
		panelCentro = new JPanel(null);
		
		Hilo h = new Hilo();
		
		
		coche = new CocheJuego();
		
		
		panelCentro.add(coche.getGrafico());
		
		Container panelPrincipal = getContentPane();
		panelPrincipal.add(panelCentro);
		panelPrincipal.add(crearBotonera(), BorderLayout.SOUTH);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		    	h.acaba();
		    }
		});
		h.run();
	
	}
	
	private JPanel crearBotonera() {
		panelBotones = new JPanel();
		
		bAcelerar = new JButton("Acelerar");
		bAcelerar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(5);
				//System.out.println(coche.getMiVelocidad());
			}
			
		});
		bFrenar = new JButton("Frenar");
		bFrenar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(-5);
				//System.out.println(coche.getMiVelocidad());
			}
			
		});
		
		
		bGirarIz = new JButton("Girar izquierda");
		bGirarIz.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(-10);
				//System.out.println(coche.getMiDireccionActual());
			}
			
		});
		
		
		bGirarDe = new JButton("Girar derecha");
		bGirarDe.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(10);
				//System.out.println(coche.getMiDireccionActual());
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
		@Override
		public void run() {
			while (seguir){
				double direc = 0;
				
				Ventana.this.coche.mueve(0.04);
				Ventana.this.coche.getGrafico().setRotacion(Ventana.this.coche.getMiDireccionActual());
				//System.out.println(Ventana.this.coche.getPosX());
				
				if (Ventana.this.coche.getPosX() < -10 || Ventana.this.coche.getPosX() > Ventana.this.panelCentro.getWidth() - 100) {
					
				
					direc = Ventana.this.coche.getMiDireccionActual();
					direc = 360 - direc;
					//System.out.println(" PONG ");
					Ventana.this.coche.setMiDireccionActual(direc);
				}
				
				if (Ventana.this.coche.getPosY() < -10 || Ventana.this.coche.getPosY() > Ventana.this.panelCentro.getHeight() - 100) {
					
					
					direc = Ventana.this.coche.getMiDireccionActual();
					direc = 180 - direc;
					//System.out.println(" PONG ");
					Ventana.this.coche.setMiDireccionActual(direc);
				}
					
					
				//System.out.println(Ventana.this.coche.toString());
				try {
					Thread.sleep(4);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		public void acaba() {
            this.seguir = false;
		}
		
	}
	
}
