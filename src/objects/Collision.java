package objects;

import main.GameObject;
import main.Handler;
import main.ID;
import main.MathCalculation;

public class Collision {
	Handler handler;
	Spawner spawner;

	public Collision(Handler handler, Spawner spawner) {
		this.handler = handler;
		this.spawner = spawner;
	}
	
	
	public void checkCollision(Snake s) {
		for(int i = 0; i < handler.size(); i++) {
			GameObject object = handler.get(i);
			if(object.getId() == ID.COIN) {
				if(MathCalculation.distance(s, object) < 1) {
					s.addSnake();
					handler.removeObject(object);
					spawner.addCoin();
				}
			}
		}
	}
}
