package main.java.com.lucas.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraExample4 {

    public static void main(String[] args) {
        new DijkstraExample4();
    }

    Map<String, Map<String, Integer>> graph = new HashMap<>();
    Map<String, String> parents = new HashMap<>();
    Map<String, Integer> custos = new HashMap<>();
    List<String> processNodes = new ArrayList<>();

    DijkstraExample4() {
        graph.put("Inicio", Map.of("A", 2, "B", 2));
        graph.put("A", Map.of("Fim", 2, "C", 2));
        graph.put("B", Map.of("A", 2));
        graph.put("C", Map.of("Fim", 2, "B", -1));

        parents.put("A", "Inicio");
        parents.put("B", "Inicio");
        parents.put("Fim", null);

        custos.put("A", 2);
        custos.put("B", 2);
        custos.put("C", Integer.MAX_VALUE);
        custos.put("Fim", Integer.MAX_VALUE);

        var node = buscaNodeComMenorCusto();

        while(node != "Fim") {
            var nodeCusto = custos.get(node);
            var parentsNode = graph.get(node);

            for(String edge: parentsNode.keySet()) {
                int novoCusto = nodeCusto + parentsNode.get(edge);
                if(custos.get(edge) > novoCusto) {
                    custos.put(edge, novoCusto);
                }
            }
            processNodes.add(node);
            node = buscaNodeComMenorCusto();
        }

        System.out.println(custos);

    }

    private String buscaNodeComMenorCusto() {
        String node = "";
        int custo = Integer.MAX_VALUE;

        for(String edge: custos.keySet()) {
            if (custos.get(edge) < custo && !processNodes.contains(edge)) {
                custo = custos.get(edge);
                node = edge;
            }
        }
        return node;
    }
}