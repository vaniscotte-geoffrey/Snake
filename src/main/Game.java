package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import io.KeyInput;
import objects.Collision;
import objects.Snake;
import objects.Spawner;


public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	public static int CANVAS_WIDTH;
	public static int CANVAS_HEIGHT;
	
	private Thread thread;
	private boolean running = false;
	
	private Snake s;
	
	public static GameState gameState;
	
	private Handler handler;
	private KeyInput keyInput;
	private Spawner spawner;
	private Collision collision;
	
	public Game() {
		new Window(Constante.WINDOW_WIDTH, Constante.WINDOW_HEIGHT, "Snake", this);
		handler = new Handler();
		keyInput = new KeyInput(handler);
		spawner = new Spawner(handler);
		collision = new Collision(handler, spawner);
		gameState = GameState.PLAYING;
		
		addKeyListener(keyInput);
		s = new Snake(0, 0);
		s.setDir(Constante.SPEED, 0);
		handler.addObject(s);
		
		spawner.addCoin();
	}
	
	public static void main(String[] args) {
		new Game();
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 25.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			CANVAS_WIDTH = getWidth();
			CANVAS_HEIGHT = getHeight();
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		if(gameState == GameState.PLAYING) {			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Constante.WINDOW_WIDTH, Constante.WINDOW_HEIGHT);
			g.setColor(Color.WHITE);
			
			handler.render(g);
		} else if(gameState == GameState.GAMEOVER) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, Constante.WINDOW_WIDTH, Constante.WINDOW_HEIGHT);
			g.setColor(Color.BLACK);
			g.drawString("Game Over pédé", CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2);
		}
		g.dispose();
		bs.show();
	}

	private void tick() {
		handler.tick();
		collision.checkCollision(s);
	}
}
