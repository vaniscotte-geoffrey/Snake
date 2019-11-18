package objects;

import java.util.Random;

import main.Constante;
import main.GameObject;
import main.Handler;
import main.MathCalculation;

public class Spawner {
	Handler handler;

	public Spawner(Handler handler) {
		this.handler = handler;
	}
	
	public void addCoin() {
		double x, y;
		Random r = new Random();
		boolean availableCoord;
		do {
			availableCoord = true;
			x = r.nextInt(Constante.WINDOW_WIDTH/Constante.SCALE);
			y = r.nextInt(Constante.WINDOW_HEIGHT/Constante.SCALE);
			for(int i = 0; i < handler.size(); i++) {
				GameObject object = handler.get(i);
				if(MathCalculation.distance(x,y, object.getX(), object.getY()) < 1) {
					availableCoord = false;
					break;
				}
			}
		} while(!availableCoord);
		
		handler.addObject(new Coin(x, y));
	}
	
	
}
