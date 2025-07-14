package org.example.models;

import com.sun.source.util.SourcePositions;

import java.sql.SQLOutput;
import java.util.*;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery(){

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while(isRunning){
            System.out.println("0 - Çıkış\n" + "1 - Ürün Ekle\n" + "2 - Ürün Sil");
            System.out.print("Seçiminiz: ");
            String input = scanner.nextLine().trim();

            switch (input){
                case "0":
                    isRunning = false;
                    System.out.println("Uygulama sonlandı!");
                    break;
                case "1":
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz. ");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case "2":
                    System.out.print("Cıkarılmasını istediğiniz elemanları giriniz. ");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
                default:{
                    System.out.println("Hatalı giriş yaptınız!");
                }
            }
            printSorted();
        }
        scanner.close();
    }

    public static void addItems(String input){
         String[] items = input.split(",");

         for(String item:items){
             String product = item.trim().toLowerCase();
             if(product.isEmpty()){
                 continue;
             }
             if(!checkItemIsInList(product)){
                groceryList.add((product));
             }
             else {
                 System.out.println(product +" adlı ürün listede var!");
             }
         }
         sortList();
    }

    public static void removeItems(String input){
        String[] items = input.split(",");

        for (String item:items){
            String product = item.trim().toLowerCase();
            if (product.isEmpty()){
                continue;
            }
            if(checkItemIsInList(product)){
               groceryList.remove(product);
            }
            else {
                System.out.println("listede "+product+" adlı ürün yok!");
            }
        }
        sortList();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.trim().toLowerCase());
    }

    public static void printSorted(){
        for(int i = 0; i<groceryList.size(); i++){
            System.out.println(i+1 +". ürün : "+groceryList.get(i));
        }
    }

    private static void sortList() {
        Set<String> set = new LinkedHashSet<>(groceryList);
        groceryList = new ArrayList<>(set);
        Collections.sort(groceryList);
    }


}
