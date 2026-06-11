package classes;

import datiFissi.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Order {
    private static final AtomicLong counter = new AtomicLong(100);
    private long id;
    private OrderStatus status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;


    public Order(OrderStatus status, Customer customer) {
        this.id = counter.getAndIncrement();
        this.status = status;
        this.orderDate = LocalDate.now();
        this.deliveryDate = LocalDate.now().plusDays(5);
        this.products = new ArrayList<>();
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double calculateTotal() {
        return this.products.stream().collect(Collectors.summarizingDouble(product -> product.getPrice())).getSum();
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
