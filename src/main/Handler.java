package main;

import java.awt.Graphics;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Handler {
	private List<GameObject> objects = new LinkedList<>();

	public void tick() {
		for(int i = 0; i < objects.size(); i++) {
			GameObject tmpObject = objects.get(i);
			tmpObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < objects.size(); i++) {
			GameObject tmpObject = objects.get(i);
			tmpObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		objects.remove(object);
	}

	public int size() {
		return objects.size();
	}

	public boolean isEmpty() {
		return objects.isEmpty();
	}

	public boolean contains(Object o) {
		return objects.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return objects.containsAll(c);
	}

	public void clear() {
		objects.clear();
	}

	public GameObject get(int index) {
		return objects.get(index);
	}

	public int indexOf(Object o) {
		return objects.indexOf(o);
	}
	
	
}
