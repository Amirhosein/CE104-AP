import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The type Inventory.
 */
public class Inventory {
    /**
     * The Inventory.
     */
    HashMap<Product, Integer> inventory = new HashMap<>();

    /**
     * Instantiates a new Inventory.
     *
     * @param inventory the inventory
     */
    public Inventory(HashMap<Product, Integer> inventory) {
        this.inventory = inventory;
    }

    /**
     * Instantiates a new Inventory.
     */
    public Inventory() {
    }

    /**
     * Add product.
     *
     * @param name the name
     */
    public void addProduct(Product name) {
        inventory.put(name, 0);
    }

    /**
     * Add product.
     *
     * @param name   the name
     * @param number the number
     */
    public void addProduct(Product name, Integer number) {
        inventory.put(name, number);
    }

    /**
     * Remove product.
     *
     * @param name the name
     */
    public void removeProduct(Product name) {
        inventory.remove(name);
    }

    /**
     * Update number boolean.
     *
     * @param name   the name
     * @param number the number
     * @return the boolean
     */
    public boolean updateNumber(Product name , Integer number){
        if (inventory.get(name) + number < 0){
            return false;
        }
        inventory.put(name, inventory.get(name) + number);
        if (inventory.get(name) == 0){
            inventory.remove(name);
        }
        return true;
    }

    /**
     * Contain boolean.
     *
     * @param product the product
     * @return the boolean
     */
    public boolean contain(Product product){
        return inventory.containsKey(product);
    }

    /**
     * Get product product.
     *
     * @param index the index
     * @return the product
     */
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
        if (!it.hasNext()){
            return "We are out of stock.";
        }
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
