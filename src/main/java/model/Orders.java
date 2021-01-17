package model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "orders")
public class Orders {

    private List<Order> order;

    public Orders() {
    }

    public Orders(List<Order> order) {
        this.order = order;
    }

    public List<Order> getOrder() {
        return order;
    }

    @XmlElement
    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
