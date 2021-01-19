package container;

import model.Orders;

import java.util.List;

public class OrderContainer {
    List<Orders> orderList;
    List<Integer> orderNumber;

    public List<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Orders> orderList) {
        this.orderList = orderList;
    }

    public List<Integer> getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(List<Integer> orderNumber) {
        this.orderNumber = orderNumber;
    }
}
