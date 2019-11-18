package main;

public class MathCalculation {
	
	public static double constrain(double value, double min, double max) {
		if(value < min) return min;
		if(value > max) return max;
		return value;
	}
	
	public static double distance(GameObject o1, GameObject o2) {
		return MathCalculation.distance(o1.getX(), o1.getY(), o2.getX(), o2.getY());
	}
	
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
	}
}
