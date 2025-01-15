import java.util.List;
import java.util.Map;
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

    linear_search();

    binary_search();

    vacation();

    find_phone_number();
    find_phone_number2();
}

/**
 * O(1)
 */
private void find_phone_number() {
    var nome = "Lucas";
    var phone_map = Map.of("Lucas", 123, "Joao", 321, "Maria", 456);

    var phone_number = phone_map.getOrDefault(nome, 0);

    System.out.println(STR."O telefone de \{nome} é: \{phone_number}");
}

/**
 * O(n)
 */
private void find_phone_number2() {
    var nome = "Lucas";
    var phone_number = 0;
    var phone_list = List.of(new Person("Lucas", 123), new Person("Joao", 321), new Person("Maria", 456));

    /**
     * O(n)
     */
    for (Person person : phone_list) {
        if (person.nome().equals(nome)) {
            phone_number = person.telefone();
            break;
        }
    }

    System.out.println(STR."O telefone de \{nome} é: \{phone_number}");

    /**
     * O(n)
     */
    for (Person person : phone_list) {
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
private void linear_search() {
    /**
     * Embora System.out.println(n) seja O(1), o for vai ser O(n) e devemos considerar isso na complexidade final.
     */
    nomes.forEach(System.out::println);
}

/**
 * Busca binária - O(log n)
 */
public void binary_search() {
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