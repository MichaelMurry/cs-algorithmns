public class FastCollinearPoints {

	// finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {

   	    // check that input argument isn't null
        if (points == null) throw new java.lang.NullPointerException("Argument can't be null!");

   		// check that points are unique and isn't null
        for (int i = 0; i<points.length-1; i++) {
            if (points[i] == null) throw new java.lang.NullPointerException("Input array can't contain null points!");
            for (int j = i + 1; j<points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) throw new java.lang.IllegalArgumentException("Input array can't have repeated points!");
            }
        }

        for (int q = 0; q<points.length; q++) {
			for (int p = 1; p<points.length; p++){
				//calculate slope of p to all q
				//store value into array
				//sort array by slope value
				//find any 3 (or more) adj pts have equal slopes
			}
		//save segments
		}

    }    

    // the number of line segments
    public int numberOfSegments() {
	    return num;  
    }

    // the line segments
    public LineSegment[] segments() {
    	return null;
    }               
}