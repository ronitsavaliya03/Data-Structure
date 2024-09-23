import java.util.*;
import java.util.Queue;
import java.util.LinkedList;


class Graph{
    public Map<Integer, List<Integer>> adjList;

    public Graph(){
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v){
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());

        adjList.get(u).add(v);
        // adjList.get(v).add(u);

    }

    public void dfs(int start){
        Set<Integer> visited=new HashSet<>();
        dfsHelper(start, visited);
    }

    public void dfsHelper(int vertex, Set<Integer> visited){
        visited.add(vertex);
        System.out.print(vertex + " ");

        for(int neighbor : adjList.getOrDefault(vertex, new ArrayList<>())){
            if(!visited.contains(neighbor)){
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void bfs(int start){
        HashSet<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            if (adjList.containsKey(node)) {
                for (int adjNode : adjList.get(node)) {
                    if (!visited.contains(adjNode)) {
                        visited.add(adjNode);
                        queue.add(adjNode);
                    }
                }
            }
        }
    }
}

public class CreateGraph {
    public static void main(String[] args) {
        Graph g= new Graph();

        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 3);
        g.addEdge(5, 3);
        g.addEdge(4, 3);
        g.addEdge(6, 1);


        System.out.print("DFS: ");
        g.dfs(1);

        System.out.print("\nBFS: ");
        g.bfs(1);

    }
}
