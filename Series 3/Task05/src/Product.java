import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Product {
    private Date manufacture = new Date();
    private Date expiration = new Date();
    private String name;
    private String category;
    private int weight;
    private float price;

    public Product(Date manufacture, Date expiration, String name, String category, int weight, float price) {
        this.manufacture = manufacture;
        this.expiration = expiration;
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.price = price;
    }


}
