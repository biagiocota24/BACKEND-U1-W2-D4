package classes;

import datiFissi.Categories;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Product {

    private static final AtomicLong counter = new AtomicLong(1);
    private long id;
    private String name;
    private Categories category;
    private double price;

    public Product(String name, Categories category, double price) {
        this.id = counter.getAndIncrement();
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Categories getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(price, product.price) == 0 && Objects.equals(name, product.name) && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, price);
    }
}
