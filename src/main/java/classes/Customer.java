package classes;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Customer {
    private static final AtomicLong counter = new AtomicLong(1000);
    private long id;
    private String name;
    private int tier;


    public Customer(String name, int tier) {
        this.id = counter.getAndIncrement();
        this.name = name;
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        if (tier < 1) this.tier = 1;
        else if (tier > 5) this.tier = 5;
        else this.tier = tier;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && tier == customer.tier && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tier);
    }
}
