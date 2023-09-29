import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Product {
    private String type;
    private int price;
    private String productName;
    private int useDiscount;
    private List<Product> products;
    // Date
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    LocalDate localDate = LocalDate.now();
    private Date date = new Date();
    String dateAdded = simpleDateFormat.format(date);
    public Product(List<Product> products) {
        this.products = products;
    }

    public Product(String type, int price, String productName, int useDiscount) {
        this.type = type;
        this.price = price;
        this.productName = productName;
        this.useDiscount = useDiscount;
    }

    public List<Product> productsByBookCategory() {
        // Sort the list by price and category
         return products.stream()
                .filter(p -> p.getType().equals("Book") && p.getPrice() > 250)
                .toList();
    }

    public List<Product> applyingDiscount() {
        // Sort by discounts
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.getUseDiscount() == 10)
                .map(p -> {
                    double discount = p.getPrice() * 0.9;
                    return new Product(p.getType(), (int) discount, p.getProductName(), p.getUseDiscount());
                })
                .toList();
    }

    public List<Product> findCheapestBook() {
        // Cheapest product
        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .map(p -> {
                    double discount = p.getPrice() * 0.9;
                    return new Product(p.getType(), (int) discount, p.getProductName(), p.getUseDiscount());
                })
                .min(Comparator.comparing(Product::getPrice))
                .stream().toList();
    }

    public List<Product> lastAddedProducts() {
        // Three last elements
        return products.stream()
                .limit(3)
                .toList();
    }

    public List<Product> freshAndInexpensiveGoods() {
        // Fresh and inexpensive goods
        return products.stream()
                .filter(p -> p.localDate.getYear() == LocalDate.now().getYear())
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getPrice() < 75)
                .toList();
    }

    public int freshAndInexpensiveGoodsSum() {
        // Fresh and inexpensive goods sum
        return products.stream()
                .filter(p -> p.localDate.getYear() == LocalDate.now().getYear())
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getPrice() < 75)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public Map<String, List<Product>> sortByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public int getUseDiscount() {
        return useDiscount;
    }

    public String getDateAdded() {
        return dateAdded;
    }
}
