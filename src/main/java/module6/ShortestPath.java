package module6;

import java.util.*;

public class ShortestPath {
    private Set nodes = new HashSet<>();
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set getNodes() {
        return nodes;
    }

    public void setNodes(Set nodes) {
        this.nodes = nodes;
    }

    class Node {
        private String name;
        private List shortestPath = new LinkedList<>();
        private Integer distance = Integer.MAX_VALUE;
        Map adjacentNodes = new HashMap<>();

        public void addDestination(Node destination, int distance) {
            adjacentNodes.put(destination, distance);
        }

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List getShortestPath() {
            return shortestPath;
        }

        public void setShortestPath(List shortestPath) {
            this.shortestPath = shortestPath;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public Map getAdjacentNodes() {
            return adjacentNodes;
        }

        public void setAdjacentNodes(Map adjacentNodes) {
            this.adjacentNodes = adjacentNodes;
        }

//        public static ShortestPath calculateShortestPathFromSource(ShortestPath graph, Node source) {
//            source.setDistance(0);
//
//            Set settledNodes = new HashSet<>();
//            Set unsettledNodes = new HashSet<>();
//
//            unsettledNodes.add(source);
//
//            while (unsettledNodes.size() != 0) {
//                Node currentNode = getLowestDistanceNode(unsettledNodes);
//                unsettledNodes.remove(currentNode);
//                for (Map.Entry<Node, Integer> adjacencyPair:
//                        currentNode.getAdjacentNodes().entrySet()) {
//                    Node adjacentNode = adjacencyPair.getKey();
//                    Integer edgeWeight = adjacencyPair.getValue();
//                    if (!settledNodes.contains(adjacentNode)) {
//                        calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
//                        unsettledNodes.add(adjacentNode);
//                    }
//                }
//            }
//        }


    }
}


