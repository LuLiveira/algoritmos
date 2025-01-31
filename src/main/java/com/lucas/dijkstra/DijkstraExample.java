package main.java.com.lucas.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraExample {

    public static void main(String[] args) {
        DijkstraExample dijkstraExample = new DijkstraExample();
        dijkstraExample.example();
    }


    public void example() {
        var dijkstraGraph = new DijkstraGraph();

        String lowCost = findLowCost(dijkstraGraph.edgesCost, dijkstraGraph.edgesProcess);

        while (!lowCost.equals("Fim")) {
            Integer cost = dijkstraGraph.edgesCost.get(lowCost);
            Map<String, Integer> neighbors = dijkstraGraph.graph.get(lowCost);

            for (String neighbor : neighbors.keySet()) {
                var newCost = cost + neighbors.get(neighbor);

                if (dijkstraGraph.edgesCost.get(neighbor) > newCost) {
                    dijkstraGraph.edgesCost.put(neighbor, newCost);
                    dijkstraGraph.parents.put(neighbor, lowCost);
                }
            }
            dijkstraGraph.edgesProcess.add(lowCost);
            lowCost = findLowCost(dijkstraGraph.edgesCost, dijkstraGraph.edgesProcess);
        }

        System.out.println(dijkstraGraph);

    }

    private String findLowCost(Map<String, Integer> edgesCost, List<String> edgesProcess) {
        var cost = Integer.MAX_VALUE;
        String lowCostEdgeKey = null;
        for (String key : edgesCost.keySet()) {
            Integer edgeCost = edgesCost.get(key);

            if ( edgeCost < cost && !edgesProcess.contains(key)) {
                lowCostEdgeKey = key;
                cost = edgeCost;
            }
        }
        return lowCostEdgeKey;
    }


    private class DijkstraGraph {

        private Map<String, Map<String, Integer>> graph = new HashMap<>();
        private Map<String, Integer> edgesCost = new HashMap<>();
        private Map<String, String> parents = new HashMap<>();
        private List<String> edgesProcess = new ArrayList<>();

        public DijkstraGraph() {
            graph.put("Inicio", Map.of("A", 6, "B", 2));
            graph.put("A", Map.of("Fim", 1));
            graph.put("B", Map.of("A", 3, "Fim", 5));
            graph.put("Fim", null);

            edgesCost.put("A", 6);
            edgesCost.put("B", 2);
            edgesCost.put("Fim", Integer.MAX_VALUE);

            parents.put("A", "Inicio");
            parents.put("B", "Inicio");
            parents.put("Fim", null);


        }

        @Override
        public String toString() {
            return "DijkstraGraph{" +
                    "graph=" + graph +
                    ", edgesCost=" + edgesCost +
                    ", parents=" + parents +
                    ", edgesProcess=" + edgesProcess +
                    '}';
        }
    }
}
