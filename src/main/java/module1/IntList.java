package module1;

public class IntList {
	public int first;
  
 	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}
	
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize++;
			p = p.rest;
		}
		return totalSize;
	}

	public int recursiveSize() {
		// base case
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.recursiveSize();
	}
		
  
  	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

		System.out.println(L.iterativeSize());
		System.out.println("Revursive: " + L.recursiveSize());	
	}
} 
