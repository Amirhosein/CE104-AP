import java.util.HashMap;

public class Inventory {
    HashMap<String, Integer> inventory = new HashMap<>();

    public Inventory(HashMap<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public Inventory() {
    }

    public void addProduct(String name) {
        inventory.put(name, 0);
    }

    public void addProduct(String name, Integer number) {
        inventory.put(name, number);
    }

    public void removeProduct(String name) {
        inventory.remove(name);
    }

    public void updateNumber(String name , Integer number){
        inventory.put(name, inventory.get(name) + number);
    }
}
