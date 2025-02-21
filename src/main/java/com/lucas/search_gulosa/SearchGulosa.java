package main.java.com.lucas.search_gulosa;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchGulosa {

    public static void main(String[] args) {

        Set<String> estadosAbranger = new HashSet<>(Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));

        Map<String, Set<String>> estacoes = Map.of("kum", Set.of("id", "nv", "ut"),
                "kdois", Set.of("wa", "id", "mt"),
                "ktres", Set.of("or", "nv", "ca"),
                "kquatro", Set.of("nv", "ut"),
                "kcinco", Set.of("ca", "az"));


        Set<String> estacoesFinal = new HashSet<>();

        while (!estadosAbranger.isEmpty()) {
            String melhorEstacao = null;
            Set<String> estadoCoberto = new HashSet<>();

            for (String estacao : estacoes.keySet()) {
                Set<String> estado = estacoes.get(estacao);

                Set<String> intersection = new HashSet<>(estadosAbranger);
                intersection.retainAll(estado);

                if (intersection.size() > estadoCoberto.size()) {
                    melhorEstacao = estacao;
                    estadoCoberto.addAll(intersection);


                }
            }
            estadosAbranger.removeAll(estadoCoberto);
            estacoesFinal.add(melhorEstacao);
        }
        System.out.println(estacoesFinal);
    }
}
