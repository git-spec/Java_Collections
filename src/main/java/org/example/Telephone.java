package org.example;

import java.util.*;

public class Telephone {
    static Map<String, Double> book = new HashMap<>();

    public static void add(String name, Double number) {
        book.put(name, number);
    }

    public static int getSize() {
        return book.size();
    }

    public static void deleteByName(String name) {
        book.remove(name);
    }

    public static void deleteAll() {
        book.clear();
    }
}
