import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private LineSegment[] ls;

	// finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {

    	int n = points.length;

   	    // check that input argument isn't null
        if (points == null) throw new java.lang.NullPointerException("Argument can't be null!");

   		// check that points are unique and isn't null
        for (int i = 0; i < n; i++) {
            if (points[i] == null) throw new java.lang.NullPointerException("Input array can't contain null points!");
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) 
                	throw new java.lang.IllegalArgumentException("Input array can't have repeated points!");
            }
        }

        Point[] ps = points.clone();
        Arrays.sort(ps);
        List<LineSegment> list = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            Point[] p = ps.clone();
            Arrays.sort(p, p[i].slopeOrder());
            int j = 1;
            
            while (j < n - 2) {
                int k = j;
                double s1 = p[0].slopeTo(p[k++]);
                double s2;
                
                do {
                    if (k == n) {
                        k++;
                        break;
                    }
                    s2 = p[0].slopeTo(p[k++]);
                
                } while (s1 == s2);
                if (k - j < 4) {
                    j++;
                    continue;
                }
                
                int len = k-- - j;
                Point[] line = new Point[len];
                line[0] = p[0];

                for (int l = 1; l < len; l++) {
                    line[l] = p[j + l - 1];
                }
                
                Arrays.sort(line);
                // remove duplicate
                if (line[0] == p[0]) {
                    list.add(new LineSegment(line[0], line[len - 1]));
                }
                j = k;
            }
        }
        // transform to array
        ls = list.toArray(new LineSegment[list.size()]);
    }

    // the number of line segments
    public int numberOfSegments() {
	    return ls.length;  
    }

    // the line segments
    public LineSegment[] segments() {
        return ls.clone();
    }

    // unit testing
    public static void main(String[] args) {

        Point[] points = new Point[9];
        points[3] = new Point(0, 0);
        points[2] = new Point(1, 1);
        points[1] = new Point(2, 2);
        points[0] = new Point(3, 3);
        points[4] = new Point(4, 4);

        points[5] = new Point(2, 3);
        points[6] = new Point(3, 4);
        points[7] = new Point(4, 5);
        points[8] = new Point(5, 4);

        FastCollinearPoints pts = new FastCollinearPoints(points);
  		System.out.println(pts.segments());
  		System.out.println(pts.numberOfSegments());
    }               
}