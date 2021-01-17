package model;




import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.List;

@XmlRootElement
public class Order {
    private LocalDateTime created;
    private List<Product> products;


    public LocalDateTime getCreated() {
        return created;
    }


    @XmlElement
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
