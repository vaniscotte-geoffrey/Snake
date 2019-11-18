package io;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.Constante;
import main.GameObject;
import main.Handler;
import main.ID;
import objects.Snake;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private final double SPEED = Constante.SPEED;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.size(); i++) {
			GameObject object = handler.get(i);
			
			if(object.getId() == ID.SNAKE) {
				if(key == KeyEvent.VK_LEFT)	((Snake)object).setDir(-SPEED, 0);
				if(key == KeyEvent.VK_RIGHT) ((Snake)object).setDir(SPEED, 0);
				if(key == KeyEvent.VK_DOWN) ((Snake)object).setDir(0, SPEED);
				if(key == KeyEvent.VK_UP) ((Snake)object).setDir(0, -SPEED);
			}
		}
	}
}
