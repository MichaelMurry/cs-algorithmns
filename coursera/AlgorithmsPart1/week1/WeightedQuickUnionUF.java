/** 
 * The QuickUnionUF class implements an application that
 * exercises Connected and Union method in a Dynamic
 * Connectivity problem using the Quick Union Union-Find
 * algorithm (also known as the "lazy approach")
 */

public class WeightedQuickUnionUF
{
	private int[] id;
	private int[] sz;

	// set id of each object to itself
	public WeightedQuickUnionUF(int N) {
		id = new int [N];
		sz = new int [N];

		for (int i = 0; i < N; i ++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	// chase parent points until reach root
	public int root(int i) {
		while (i != id[i]) i = id[i];
		return i;
	}

	// check if p and q are in the same connected component
	public boolean connected (int p, int q) {
		return root(p) == root(q);
	}

	// link root of smaller tree to root of larger tree
	public void union (int p, int q) {
		int i = root(p);
		int j = root(q);

		if (i == j) return;

		if (sz[i] < sz[j]) { 
			id[i] = j; 
			sz[j] += sz[i]; 
		}
		else { 
			id[j] = i; 
			sz[i] += sz[j]; 
		}
	}

	// test connected and union method
	public static void main(String[] args) {

		QuickUnionUF QUUF = new QuickUnionUF(10);

		System.out.println(QUUF.connected(3,4)); // expect false
		QUUF.union(3,4);						 // now connect them both
		System.out.println(QUUF.connected(3,4)); // expect true	
	}
}