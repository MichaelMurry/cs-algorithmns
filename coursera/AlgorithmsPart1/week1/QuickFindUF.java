/** 
 * The QuickFindUF class implements an application that
 * exercises Connected and Union method in a Dynamic
 * Connectivity problem using the Quick Find Union-Find
 * algorithm (also known as the "eager approach")
 */

public class QuickFindUF
{
	private int[] id;

	// set id of each object to itself
	public QuickFindUF(int N) {
		id = new int [N];
		for (int i = 0; i < N; i ++)
			id[i] = i;
	}

	// check if p and q are in the same connected component
	public boolean connected (int p, int q) {
		return id[p] == id[q];
	}
	
	// check all the entries with id[p] to id[q]
	public void union (int p, int q) {
		int pid = id[p];
		int qid = id[q];

		for (int i = 0; i < id.length; i++) 
			if (id[i] == pid) id[i] = qid;
	}

	// test connected and union method
	public static void main(String[] args) {

		QuickFindUF QFUF = new QuickFindUF(10);

		System.out.println(QFUF.connected(3,4)); // expect false
		QFUF.union(3,4);						 // now connect them both
		System.out.println(QFUF.connected(3,4)); // expect true

		
	}
}