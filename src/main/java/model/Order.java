package model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private LocalDateTime created;
    private List<Product> products;


    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
