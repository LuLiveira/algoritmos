package main.java.com.lucas.hashtable;

import java.util.*;


/**
 * @author Lucas Silva"
 * Busca em Profundidade/Largura - Depth First Serach (DFS) Algorithm
 */
public class HashTableExample {


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

        example(graph, name);
    }

    private static void example(Map<String, List<String>> graph, String name) {
        var list = new ArrayList<String>();
        var verifiedList = new ArrayList<String>();

        list.add(name);

        while (!list.isEmpty()) {
            String first = list.removeFirst();

            //TODO: alguma logica de verificação para encontrar um elemento X, por exemplo: Primeiro com a lestra A 'return'.
            if (verifiedList.contains(first)) {
                continue;
            }

            list.addAll(Optional.ofNullable(graph.get(first)).orElseGet(List::of));
            verifiedList.add(first);
        }
    }
}
