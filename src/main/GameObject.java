package main;

import java.awt.Graphics;

import util.Position;

public abstract class GameObject {
	protected Position pos;
	protected ID id;
	protected double velX, velY;
	
	public GameObject(double x, double y, ID id) {
		this.pos = new Position(x, y);
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	

	public double getX() {
		return pos.getX();
	}

	public void setX(double x) {
		pos.setX(x);
	}

	public double getY() {
		return pos.getY();
	}

	public void setY(double y) {
		pos.setY(y);
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}
	
	
}
