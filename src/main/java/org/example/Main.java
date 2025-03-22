package org.example;

import org.example.models.Grocery;

public class Main {
    public static void main(String[] args) {
        Grocery grocery = new Grocery();

        System.out.println("**Ekleme**");
        grocery.addItems("Elma, Armut, Muz");
        grocery.addItems("Elma, Limon, Çilek");

        System.out.println("**Silme**");
        grocery.removeItems("Armut, Çilek");
        grocery.removeItems("Karpuz, Çilek, Muz");

        System.out.println("**Listeyi göster**");
        grocery.printSorted();

    }
}
