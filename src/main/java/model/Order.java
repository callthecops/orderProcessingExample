package model;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Order {

    private int ID;
    private String created;
    private List<Product> products;


    public Order() {
    }

    public Order(int ID, String created, List<Product> products) {
        this.ID = ID;
        this.created = created;
        this.products = products;
    }

    public int getID() {
        return ID;
    }

    @XmlAttribute
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCreated() {
        return created;
    }

    @XmlAttribute
    public void setCreated(String created) {
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
