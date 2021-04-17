import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Product.
 */
public class Product {
    private Date manufacture = new Date();
    private Date expiration = new Date();
    private String name;
    private String category;
    private float weight;
    private float price;
    /**
     * The Format.
     */
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Instantiates a new Product.
     *
     * @param manufacture the manufacture
     * @param expiration  the expiration
     * @param name        the name
     * @param category    the category
     * @param weight      the weight
     * @param price       the price
     */
    public Product(String manufacture, String expiration, String name, String category, float weight, float price) {
        try {
            this.manufacture = format.parse(manufacture);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            this.expiration = format.parse(expiration);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.price = price;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\"Product\": {\n\t" +
                "\"NAME\": \"" + name + "\",\n\t" +
                "\"CATEGORY\": \"" + category + "\",\n\t" +
                "\"WEIGHT\": \"" + weight + "\",\n\t" +
                "\"PRICE\": \"" + price + "\",\n\t" +
                "\"MANUFACTURE\": " + format.format(manufacture) + ",\n\t" +
                "\"EXPIRATION\": " + format.format(expiration) + "\n\t" +
                '}';
    }
}
