import Utils.Utils;
import model.Orders;

import javax.xml.bind.JAXBException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Utils utils = new Utils();
        try {


           List<Orders> orders= utils.multiUnMarshal();
           for(Orders o : orders){
               System.out.println(o.getOrdersNumber());
           }
//            List<Orders> wholeOrders = utils.multiUnMarshal();
//            List<List<Order>> extractedOrders = utils.extractOrder(wholeOrders);


//            utils.multiUnMarshal();
//            Orders orders = utils.unMarshal();
//            List<Order> order = orders.getOrder();
//            List<Product> products = utils.extractProducts(order);
//            utils.marshall(products);

        } catch (JAXBException exception) {
            exception.printStackTrace();
        }

    }
}
