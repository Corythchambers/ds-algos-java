package module1;

public class FootHill {
  public static void main(String[] args) {
    StackNode node1 = new StackNode(), node2 = new StackNode();
    
    // one way to use stack nodes
    node1.next = node2;

    // a more common way to use stack nodes

    node2.next = new StackNode();

    for (StackNode p = node1; p != null; p = p.next) {
      p.show();
      System.out.println();
    }
  }
}

class StackNode {
  public StackNode next;
  public StackNode() {
    next = null;
  }
  public void show() {
    System.out.println("(generic node) ");
  }
}

