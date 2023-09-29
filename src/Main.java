import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 150, "Design Patterns", 10));
        products.add(new Product("Bed sheets", 260,"Cover", 10));
        products.add(new Product("Bed sheets", 120,"Pillow", 10));
        products.add(new Product("Bed sheets", 56,"Mattress", 5));
        products.add(new Product("Book", 360,"Computer architecture", 18));
        products.add(new Product("Book", 278,"Operating system device", 10));
        products.add(new Product("Book", 678,"The programmer's path", 10));
        products.add(new Product("Book", 56,"Grok algorithms", 25));
        products.add(new Product("Book", 24,"Grok algorithms 2", 5));

        Product product = new Product(products);

        System.out.println("Type" + " | " + "Name" + " | " + "Price");
        product.getProductsByBookCategory().forEach(p -> System.out.println(p.getType() + " | " + p.getProductName() + " | " + p.getPrice()));

        System.out.println("=============");
        System.out.println("Type" + " | " + "Name" + " | " + "Price" + " | " + "Discount");
        product.applyingDiscount().forEach(p -> System.out.println(p.getType() + " | " + p.getProductName() + " | " + p.getPrice() + " | " + p.getUseDiscount()));

        System.out.println("=============");
        if (product.findCheapestBook().isEmpty()) {
            System.out.println("Product [category: Book] not found!");
            return;
        }
        System.out.println("Type" + " | " + "Name" + " | " + "Price" + " | " + "Discount");
        product.findCheapestBook().forEach(p -> System.out.println(p.getType() + " | " + p.getProductName() + " | " + p.getPrice() + " | " + p.getUseDiscount()));

        System.out.println("=============");
        System.out.println("Type" + " | " + "Name" + " | " + "Price" + " | " + "Discount" + " | " + "Date");
        product.getLastAddedProducts().forEach(p -> System.out.println(p.getType() + " | " + p.getProductName() + " | " + p.getPrice() + " | " + p.getUseDiscount() + " | " + p.getDateAdded()));

        System.out.println("=============");
        System.out.println("Type" + " | " + "Name" + " | " + "Price" + " | " + "Discount" + " | " + "Date");
        product.getFreshAndInexpensiveGoods().forEach(p -> System.out.println(p.getType() + " | " + p.getProductName() + " | " + p.getPrice() + " | " + p.getUseDiscount() + " | " + p.getDateAdded()));

        System.out.println("Sum of the cheapest products: " + product.getFreshAndInexpensiveGoodsSum());

        System.out.println("\n");
        product.sortByCategory().forEach((k, v) -> {
            System.out.println("{");
            System.out.println("\t" + "\"" + k + "\",");
            System.out.println("\t[");
            v.forEach(p -> System.out.println("\t\t" + "{type: " + "\"" + p.getType() + "\", " + "name: " + p.getProductName() + ", " + "price: " + p.getPrice() + "," + " discount: " + p.getUseDiscount() + "," + " createDate: " + p.getDateAdded() + "},"));
            System.out.println("\t]");
            System.out.println("},");
        });
    }
}