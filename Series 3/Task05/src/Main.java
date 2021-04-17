import java.util.HashMap;
import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Product product = new Product("15-3-2020", "15-3-2021", "Carrot", "Vegetables", 5, 20);
        Product product1 = new Product("1-4-2020", "1-8-2020", "Apple", "Fruits", 10, 50);
        Product product2 = new Product("1-1-2020", "1-6-2020", "12xEggs", "Egg", 100, 40);
        Product product3 = new Product("1-6-2020", "1-1-2020", "Oats", "Grains", 70, 100);
        Product product4 = new Product("1-1-2020", "1-2-2020", "Salmon", "Seafood", 150, 250);
        Product product5 = new Product("1-3-2020", "1-9-2020", "Steak", "Meat", 800, 1000);
        Product product6 = new Product("10-1-2020", "25-1-2020", "Milk", "Dairy", 100, 20);
        Product product7 = new Product("1-2-2020", "15-3-2020", "Cheese", "Dairy", 150, 10);
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
                if (inventory.updateNumber(inventory.getProduct(a), -1)) {
                    basket.addProduct(inventory.getProduct(a));
                }
            } else if (string.contains("cart")) {
                System.out.println(basket.toString());
            } else if (string.contains("products")) {
                System.out.println(inventory.toString());
            } else if (string.contains("remove")) {
                String[] choose = string.split("remove ");
                int a = Integer.parseInt(choose[1]) - 1;
                if (inventory.contain(basket.getProduct(a))) {
                    inventory.updateNumber(basket.getProduct(a), 1);
                } else {
                    inventory.addProduct(basket.getProduct(a), 1);
                }
                basket.removeProduct(a);
            } else if (string.contains("checkout")) {
                System.out.println("It was a pleasure doing business with you.");
                break;
            }
        }
    }
}
