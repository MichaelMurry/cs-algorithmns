
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.Arrays;

public class Percolation {
	
	private WeightedQuickUnionUF sites;
	private int[][] grid;
	private int countOpenSites;
	private int gsz;

	// create n-by-n grid, with all sites blocked
	public Percolation(int n) {

		// check if n is negative or zero
		if (n <= 0) {
			throw new java.lang.IndexOutOfBoundsException("n is less than or equal to zero");
		}

		// instantiate connectivity model data structure
		sites = new WeightedQuickUnionUF(n*n);

		// instantiate percolation model data structure
		grid = new int[n][n];

		// instantiate open site counter
		countOpenSites = 0;

		// instantiate grid size variable
		gsz = n;

	}

	// open site (row, col) if it is not open already
	public void open(int row, int col) { 

		// check if row is outside prescribed range 
		if ( (row < 1 || row > gsz) ) {
			throw new java.lang.IndexOutOfBoundsException("row out of bounds");
		}

		// check if col is outside prescribed range 
		if ( (col < 1 || col > gsz) ) {
			throw new java.lang.IndexOutOfBoundsException("col is out of bounds");
		}

		int j_row = row - 1; 
		int j_col = col - 1; 

		// update grid model if it is not open already
		if (isOpen(row, col)) return;
		grid[j_row][j_col] = 1;
		countOpenSites += 1;

		// calculate newly opened site index
		int index0 = (j_row)*gsz + j_col;

		// check if we're on the right edge of grid
		if ((col + 1) <= gsz) {
			// check if right neighbor site is open, if so, connect
			if (isOpen(row, col + 1)) {
				int index1 = j_row * gsz + j_col + 1; 

		 		sites.union(index0, index1);
				System.out.println("right");
			}
		}

		// check if we're on the left edge of grid
		if ((col - 1) > 0) {
			// check if left neighbor site is open, if so, connect
			if (isOpen(row, col - 1)) {
				int index1 = j_row * gsz + j_col - 1; 

		 		sites.union(index0, index1);
				System.out.println("left");
			}
		}

		// check if we're on the top edge of grid
		if ((row - 1) > 0) {
			// check if top neighbor site is open, if so, connect
			if (isOpen(row - 1, col)) {
				int index1 = (j_row - 1) * gsz + j_col; 

		 		sites.union(index0, index1);
				System.out.println("top");
			}
		}

		// check if we're on the bottom edge of grid
		if ((row + 1) <= gsz) {
			// check if bottom neighbor site is open, if so, connect
			if (isOpen(row + 1, col)) {
				int index1 = (j_row + 1) * gsz + j_col; 

		 		sites.union(index0, index1);
				System.out.println("bottom");
			}
		}
	}
	
	// is site (row, col) open?
	public boolean isOpen(int row, int col)	{
		// check if row and col are outside prescribed range 
		if ( (row < 1 || row > gsz) ) {
			throw new java.lang.IndexOutOfBoundsException("row val out of bounds");
		}

		// check if col is outside prescribed range 
		if ( (col < 1 || col > gsz) ) {
			throw new java.lang.IndexOutOfBoundsException("col val out of bounds");
		}

		int j_row = row - 1; 
		int j_col = col - 1; 

		return grid[j_row][j_col] == 1;
	}		

	// print out Grid
	public void printGrid() {
		for (int[] row : grid) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	// is site (row, col) full?
	public boolean isFull(int row, int col)	{

		// check if row and col are outside prescribed range 
		if ( (row < 1 || row > gsz) ) {
			throw new java.lang.IndexOutOfBoundsException("row val out of bounds");	
		}

		// check if col is outside prescribed range 
		if ( (col < 1 || col > gsz) ) {
			throw new java.lang.IndexOutOfBoundsException("col val out of bounds");
		}

		// check if the site is even open, if not, return
		if (!isOpen(row, col)) {
			System.out.println("not an open site");
			return false;
		}

		int j_row = row - 1; 
		int j_col = col - 1; 

		// calculate site index
		int site_index = (j_row)*gsz + j_col;

		// loop through first row of grid
		for (int i = 0; i < gsz; i++) {
			if (sites.connected(i, site_index)) {
				System.out.println("true");
				return true;
			}
		}
		
		System.out.println("false");
		return false;

	}	
	
	// number of open sites
	public int numberOfOpenSites() {
		System.out.println("number of sites: " + countOpenSites);
		return countOpenSites; 
	}			 
	
	// does the system percolate?
	public boolean percolates()	{ 

		// instantiate virtual connectivity model data structure
		v_sites = new WeightedQuickUnionUF(2);

		v_sites.union(


	}					

	// test client (optional)
	public static void main(String[] args) { 
		Percolation tst = new Percolation(3);

		tst.open(2,1);
		tst.open(1,3);
		tst.open(2,2);
		tst.open(2,3);
		// tst.open(2,3);
		// tst.open(1,3);
		// tst.isFull(2,3);
		tst.isFull(1,3);
		tst.isFull(2,2);
		tst.numberOfOpenSites();



		tst.printGrid();
		// tst.open(0,);
		// tst.isOpen(0,1);
		// tst.numberOfOpenSites();

		// var.yo();

	}		
		
}