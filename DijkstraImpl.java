import org.w3c.dom.Node;

import java.util.*;

public class DijkstraImpl {

    private final int vertices;
    private final List<List<Node>> adjacencyList;

    public DijkstraImpl(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Node(destination, weight));
        adjacencyList.get(destination).add(new Node(source, weight));
    }

    static class Node {
        int vertex;
        int cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public void dijkstra(int start) {
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];
        PriorityQueue<Node> priorityQueue =
                new PriorityQueue<>(vertices, Comparator.comparingInt(node -> node.cost));

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        priorityQueue.add(new Node(start, 0));
        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            int currentVertex = currentNode.vertex;
            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;
            for (Node neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor.vertex]) {
                    int newDist = distances[currentVertex] + neighbor.cost;
                    if (newDist < distances[neighbor.vertex]) {
                        distances[neighbor.vertex] = newDist;
                        priorityQueue.add(new Node(neighbor.vertex, newDist));
                    }
                }
            }
        }

        for(int i = 0; i < distances.length; i++) {
            System.out.println("Distance from node " + start + " to node "
                    + i + " is " + distances[i]);
        }

    }

    public static void main(String[] args) {
        DijkstraImpl graph = new DijkstraImpl(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 1, 4);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 3, 9);
        graph.dijkstra(0);
    }


}
