package module2;

import module1.PenguinList;

public class SLList<LochNess> {
	class StuffNode {
		public LochNess item;
		public StuffNode next;
		private StuffNode(LochNess i, StuffNode n) {
			item = i;
			next = n;
		}
	}
	
	public StuffNode first;
	
	public SLList(LochNess x) {
		first = new StuffNode(x, null);
	}
	
	public void addFirst(LochNess x) {
		first = new StuffNode(x, first);
	}
	
	public LochNess getFirst() {
		return first.item;
	}

	public void addLast(LochNess x) {
		StuffNode p = first;
		while (p.next != null) {
			p = p.next;
		}
		
		p.next = new StuffNode(x, null);
	}

	private int recursiveSize(StuffNode p)
	{
		if(p.next == null)
		{
			return 1;
		}
		return 1+ recursiveSize(p.next);
	}
	public int size()
	{
		return recursiveSize(first);
	}


	public static void main(String[] args) {
		SLList<Integer> L = new SLList<>(15);
		L.addFirst(10);
		L.addFirst(5);
		L.addLast(20);
		System.out.println(L.getFirst());

		SLList<String> LString = new SLList<>("15");
		LString.addFirst("aaeg");
		LString.addFirst("5feaerwgaer");
		LString.addLast("YESSS");
		System.out.println(LString.getFirst());
	 }

}
