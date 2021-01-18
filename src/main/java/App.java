import Utils.Utils;
import model.Order;
import model.Orders;
import model.Product;

import javax.xml.bind.JAXBException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Utils utils = new Utils();
        try {
            Orders orders = utils.unMarshal();
            List<Order> order = orders.getOrder();
            List<Product> products = utils.extractProducts(order);
            for (Product p : products) {
                System.out.println(p.getDescription());
                System.out.println(p.getSupplier());
                System.out.println(p.getGtin());
                System.out.println(p.getPrice());
                System.out.println("ORDER ID");
                System.out.println(p.getOrderId());
            }

//            Order order1 = order.get(0);
//            Order order2 = order.get(1);
//            List<Product> products = order1.getProducts();
//            List<Product> products1 = order2.getProducts();
//            System.out.println(products.size());
//            System.out.println(products1.size());
//            for (Product p : products) {
//                System.out.println(p.getDescription());
//            }
//            System.out.println("BLANK");
//            System.out.println("BLANK");
//            System.out.println("BLANK");
//            for (Product p : products1) {
//                System.out.println(p.getDescription());
//            }

        } catch (JAXBException exception) {
            exception.printStackTrace();
        }

    }
}
