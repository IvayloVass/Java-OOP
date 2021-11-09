package exercise04_interfacesAndAbstraction.collectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] items = sc.nextLine().split("\\s+");

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();
        int removeOperations = Integer.parseInt(sc.nextLine());

        printAdd(items, addCollection);
        printAdd(items, addRemoveCollection);
        printAdd(items, myList);

        printRemove(removeOperations, addRemoveCollection);
        printRemove(removeOperations, myList);

    }

    private static void printRemove(int removeOperations, AddRemovable collection) {
        for (int i = 0; i < removeOperations; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    private static void printAdd(String[] items, Addable collection) {
        for (String item : items) {
            System.out.print(collection.add(item) + " ");
        }
        System.out.println();
    }

}
