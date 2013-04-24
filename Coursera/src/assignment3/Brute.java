package assignment3;

public class Brute {
	public static void main ( String[] args ) {
		
		In input = new In (args[0]);
		
		int numPoints = input.readInt();
		int pointer = 0;
		
		Point[] ptArr = new Point[numPoints];
		while ( !input.isEmpty() ) {
			ptArr[pointer] = new Point(input.readInt(),input.readInt());
			
			ptArr[pointer++].draw();
		}
		
		
		
	}
}
