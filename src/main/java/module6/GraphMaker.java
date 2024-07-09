package module6;

import javax.print.attribute.IntegerSyntax;
import java.util.HashSet;

public class GraphMaker {

    public static void main(String[] args) {
        Item friend0 = new Item("Dan");
        Item friend1 = new Item("Joe");
        Item friend2 = new Item("Sue");
        Item friend3 = new Item("Kim");
        graph twitter = new graph();
        twitter.add_vertex(friend0);
        twitter.add_vertex(friend1);
        twitter.add_vertex(friend2);
        twitter.add_vertex(friend3);
        twitter.add_edge(0, 1);
        twitter.add_edge(1, 3);
        twitter.add_edge(1, 0);
        twitter.add_edge(2, 1);
        twitter.add_edge(3, 1);
        twitter.add_edge(3, 2);
        HashSet<Integer> followers = twitter.neighbors(1);
        System.out.println("Joe's followers:");
        for (Integer vertex : followers) {
            System.out.println(twitter.get_label(vertex));
        }
    }


}
class Item {
    public String name;
    public Item(String inputName) {
        this.name = inputName;
    }
    @Override
    public String toString() {
        return name;
    }
}

class graph {
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
    }

    public void remove_edge(int source, int target) {
        edges[source][target] = false;
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

    public Item get_label(int vertex) {
        return labels[vertex];
    }
}