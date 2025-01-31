package main.java.com.lucas.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraExample2 {

    private static final Map<String, Map<String, Integer>>  graph = new HashMap<>();
    private static final Map<String, String>  parents = new HashMap<>();
    private static final Map<String, Integer>  custo = new HashMap<>();
    private static final List<String> processNode = new ArrayList<>();

    static {
        graph.put("Inicio", Map.of("A", 5, "B", 2));
        graph.put("A", Map.of("D", 4, "C", 2));
        graph.put("B", Map.of("A", 8, "C", 7));
        graph.put("D", Map.of("Fim", 3, "C", 6));
        graph.put("C", Map.of("Fim", 1));
        graph.put("Fim", null);


        parents.put("A", "Inicio");
        parents.put("B", "Inicio");
        parents.put("Fim", null);

        custo.put("A", 5);
        custo.put("B", 2);
        custo.put("C", Integer.MAX_VALUE);
        custo.put("D", Integer.MAX_VALUE);
        custo.put("Fim", Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        example();
    }

    public static void example() {
        String lowCostNode = findLowCost();

        while (!lowCostNode.equals("Fim")) {
            Integer nodeCost = custo.get(lowCostNode);
            Map<String, Integer> neighbors = graph.get(lowCostNode);

            for (String neighbor : neighbors.keySet()) {
                var newCostNode = nodeCost + neighbors.get(neighbor);

                if (custo.get(neighbor) > newCostNode) {
                    custo.put(neighbor, newCostNode);
                    parents.put(neighbor, lowCostNode);
                }
            }
            processNode.add(lowCostNode);
            lowCostNode = findLowCost();
        }

        System.out.println("DijkstraGraph{" +
                ", custo=" + custo +
                ", parents=" + parents +
                '}');

    }

    private static String findLowCost() {

        var lowestCost = Integer.MAX_VALUE;
        var currentNode = "";

        for (String key : custo.keySet()) {
            Integer edgeCost = custo.get(key);

            if (edgeCost < lowestCost && !processNode.contains(key)) {
                lowestCost = edgeCost;
                currentNode = key;
            }
        }

        return currentNode;
    }

}
