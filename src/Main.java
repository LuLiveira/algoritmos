import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public void main() {
    System.out.println("Hello, World!");

    binary_search();
}


// O(log n)
public void binary_search() {
    List<Integer> numeros = IntStream.rangeClosed(1, 100)
            .boxed()
            .toList();

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

    var nomeTarget = "Lucas";
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