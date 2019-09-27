package prin;

import java.awt.event.ActionEvent;

public class CocheJuego extends Coche{
	
	private JLabelCoche dibujoCoche;
	
	public CocheJuego(){
		dibujoCoche = new JLabelCoche();
		
	}
	 public JLabelCoche getGrafico() {
	        return this.dibujoCoche;
	}
	@Override
	public void setPosX(double posX) {
		dibujoCoche.setLocation((int)posX, (int)posY);
		super.setPosX(posX);
	}
	@Override
	public void setPosY(double posY) {
		// TODO Auto-generated method stub
		dibujoCoche.setLocation((int)posX, (int)posY);
		super.setPosY(posY);
	}

	

}
