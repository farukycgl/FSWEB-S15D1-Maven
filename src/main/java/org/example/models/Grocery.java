package org.example.models;

import java.util.*;

public class Grocery {
    private static List<String> groceryList = new ArrayList<>();


    public void startGrocery() {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Lütfen 0,1 veya 2 'den birini seçerek giriş yapınız.");
            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 0:
                    System.out.println("Uygulama durduruluyor..");
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz.");
                    String input = scanner.nextLine();
                    addItems(input);
                    break;
                case 2:
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz.");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;
                default:
                    System.out.println("Geçersiz giriş yapıldı. Tekrar giriniz!");
            }
        }
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void sortAndRemoveDuplicates(){
        Set<String> set = new HashSet<>(groceryList);
        groceryList.clear();
        groceryList.addAll(set);
        Collections.sort(groceryList);
        System.out.println("Sıralı liste(Tekrarlar kaldırıldı): "+ groceryList);
    }

    //case'lerde bu methodları kullanıyoruz.

    public static void addItems(String input) {
        String[] items = input.split("\\s*,\\s*");
        for (String item : items) {
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
                System.out.println(item + " listeye eklendi.");
            } else {
                System.out.println(item + " zaten listede var.");
            }
        }
        sortAndRemoveDuplicates();
    }

    public static void removeItems(String input) {
        String[] removeElements = input.split("\\s*,\\s*");
        for (String item : removeElements) {
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
                System.out.println(item + " listeden silindi.");
            } else {
                System.out.println(item + " listede bulunamadı.");
            }
        }
        sortAndRemoveDuplicates();
    }

    public static void printSorted() {
        if (groceryList.isEmpty()) {
            System.out.println("Liste bomboş!");
        } else {
            List<String> siraliListe = new ArrayList<>(groceryList);
            Collections.sort(siraliListe);
            System.out.println("Sıralı liste: " + siraliListe);
        }
    }

}
