package main.java.com.lucas.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraExample3 {

    public static void main(String[] args) {
        new DijkstraExample3();
    }

    Map<String, Map<String, Integer>> graph = new HashMap<>();
    Map<String, String> parents = new HashMap<>();
    Map<String, Integer> custos = new HashMap<>();
    List<String> processNodes = new ArrayList<>();


    public DijkstraExample3() {

        graph.put("Inicio", Map.of("A", 10));
        graph.put("A", Map.of("B", 20));
        graph.put("B", Map.of("Fim", 30, "C", 1));
        graph.put("C", Map.of( "A", 1));

        parents.put("A", "Inicio");
        parents.put("Fim", null);

        custos.put("A", 10);
        custos.put("B", Integer.MAX_VALUE);
        custos.put("C", Integer.MAX_VALUE);
        custos.put("Fim", Integer.MAX_VALUE);

        String lowCost = buscaNodeMenorCusto();

        while (!lowCost.equals("Fim")) {
            var custoNode = custos.get(lowCost);
            Map<String, Integer> edgeNode = graph.get(lowCost);

            for (var edge : edgeNode.keySet()) {
                int novoCusto = custoNode + edgeNode.get(edge);

                if (custos.get(edge) > novoCusto) {
                    custos.put(edge, novoCusto);
                }
            }
            processNodes.add(lowCost);
            lowCost = buscaNodeMenorCusto();
        }

        System.out.println(custos);
    }

    private String buscaNodeMenorCusto() {
        Integer custo = Integer.MAX_VALUE;
        String node = null;

        for (String key: custos.keySet()) {
            var nodeCusto = custos.get(key);

            if(nodeCusto < custo && !processNodes.contains(key)) {
                custo = nodeCusto;
                node = key;
            }
        }
        return node;
    }
}