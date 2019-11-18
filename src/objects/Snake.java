package objects;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import main.Constante;
import main.Game;
import main.GameObject;
import main.GameState;
import main.ID;
import util.Position;

public class Snake extends GameObject{
	
	private int nbPoint = 0;
	private boolean justAdd = false;
	private List<Position> tail;
	
	public Snake(double x, double y) {
		super(x, y, ID.SNAKE);
		tail = new ArrayList<>();
		for(int i = 0; i < 20; i++) addSnake();
	}
	
	public void setDir(double x, double y) {
		velX = x;
		velY = y;
	}
	
	public void addSnake() {
		nbPoint++;
		tail.add(new Position(getX(), getY()));
		justAdd = true;
	}
	
	private void shiftPos() {
		for(int i = 0; i < nbPoint-1; i++) {
			tail.set(i, tail.get(i+1));
		}
		tail.set(tail.size()-1, new Position(getX(), getY()));
	}
	
	private boolean isDead() {
		int count = 0;
		for(Position p : tail)
			if(p.equals(pos)) count++;
		if(count > 1) return true;
		return false;
	}

	@Override
	public void tick() {
		
		shiftPos();
		if(!justAdd && isDead()) {
			Game.gameState = GameState.GAMEOVER;
		}
		justAdd = false;
		
		setX(getX()+velX);
		setY(getY()+velY);
		/*setX(MathCalculation.constrain(getX(), 0, (Game.CANVAS_WIDTH-Constante.SCALE)/Constante.SCALE));
		setY(MathCalculation.constrain(getY(), 0, (Game.CANVAS_HEIGHT-Constante.SCALE)/Constante.SCALE));*/
		if(getX() < 0) setX((Game.CANVAS_WIDTH-Constante.SCALE)/Constante.SCALE);
		if(getX() > (Game.CANVAS_WIDTH-Constante.SCALE)/Constante.SCALE) setX(0);
		if(getY() < 0) setY((Game.CANVAS_HEIGHT-Constante.SCALE)/Constante.SCALE);
		if(getY() > (Game.CANVAS_HEIGHT-Constante.SCALE)/Constante.SCALE) setY(0);
	}

	@Override
	public void render(Graphics g) {
		for(int i = 0; i < tail.size(); i++) {
			g.fillRect((int)tail.get(i).getX()*Constante.SCALE, (int)tail.get(i).getY()*Constante.SCALE, Constante.SCALE, Constante.SCALE);
		}
	}

}
