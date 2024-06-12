package module1;

public class TouristList {

    static class TouristNode {
        public String touristName;
        public int touristPassportNumber;
        public String touristDestination;
        public TouristNode next;

        private TouristNode(String name, int number, String destination, TouristNode node) {
            touristName = name;
            touristPassportNumber = number;
            touristDestination = destination;
            next = node;
        }
    }

    protected TouristNode first;
    protected int listSize;

    public TouristList() {
        first = null;
        listSize = 0;
    }

    public String getFirst() {
        if (first == null) {
            throw new IllegalStateException("Empty list");
        }
        return first.touristName;
    }

    public int getSize() {
        return listSize;
    }

    public void addFirst(String name, int number, String destination) {
        first = new TouristNode(name, number, destination, first);
        listSize++;
    }

    public String findNode(String name) {
        if (first == null) {
            throw new IllegalStateException("Empty list");
        }
        return findNode(first, name);
    }

    private String findNode(TouristNode p, String name) {
        if (p.touristName.equals(name) ) {
            return p.touristDestination;
        }
        return p.next == null ? "Person not found" : findNode(p.next, name);
    }

    public static void main(String[] args) {
        TouristList touristList = new TouristList();
        touristList.addFirst("Waldo", 12345, "Prague");
        touristList.addFirst("Baldo", 124, "Diego");
        touristList.addFirst("Crawldo", 4213, "Carmen");
        touristList.addFirst("Wooo", 5, "Slow");
        touristList.addFirst("Another", 3, "Down");

        System.out.println("Find tourist. Expected Prague, got " + touristList.findNode("Waldo"));
        System.out.println("Find tourist. Expected Carmen, got " + touristList.findNode("Crawldo"));
        System.out.println("Find tourist. Expected Down, got " + touristList.findNode("Another"));
        System.out.println("Find non existent tourist. Expected 'Person not found', got '"  + touristList.findNode("Not there") + "'");
    }
}
