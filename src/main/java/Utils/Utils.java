package Utils;

import container.OrderContainer;
import model.Order;
import model.Orders;
import model.Product;
import wrapper.ProductList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.LocalDateTime;
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
                LocalDateTime asd = orderList.get(i).getCreated();
                p.setDate(asd);
                System.out.println(orderList.get(i).getCreated());

                allProducts.add(p);
            }
        }
        return allProducts;
    }

    public OrderContainer multiUnMarshal() throws JAXBException {
        File folder = new File("src/input/");
        File[] listOfFiles = folder.listFiles();
        List<Orders> orderList = new ArrayList<>();
        List<Integer> orderNumbers = new ArrayList<>();
        OrderContainer orderContainer = new OrderContainer();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                int orderNumber = Integer.parseInt(file.getName().substring(5, 7));
                String orderName = file.getName();
                File someFile = new File("src/input/" + orderName);
                JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                Orders orders = (Orders) unmarshaller.unmarshal(someFile);
                orderList.add(orders);
                orderNumbers.add(orderNumber);
            }
        }
        orderContainer.setOrderList(orderList);
        orderContainer.setOrderNumber(orderNumbers);
        return orderContainer;
    }


    public List<Order> assign

    public List<List<Order>> extractOrder(List<Orders> ordersList) {
        List<List<Order>> order = new ArrayList<>();
        for (int i = 0; i < ordersList.size(); i++) {
            List<Order> o = ordersList.get(i).getOrder();
            order.add(o);
        }

        return order;
    }
}
