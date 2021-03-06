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
			ptArr[pointer++] = new Point(input.readInt(),input.readInt());
			
			//ptArr[pointer++].draw();
		}
		Fast findCollinearPts = new Fast ();
		while(ptArr[1] != null ) {
			
			ptArr = findCollinearPts.fast(ptArr,ptArr.length,pointer);
		}
	}
	
	public Point[] fast (Point[] ptArr, int numPoints, int pointer){
		Point origin = ptArr[0];
		ptArr[0] = null;
		int slope;
		Hashtable<Integer, ArrayList<Point>> table = new Hashtable<Integer, ArrayList<Point>>();
		
		for( int i = 1; i < numPoints; i++ ){
			if(ptArr[i] == null) continue;
			slope = (int) (100.0 * origin.slopeTo(ptArr[i]));
			
			if ( table.containsKey(slope) ) {
				table.get(slope).add(ptArr[i]);
			}
			else {
				table.put(slope, new ArrayList<Point>());
				table.get(slope).add(origin);
				table.get(slope).add(ptArr[i]);
			}
			ptArr[i] = null;
		}
		
		Enumeration<ArrayList<Point>> enumeration = table.elements();
		ArrayList<Point> alPoint;
		pointer = 0;
		numPoints = 0;
		while( enumeration.hasMoreElements() ) {
			alPoint = enumeration.nextElement();
			if ( alPoint.size() >= 4 ){
				for(int i = 0; i < alPoint.size(); i++) {
					
					//origin.drawTo(alPoint.get(i));
					StdOut.print(alPoint.get(i));
				}				
				StdOut.print("\n");
			}
			else {
				for(int i = 1; i < alPoint.size(); i++) {
					ptArr[pointer++]= alPoint.get(i);
					numPoints++;
				}
			}			
		}
		
		return ptArr;
	}

}
