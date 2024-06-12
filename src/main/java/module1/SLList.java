package module1;

public class SLList {
	class IntNode {
		public int item;
		public IntNode next;
		private IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	}
	
	public IntNode first;
	
	public SLList(int x) {
		first = new IntNode(x, null);
	}
	
	public void addFirst(int x) {
		first = new IntNode(x, first);
	}
	
	public int getFirst() {
		return first.item;
	}

//add last, traverse to the end and add something htere?
// count as we traverse the list
	public void addLast(int x) {
		IntNode p = first;
		while (p.next != null) {
			p = p.next;
		}
		
		p.next = new IntNode(x, null);
	}

	// returns size of hte list that starts at intnode p
	private static int size(IntNode p) {
		if (p.next == null) {
			return 1;
		}
		return 1 + size(p.next);
	}
	
	public int size() {
		return size(first);
	}

        public static void main(String[] args) {
		SLList L = new SLList(15);
		L.addFirst(10);
		L.addFirst(5);
		L.addLast(20);
		System.out.println(L.getFirst());
		System.out.println(L.size());
		
	 }

}
