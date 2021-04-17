import java.util.ArrayList;
import java.util.Iterator;

public class Basket {
    private ArrayList<Product> inventory = new ArrayList<>();

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void removeProduct(int index) {
        inventory.remove(index);
    }

    @Override
    public String toString() {
        Iterator<Product> it = inventory.iterator();
        String result = "Itemsincart:\n";
        int index = 1;
        if (!it.hasNext()){
            System.out.println("List is empty.");
            return null;
        }
        while (it.hasNext()){
            Product thisProduct = it.next();
            result = result.concat(index + "){\n");
            result = result.concat(thisProduct.toString() + "\n}");
            index++;

        }
        return result;
    }

    public float totalPrice() {
        Iterator<Product> it = inventory.iterator();
        float sum = 0;

        for (Product p : inventory){
            sum += p.getPrice();
        }

        return sum;
    }
}
