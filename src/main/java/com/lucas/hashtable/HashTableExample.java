package main.java.com.lucas.hashtable;

import java.util.HashMap;

public class HashTableExample {

    public static void example() {
        var book = new HashMap<String, Double>();
        book.put("Maçã",0.67);
        book.put("Leite",1.49);
        book.put("Abacate",1.49);

        System.out.println(book);

        System.out.println(book.get("Abacate")); // Retorna 1.49
    }
}
