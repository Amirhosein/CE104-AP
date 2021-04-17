import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Inventory {
    HashMap<Product, Integer> inventory = new HashMap<>();

    public Inventory(HashMap<Product, Integer> inventory) {
        this.inventory = inventory;
    }

    public Inventory() {
    }

    public void addProduct(Product name) {
        inventory.put(name, 0);
    }

    public void addProduct(Product name, Integer number) {
        inventory.put(name, number);
    }

    public void removeProduct(Product name) {
        inventory.remove(name);
    }

    public void updateNumber(Product name , Integer number){
        inventory.put(name, inventory.get(name) + number);
    }

    public Product getProduct(int index){
        Iterator<Product> it = inventory.keySet().iterator();

        for (int i = 0; i < index - 1; i++) {
            it.next();
        }

        return it.next();
    }

    @Override
    public String toString() {
        Iterator<Product> it = inventory.keySet().iterator();
        String result = "";
        int index = 1;
        while (it.hasNext()){
            Product thisProduct = it.next();
            result = result.concat(index + "){\n");
            result = result.concat(thisProduct.toString() + "\n");
            result = result.concat("}instock: " + inventory.get(thisProduct) + "\n" );
            index++;

        }
        return result;
    }
}
