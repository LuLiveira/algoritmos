import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

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

//    linearSearch();

//    binarySearch();

//    vacation();

//    findPhoneNumber();
//    findPhoneNumber2();

    orderBySmallerToBigger();

}

private void orderBySmallerToBigger() {
    //SETUP
    int maxValue = 1000; // Valor máximo permitido
    Random random = new Random();
    var randomList = new ArrayList<Integer>();
    for (int i = 0; i < 1000; i++) {
        randomList.add(random.nextInt(maxValue + 1)); // Gera números entre 0 e 1000
    }
    // FIM SETUP


    var sortList = new ArrayList<Integer>();
    var randomListSize = randomList.size();

    for (int i = 0; i < randomListSize; i++) {
        var smallerValue = randomList.get(0);
        var smallerIndex = 0;

        for (int x = 0; x < randomList.size(); x++) {

            if (randomList.get(x) < smallerValue) {
                smallerValue = randomList.get(x);
                smallerIndex = x;
            }
        }
        sortList.add(smallerValue);
        randomList.remove(smallerIndex);
    }

    System.out.println(STR."My sortList \{sortList}");
}

/**
 * O(1)
 */
private void findPhoneNumber() {
    var nome = "Lucas";
    var phoneMap = Map.of("Lucas", 123, "Joao", 321, "Maria", 456);

    var phoneNumber = phoneMap.getOrDefault(nome, 0);

    System.out.println(STR."O telefone de \{nome} é: \{phoneNumber}");
}

/**
 * O(n)
 */
private void findPhoneNumber2() {
    var nome = "Lucas";
    var phoneNumber = 0;
    var phoneList = List.of(new Person("Lucas", 123), new Person("Joao", 321), new Person("Maria", 456));

    /**
     * O(n)
     */
    for (Person person : phoneList) {
        if (person.nome().equals(nome)) {
            phoneNumber = person.telefone();
            break;
        }
    }

    System.out.println(STR."O telefone de \{nome} é: \{phoneNumber}");

    /**
     * O(n)
     */
    for (Person person : phoneList) {
        System.out.println(person.telefone());
    }
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