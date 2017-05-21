import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private LineSegment[] segments;

	// finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {

   	    // check that input argument isn't null
        if (points == null) throw new java.lang.NullPointerException("Argument can't be null!");

   		// check that points are unique and isn't null
        for (int i = 0; i<points.length-1; i++) {
            if (points[i] == null) throw new java.lang.NullPointerException("Input array can't be null!");
            for (int j = i + 1; j<points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) throw new java.lang.IllegalArgumentException("Input array can't have repeated points!");
            }
        }

        ArrayList<LineSegment> foundSegments = new ArrayList<>();

        // brute force find collinear points
        for (int p = 0; p<points.length; p++) {
            for (int q = 0; q<points.length; q++) {
                for (int r = 0; r<points.length; r++) {
                    for (int s = 0; s<points.length; s++) { 
                        Point[] pt = new Point[4];
                        pt[0] = points[p];
                        pt[1] = points[q];
                        pt[2] = points[r];
                        pt[3] = points[s];

                        double m1 = pt[0].slopeTo(pt[1]);
                        double m2 = pt[0].slopeTo(pt[2]);
                        if(m1 != m2) continue;
                        double m3 = pt[0].slopeTo(pt[3]);

                        if (m1 == m3) {
                            Arrays.sort(pt);
                            foundSegments.add(new LineSegment(pt[0], pt[3]));
                        }
                    }
                }
            }
        }
        segments = foundSegments.toArray(new LineSegment[foundSegments.size()]);
    }   

    // the number of line segments
    public int numberOfSegments() {
        return segments.length;
    }    

    // the line segments
    public LineSegment[] segments() {
        return Arrays.copyOf(segments, numberOfSegments());
    } 

    // unit testing
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

        BruteCollinearPoints pts = new BruteCollinearPoints(points);
  		System.out.println(pts.segments());
  		System.out.println(pts.numberOfSegments());
    }
}   