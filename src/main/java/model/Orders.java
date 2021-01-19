package model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@XmlRootElement(name = "orders")

public class Orders {
    @XmlTransient
    private String ordersNumber;
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

    public String getOrdersNumber() {
        return ordersNumber;
    }

    public void setOrdersNumber(String ordersNumber) {
        this.ordersNumber = ordersNumber;
    }
}
