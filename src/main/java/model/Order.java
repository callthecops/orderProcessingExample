package model;

import adapters.LocalDateTimeAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
    @XmlAttribute(name = "ID")
    private int ID;
    @XmlAttribute
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime created;
    @XmlElement(name = "product")
    private List<Product> product;


    public Order() {
    }

    public Order(int ID, LocalDateTime created, List<Product> products) {
        this.ID = ID;
        this.created = created;
        this.product = products;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDateTime getCreated() {
        return created;
    }


    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public List<Product> getProducts() {
        return product;
    }


    public void setProducts(List<Product> products) {
        this.product = products;
    }
}
