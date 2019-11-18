package objects;

import java.awt.Color;
import java.awt.Graphics;

import main.Constante;
import main.Game;
import main.GameObject;
import main.ID;
import main.MathCalculation;

public class Coin extends GameObject{

	public Coin(double x, double y) {
		super(x, y, ID.COIN);
	}

	@Override
	public void tick() {
		setX(MathCalculation.constrain(getX(), 0, (Game.CANVAS_WIDTH-Constante.SCALE)/Constante.SCALE));
		setY(MathCalculation.constrain(getY(), 0, (Game.CANVAS_HEIGHT-Constante.SCALE)/Constante.SCALE));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval((int)getX()*Constante.SCALE, (int)getY()*Constante.SCALE, Constante.SCALE, Constante.SCALE);
	}

}
