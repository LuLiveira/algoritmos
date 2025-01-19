package main.java.com.lucas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Application {

    List<Integer> numeros = IntStream.rangeClosed(1, 100)
            .boxed()
            .toList();
    List<String> nomes = List.of(
            "Ana",        // A
            "Bruno",      // B
            "Carlos",     // C
            "Daniela",    // D
            "Eduardo",    // E
            "Fernanda",   // F
            "Gabriel",    // G
            "Helena",     // H
            "Isabela",    // I
            "João",       // J
            "Karla",      // K
            "Lucas",      // L
            "Mariana",    // M
            "Natalia",    // N
            "Otávio",     // O
            "Paula",      // P
            "Quirino",    // Q
            "Rafael",     // R
            "Sofia",      // S
            "Tiago",      // T
            "Úrsula",     // U
            "Victor",     // V
            "William",    // W
            "Xavier",     // X
            "Yasmin",     // Y
            "Zara"        // Z
    );

    public void main() {
        System.out.println("Hello, Algoritmos");
//
//        linearSearch();
//
//        binarySearch();
//
//        vacation();
//
//        orderBySmallerToBigger();
//
//        exampleReverse(1000);

//        System.out.println(fatorialReverse(5));
//        System.out.println(reverseSum(0, List.of(2, 4, 6)));
//        ArrayList<Integer> objects = new ArrayList<>();
//        objects.add(999);
//        objects.add(1);
//        objects.add(99);
//        objects.add(1);
//        System.out.println(reverseCountElements(objects));
//        System.out.println(reverseCountElements(0, 0, List.of(2, 4, 6).size()));

//        System.out.println(reverseMaxValue(List.of(9, 4, 6)));
//        System.out.println(reverseMaxValue(0, 0, objects));
//        System.out.println(reverseMaxValue(objects));
    }


    /**
     * Função criada com apoio do livro
     * @param integers
     * @return
     */
    private int reverseMaxValue(List<Integer> integers) {
        if(integers.size() == 2){
            return integers.get(0) > integers.get(1) ? integers.get(0) : integers.get(1);
        } else {
            int maxValue = reverseMaxValue(integers.subList(1, integers.size()));
            return integers.getFirst() > maxValue ? integers.getFirst() : maxValue;
        }
    }

    /**
     * Minha função recursiva para retornar o maior valor
     * @param actualValue
     * @param index
     * @param integers
     * @return
     */
    private int reverseMaxValue(int actualValue, int index, List<Integer> integers) {
        if (index >= integers.size() - 1) {
            return actualValue;
        }

        int prevValue = integers.get(index);

        if (prevValue > actualValue) {
            actualValue = prevValue;
        }

        return reverseMaxValue(actualValue, index + 1, integers);
    }

    /**
     * Função criada com apoio do livro
     * @param integers
     * @return
     */
    private int reverseCountElements(List<Integer> integers) {
        if (integers.isEmpty()) return 0;
        integers.removeFirst();
        return 1 + reverseCountElements(integers);
    }

    /**
     * Minha função recursiva para contar o numero de elementos
     * @param totalItems
     * @param start
     * @param end
     * @return
     */
    private int reverseCountElements(int totalItems, int start, int end) {
        if (start >= end) return totalItems;
        return reverseCountElements(totalItems + 1, start + 1, end);
    }

    /**
     * Minha função recursiva para somar os itens da lista
     * TODO criar uma versão melhorada da função que não receba posição
     * @param posicao
     * @param nums
     * @return
     */
    private int reverseSum(int posicao, List<Integer> nums) {
        if (posicao >= nums.size())
            return 0;
        return nums.get(posicao) + reverseSum(posicao + 1, nums);
    }

    private int fatorialReverse(int fatorial) {
        if (fatorial <= 1) return 1;
        return fatorial * fatorialReverse(fatorial - 1);
        //forma: 5! = 5 * 4 * 3 * 2 * 1.
    }

    private void exampleReverse(int num) {
        System.out.println(num);
        if (num <= 1) return; //Caso base
        exampleReverse(num - 1); //Caso recursivo
    }


    /**
     * O(n*2)
     */
    private void orderBySmallerToBigger() {
        //SETUP
        Random random = new Random();
        var randomList = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            randomList.add(Math.abs(random.nextInt()));
        }
        // FIM SETUP


        var sortList = new ArrayList<Integer>();

        while (!randomList.isEmpty()) {
            var smallerValue = randomList.getFirst();
            var smallerIndex = 0;

            for (int i = 0; i < randomList.size(); i++) {

                if (randomList.get(i) < smallerValue) {
                    smallerValue = randomList.get(i);
                    smallerIndex = i;
                }
            }
            sortList.add(smallerValue);
            randomList.remove(smallerIndex);
        }

        System.out.println(STR."My sortList \{sortList}");
    }

    private void vacation() {
        var periodos = new int[]{6, 10, 14};
        var possivelVacation = false;

        for (int periodo : periodos) {

            if (periodo < 5) {
                possivelVacation = false;
                break;
            }

            if (periodo >= 14) {
                possivelVacation = true;
            }
        }

        System.out.println(STR."Is valid vacation? \{possivelVacation}");
    }

    /**
     * Busca linear - O(n)
     */
    private void linearSearch() {
        /**
         * Embora System.out.println(n) seja O(1), o for vai ser O(n) e devemos considerar isso na complexidade final.
         */
        nomes.forEach(System.out::println);
    }

    /**
     * Busca binária - O(log n)
     */
    public void binarySearch() {
        var target = 7;
        var posicao = 0;
        var posicaoBaixa = 0;
        var posicaoAlta = numeros.size() - 1;

        while (posicaoBaixa <= posicaoAlta) {
            var meio = (posicaoBaixa + posicaoAlta) / 2;

            var possivelTarget = numeros.get(meio);

            if (possivelTarget == target) {
                posicao = meio;
                break;
            }

            if (target > possivelTarget) {
                posicaoBaixa = meio + 1;
            } else {
                posicaoAlta = meio - 1;
            }

//        if (target < possivelTarget) {
//            posicaoAlta = meio - 1;
//        }
        }
        System.out.println(STR."A posicao do numero \{target} é: \{posicao}");


        var nomeTarget = "Zara";
        var posicaoDoNome = 0;

        var inicio = 0;
        var fim = nomes.size() - 1;

        while (inicio <= fim) {

            var meio = inicio + fim / 2;

            var nome = nomes.get(meio);

            if (nomeTarget.equals(nome)) {
                posicaoDoNome = meio;
                break;
            }

            if (nomeTarget.compareTo(nome) > 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        System.out.println(STR."A posição do nome \{nomeTarget} é: \{posicaoDoNome}");
    }
}