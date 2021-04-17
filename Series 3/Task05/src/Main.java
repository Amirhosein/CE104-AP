import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Product product = new Product("2020-3-15", "2021-3-15", "Carrot", "Vegetables", 5, 20);
        Product product1 = new Product("2020-4-1", "2020-8-1", "Apple", "Fruits", 10, 50);
        Product product2 = new Product("2020-1-1", "2020-6-1", "12xEggs", "Egg", 100, 40);
        Product product3 = new Product("2020-6-1", "2021-1-1", "Oats", "Grains", 70, 100);
        Product product4 = new Product("2020-1-1", "2020-2-1", "Salmon", "Seafood", 150, 250);
        Product product5 = new Product("2020-3-1", "2020-9-1", "Steak", "Meat", 800, 1000);
        Product product6 = new Product("2020-1-10", "2020-1-25", "Milk", "Dairy", 100, 20);
        Product product7 = new Product("2020-2-1", "2020-3-15", "Cheese", "Dairy", 150, 10);
        HashMap<Product, Integer> productIntegerHashMap = new HashMap<>();
        productIntegerHashMap.put(product, 10);
        productIntegerHashMap.put(product1, 50);
        productIntegerHashMap.put(product2, 20);
        productIntegerHashMap.put(product3, 45);
        productIntegerHashMap.put(product4, 5);
        productIntegerHashMap.put(product5, 5);
        productIntegerHashMap.put(product6, 20);
        productIntegerHashMap.put(product7, 50);
        Inventory inventory = new Inventory(productIntegerHashMap);
        Basket basket = new Basket();

        String string;

        while (true) {
            string = input.nextLine();
            if (string.contains("add")) {
                String[] choose = string.split("add ");
                int a = Integer.parseInt(choose[1]);
                basket.addProduct(inventory.getProduct(a));
                inventory.updateNumber(inventory.getProduct(a), -1);
            } else if (string.contains("cart")) {
                System.out.println(basket.toString());
            }
            else if (string.contains("products")){
                System.out.println(inventory.toString());
            }
        }
    }
}
