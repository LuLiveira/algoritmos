package main.java.com.lucas.hashtable;

import java.util.*;


/**
 * @author Lucas Silva"
 * Busca em Profundidade/Largura - Depth First Serach (DFS) Algorithm
 */
public class DepthFirstExample {


    public static void depthFirstSearch(String name) {
        var graph = new HashMap<String, List<String>>();
        graph.put("Voce", List.of("Alice", "Bob", "Claire"));
        graph.put("Bob", List.of("Anuj", "Peggy"));
        graph.put("Alice", List.of("Peggy"));
        graph.put("Claire", List.of("Thom", "Jonny"));
        graph.put("Anuj", null);
        graph.put("Peggy", null);
        graph.put("Thom", null);
        graph.put("Jonny", null);

        example(graph);
    }

    private static void example(Map<String, List<String>> graph) {

        var filaDeBusca = new ArrayList<>(graph.get("Voce"));
        var verificados = new ArrayList<>();

        while (!filaDeBusca.isEmpty()) {
            String first = filaDeBusca.removeFirst();

            if (verificados.contains(first)) {
                continue;
            }

            //TODO: alguma logica de verificação para encontrar um elemento X, por exemplo: Primeiro com a lestra A 'return'.
            if (first.startsWith("Jon")) {
                break;
            } else {
                verificados.add(first);
                filaDeBusca.addAll(Optional.ofNullable(graph.get(first)).orElseGet(List::of));
            }
        }
    }
}
