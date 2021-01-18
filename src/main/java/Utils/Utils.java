package Utils;

import model.Order;
import model.Orders;
import model.Product;
import wrapper.ProductList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public void marshall(List<Product> products) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ProductList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        ProductList panasonic = new ProductList();
        ProductList apple = new ProductList();
        ProductList sony = new ProductList();

        for (Product product : products) {
            if (product.getSupplier().equals("Panasonic")) {
                panasonic.getProductList().add(product);
            } else if (product.getSupplier().equals("Apple")) {
                apple.getProductList().add(product);
            } else {
                sony.getProductList().add(product);
            }
        }

        marshaller.marshal(panasonic, new File("src/output/panasonic.xml"));
        marshaller.marshal(apple, new File("src/output/apple.xml"));
        marshaller.marshal(sony, new File("src/output/sony.xml"));
//        marshaller.marshal(orders, new File("src/output/orders.xml"));
    }

    public Orders unMarshal() throws JAXBException {
        File someFile = new File("src/input/Order01.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (Orders) unmarshaller.unmarshal(someFile);
    }

    public List<Product> extractProducts(List<Order> orderList) {
        List<Product> allProducts = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            List<Product> products = orderList.get(i).getProducts();
            for (Product p : products) {
                p.setOrderId(orderList.get(i).getID());
                allProducts.add(p);
            }
        }
        return allProducts;
    }

}
