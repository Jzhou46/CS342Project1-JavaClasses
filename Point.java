/* @Jeffrey Zhou
 * Jzhou46
 * CS 342
 * Prof. Buy
 * 1/20/15
 * Homework 1
 * Point Class
 */

package edu.uic.Jzhou46.cs342;
public class Point {//Point class
	
	private int x = 0;//predefined x
	private int y = 0;//predefined y 
	
	public Point(int x, int y){//Constructor with arguments
		this.x = x;
		this.y = y; 
	};
	
	public Point(){//Constructor with no arguments
	}; 
	
	public int x(){//x getter
		return x;
	}	
	public void x(int newElem){//x setter
		x = newElem;
	}
	public int y(){//y getter
		return y;
	}
	public void y(int newElem){//y setter
		y = newElem;
	}
	public double slope(Point p){//slope method
		double m = ((double)p.y() - (double)this.y()) / ((double)p.x() - (double)this.x());//Slope function
		double denominator = ((double)p.x() - (double)this.x()); 
		if(denominator == 0){//If the slope is infinite
			if(m < 0){//if negative 
				double negInfinity = Double.NEGATIVE_INFINITY;
				return negInfinity; 
			}
			else{//Positive 
				double posInfinity = Double.POSITIVE_INFINITY;
				return posInfinity; 
			}
		}
		return m;//non-infinite number
	}

	public double distance(Point p){//distance method
		double first = ((double)p.x() - (double)this.x());
		double second = ((double)p.y() - (double)this.y());
		double firstSquared = Math.pow(first, 2);//first * first;
		double secondSquared = Math.pow(second, 2);//second * second;
		double sum = firstSquared + secondSquared;
		double answer = Math.sqrt(sum);
		return answer;
	}
	
	public static void main(String[] args){
		//Case 1
		System.out.println("\n/---CASE 1---/");
		Point a1 = new Point(10,10);//First pair
		Point a2 = new Point(4,2);//Second pair
		System.out.println("x1: " + a1.x());
		System.out.println("y1: " + a1.y());
		System.out.println("x2: " + a2.x());
		System.out.println("y2: " + a2.y());
		double slope1 = a1.slope(a2);
		double dist1 = a1.distance(a2);
		System.out.println("Slope: " + slope1);
		System.out.println("Distance: " + dist1);
		
		//Case 2
		System.out.println("\n/---CASE 2---/");
		Point b1 = new Point(2,10);//First pair
		Point b2 = new Point(-1,-2);//Second pair
		System.out.println("x1: " + b1.x());
		System.out.println("y1: " + b1.y());
		System.out.println("x2: " + b2.x());
		System.out.println("y2: " + b2.y());
		double slope2 = b1.slope(b2);
		double dist2 = b1.distance(b2);
		System.out.println("Slope: " + slope2);
		System.out.println("Distance: " + dist2);
		
		//Case 3
		System.out.println("\n/---CASE 3---/");
		Point c1 = new Point(3,3);//First pair
		Point c2 = new Point(0,6);//Second pair
		System.out.println("x1: " + c1.x());
		System.out.println("y1: " + c1.y());
		System.out.println("x2: " + c2.x());
		System.out.println("y2: " + c2.y());
		double slope3 = c1.slope(c2);
		double dist3 = c1.distance(c2);
		System.out.println("Slope: " + slope3);
		System.out.println("Distance: " + dist3);

		
	}//End of main
	
}//End of class
