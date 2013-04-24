package assignment3;

import java.util.Arrays;

public class Fast {
	public static void main ( String[] args ) {
		
		In input = new In (args[0]);
		
		int numPoints = input.readInt();
		assert(numPoints > 1);
		int pointer = 0;
		
		Point[] ptArr = new Point[numPoints];
		
		while ( !input.isEmpty() ) {
			ptArr[pointer] = new Point(input.readInt(),input.readInt());
			
			ptArr[pointer++].draw();
		}
		Point origin = ptArr[0];
		double slope[] = new double[numPoints-1];
		
		for( int i = 1; i < numPoints; i++ ){
			slope[i-1] = origin.slopeTo(ptArr[i]);
		}
		Arrays.sort(slope);
		
		
	}
}
