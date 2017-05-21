public class BruteCollinearPoints {
   	
    private int num = 0;
    private ArrayList<LineSegment> seg = new ArrayList<LineSegment>();

	// finds all line segments containing 4 points
   	public BruteCollinearPoints(Point[] points) {

   		// check that array isn't null
   		for (Point point : points) {
   			if (point == null) throw new java.lang.NullPointerException("Input array can't be null!");
   		}

   		// check that points are unique
   		for (int i = 0; i<points.length-1; i++) {
   			for (int j = i + 1; j<points.length; j++) {
   				if (points[i].compareTo(points[j]) == 0) throw new java.lang.IllegalArgumentException("Input array can't have repeated points!");
   			}
   		}

   		double m1, m2, m3; 

   		for (int p = 0; p<points.length; p++) {
   			for (int q = 0; q<points.length; q++) {
   				for (int r = 0; r<points.length; r++) {
   					for (int s = 0; s<points.length; s++) { 
   						m1 = points[p].slopeTo(points[q]);
   						m2 = points[p].slopeTo(points[r]);
   						m3 = points[p].slopeTo(points[s]);

   						if (m1 == m2 && m2 == m3) {
   							if (points[p].compareTo(points[q]) == -1 && points[q].compareTo(points[r]) == -1 && points[r].compareTo(points[s]) == -1) {
   					// 			System.out.println("p: " + points[p]);
					// 			System.out.println("q: " + points[q]);
   					// 			System.out.println("r: " + points[r]);
   					// 			System.out.println("s: " + points[s]);
   					// 			System.out.println();
   								seg[num] = new LineSegment(points[p], points[s]);
   								num++;
   							}  
   						}
   					}
   				}
   			}
   		}
   	}   

   	// the number of line segments
   	public int numberOfSegments() {
   		return num;
   	}    

    // the line segments
  	public LineSegment[] segments() {
  		return seg;
  	} 

  	public static void main(String[] args) {

       	Point[] points = new Point[8];
        points[3] = new Point(0,0);
        points[2] = new Point(1,1);
        points[1] = new Point(2,2);
        points[0] = new Point(3,3);

        points[4] = new Point(1,2);
        points[5] = new Point(2,3);
        points[6] = new Point(3,4);
        points[7] = new Point(0,1);

        // System.out.println(points[3]);

        // if (points[0].compareTo(points[3]) == 0) System.out.println("hi");
        // else System.out.println("nah");

  		BruteCollinearPoints pts = new BruteCollinearPoints(points);
  		// System.out.println(pts.segments());
  		// System.out.println(pts.numberOfSegments());
  	}


}