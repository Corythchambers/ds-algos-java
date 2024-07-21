package module6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class AdjacencyMatrix {

    public static void main(String[] args) {
        // graph #1 even
        Item friend0 = new Item("0");
        Item friend1 = new Item("1");
        Item friend2 = new Item("2");
        Item friend3 = new Item("3");
        graph twitter = new graph();
        twitter.add_vertex(friend0);
        twitter.add_vertex(friend1);
        twitter.add_vertex(friend2);
        twitter.add_vertex(friend3);
        twitter.add_edge(0, 1);
        twitter.add_edge(1, 3);
        twitter.add_edge(3, 2);
        twitter.add_edge(2, 0);
        System.out.println(twitter.areAllEven());

        // graph #2 uneven
        Item comm0 = new Item("0");
        Item comm1 = new Item("1");
        Item comm2 = new Item("2");
        Item comm3 = new Item("3");
        graph commNetwork = new graph();
        commNetwork.add_vertex(comm0);
        commNetwork.add_vertex(comm1);
        commNetwork.add_vertex(comm2);
        commNetwork.add_vertex(comm3);
        commNetwork.add_edge(0, 1);
        commNetwork.add_edge(1, 3);
        commNetwork.add_edge(2, 0);
        commNetwork.add_edge(2, 1);
        System.out.println(commNetwork.areAllEven());
    }
}
class Item2 {
    public String name;
    public Item2(String inputName) {
        this.name = inputName;
    }
    @Override
    public String toString() {
        return name;
    }
}

class graph2 {
    int MAXIMUM = 20;
    boolean[][] edges = new boolean[MAXIMUM][MAXIMUM];
    Item[] labels = new Item[MAXIMUM];
    int many_vertices;

    public void add_vertex(Item label) {
        int new_vertex_number;
        int other_number;

        new_vertex_number = many_vertices;
        many_vertices++;
        for (other_number = 0; other_number < many_vertices; ++other_number) {
            edges[other_number][new_vertex_number] = false;
            edges[new_vertex_number][other_number] = false;
        }
        labels[new_vertex_number] = label;
    }

    public void add_edge(int source, int target) {
        edges[source][target] = true;
        edges[target][source] = true;
    }

    public void remove_edge(int source, int target) {
        edges[source][target] = false;
        edges[target][source] = false;
    }

    public int size() {
        return many_vertices;
    }

    boolean is_edge(int source, int target) {
        return edges[source][target];
    }

    public HashSet<Integer> neighbors(int vertex) {
        HashSet<Integer> answer = new HashSet<>();

        for (int i = 0; i < size(); ++i) {
            if (edges[vertex][i]) {
                answer.add(i);
            }
        }
        return answer;
    }

    public boolean areAllEven() {
        for (int i = 0; i < labels.length; i++) {
            if (neighbors(i).size() % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public Item get_label(int vertex) {
        return labels[vertex];
    }

    // breadth first
    public void breadth_first_list(graph g, int start) {
        boolean[] marked = new boolean[g.size()];
        Set<Integer> connections;
        Queue<Integer> vertex_queue = new LinkedList();

        marked[start] = true;

        vertex_queue.add(start);
        do {
            connections = g.neighbors(vertex_queue.peek());
            vertex_queue.remove();
            // Mark and process the unmarked neighbors
            // and place them in teh queue
            for (Integer x : connections) {
                if (!marked[x]) {
                    marked[x] = true;
                    vertex_queue.add(x);
                }
            }
        } while (!vertex_queue.isEmpty());
    }


    // Depth first traversal
    void depth_first_list(graph g, int start) {
        boolean[] marked = new boolean[g.size()];
        rec_dfs_list(start, g, marked);
    }

    public void rec_dfs_list(int v, graph g, boolean[] marked) {
        Set<Integer> connections = g.neighbors(v);

        marked[v] = true;
        System.out.println(g.get_label(v)); // do work ?
        // Travers all the neighbors looking for unmarked vertices
        for (Integer x : connections) {
            if (!marked[x]) {
                rec_dfs_list(x, g, marked);
            } else {
                System.out.println("Cycle found");
            }
        }
    }
}