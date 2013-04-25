package assignment3;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

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
		int slope;
		Hashtable<Integer, ArrayList<Point>> table = new Hashtable<Integer, ArrayList<Point>>();
		
		for( int i = 1; i < numPoints; i++ ){
			slope = (int) (100.0 * origin.slopeTo(ptArr[i]));
			
			if ( table.containsKey(slope) ) {
				table.get(slope).add(ptArr[i]);
			}
			else {
				table.put(slope, new ArrayList<Point>());
				table.get(slope).add(ptArr[i]);
			}
		}
		
		Enumeration<ArrayList<Point>> enumeration = table.elements();
		
		while( enumeration.hasMoreElements() ) {
			if ( enumeration.nextElement().size() >= 4 ){
				
			}
			
		}
		
	}
}
