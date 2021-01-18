import Utils.Utils;
import com.google.common.collect.Multimap;
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
            Multimap<String, Product> productsByVendors = utils.selectProductsByVendors(products);
            utils.marshall(productsByVendors);

        } catch (JAXBException exception) {
            exception.printStackTrace();
        }

    }
}
