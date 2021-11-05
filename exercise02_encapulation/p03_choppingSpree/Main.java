package exercise02_encapulation.p03_choppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] personInput = sc.nextLine().split(";");
        Map<String, Person> peopleInfo = new LinkedHashMap<>();
        Map<String, Product> productInfo = new HashMap<>();

        for (String personData : personInput) {
            String personName = personData.split("=")[0];
            double money = Double.parseDouble(personData.split("=")[1]);

            try {
                Person person = new Person(personName, money);
                peopleInfo.put(personName, person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        String[] productInput = sc.nextLine().split(";");

        for (String productData : productInput) {
            String productName = productData.split("=")[0];
            double cost = Double.parseDouble(productData.split("=")[1]);

            try {
                Product product = new Product(productName, cost);
                productInfo.put(productName, product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }
        String line = sc.nextLine();
        while (!line.equals("END")) {
            String buyerName = line.split("\\s+")[0];
            String productToBuy = line.split("\\s+")[1];
            try {
                Person person = peopleInfo.get(buyerName);
                Product product = productInfo.get(productToBuy);
                person.buyProduct(product);
            } catch (IllegalArgumentException ex) {
                System.out.print(ex.getMessage());
            }

            line = sc.nextLine();

        }

        for (Person person : peopleInfo.values()) {
            System.out.print(person.getName() + " - ");
            if (person.getProducts().isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                System.out.println(person.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
            }
        }


    }
}
