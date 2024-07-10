package module6;

import java.util.HashSet;

public class AdjacencyList {
    // this is the edge
    class adjNode{
        int destination;
        adjNode next;

        public adjNode(int destination) {
            this.destination = destination;
            this.next = null;
        }
    }
    // vertex and a lsit of edges
    class adjList {
        adjNode head;
        String name;
        public adjList(String name) {
            this.name = name;
            head = null;
        }
    }
    // this is the actual graph an array of vertices
    class Graph {
        int V;
        adjList[] array;

        public Graph(int V) {
            this.V = V;
            array = new adjList[V];
        }

        public void addVertex(String name, int source) {
            array[source] = new adjList(name);
        }

        public void addEdge(int source, int destination) {
            adjNode adn = new adjNode(destination);
            if (array[source] != null) {
                // add this ndoe to the source adj list
                adn.next = array[source].head;
                array[source].head = adn;
            }
            // now create a reverse edge since its a undirected graph
            if(array[destination] != null) {
                adn = new adjNode(source);
                adn.next = array[destination].head;
                array[destination].head = adn;
            }
        }

        public HashSet<Integer> neighbors(int vertex) {
            HashSet<Integer> answer = new HashSet<>();
            adjNode ad = array[vertex].head;
            while (ad != null) {
                answer.add(ad.destination);
                ad = ad.next;
            }
            return answer;
        }
    }
}
