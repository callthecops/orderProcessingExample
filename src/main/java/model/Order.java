package model;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.List;

@XmlRootElement
public class Order {

    private LocalDateTime created;
    private List<Product> products;


    public Order() {
    }

    public Order(LocalDateTime created, List<Product> products) {
        this.created = created;
        this.products = products;
    }

    public LocalDateTime getCreated() {
        return created;
    }


    @XmlAttribute
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public List<Product> getProducts() {
        return products;
    }


    @XmlElement
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
