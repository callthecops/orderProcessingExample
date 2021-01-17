package model;

import adapters.IdAdapter;
import adapters.LocalDateTimeAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;


public class Order {


    private Integer ID;
    private LocalDateTime created;
    private List<Product> products;


    public Order() {
    }

    public Order(Integer ID, LocalDateTime created, List<Product> products) {
        this.ID = ID;
        this.created = created;
        this.products = products;
    }

    public Integer getID() {
        return ID;
    }
    @XmlAttribute(name="ID")
    @XmlJavaTypeAdapter(IdAdapter.class)
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @XmlAttribute
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
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
