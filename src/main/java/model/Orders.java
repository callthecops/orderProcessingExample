package model;





import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "orders")
public class Orders {


    private int ID;

    private String created;

    private List<Order> order;

    public int getID() {
        return ID;
    }

    public Orders() {
    }

    public Orders(int ID, String created, List<Order> order) {
        this.ID = ID;
        this.created = created;
        this.order = order;
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

    public List<Order> getOrder() {
        return order;
    }

    @XmlElement
    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
