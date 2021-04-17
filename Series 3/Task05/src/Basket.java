import java.util.ArrayList;
import java.util.Iterator;

/**
 * The type Basket.
 */
public class Basket {
    private ArrayList<Product> inventory = new ArrayList<>();

    /**
     * Add product.
     *
     * @param product the product
     */
    public void addProduct(Product product) {
        inventory.add(product);
    }

    /**
     * Remove product.
     *
     * @param index the index
     */
    public void removeProduct(int index) {
        inventory.remove(index);
    }

    /**
     * Gets product.
     *
     * @param index the index
     * @return the product
     */
    public Product getProduct(int index) {
        return inventory.get(index);
    }

    @Override
    public String toString() {
        Iterator<Product> it = inventory.iterator();
        String result = "Itemsincart:\n";
        int index = 1;
        if (!it.hasNext()) {
            return "List is empty.";
        }
        while (it.hasNext()) {
            Product thisProduct = it.next();
            result = result.concat(index + "){\n");
            result = result.concat(thisProduct.toString() + "\n}\n");
            index++;

        }
        return result;
    }

    /**
     * Total price float.
     *
     * @return the float
     */
    public float totalPrice() {
        float sum = 0;

        for (Product p : inventory) {
            sum += p.getPrice();
        }

        return sum;
    }
}
