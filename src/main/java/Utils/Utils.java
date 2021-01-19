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

        System.out.println("The orders for the suppliers have been succesfully added to the output folder");
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
                LocalDateTime date = orderList.get(i).getCreated();
                p.setDate(date);
                allProducts.add(p);
            }
        }
        return allProducts;
    }


    public List<Orders> multiUnMarshal() throws JAXBException {
        File folder = new File("src/input/");
        File[] listOfFiles = folder.listFiles();
        List<Orders> orderList = new ArrayList<>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                String orderNumber = file.getName().substring(5, 7);

                String orderName = file.getName();
                File someFile = new File("src/input/" + orderName);
                JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                Orders orders = (Orders) unmarshaller.unmarshal(someFile);
                orders.setOrdersNumber(orderNumber);
                orderList.add(orders);

            }
        }
        return orderList;
    }


    public List<List<Order>> extractListOrder(List<Orders> ordersList) {
        List<List<Order>> order = new ArrayList<>();
        for (int i = 0; i < ordersList.size(); i++) {
            List<Order> o = ordersList.get(i).getOrder();
            order.add(o);
        }

        return order;
    }


    public List<Order> extractListOrder2(List<List<Order>> orderList) {
        List<Order> returnedOrderList = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            List<Order> order = orderList.get(i);
            returnedOrderList.addAll(order);
        }
        return returnedOrderList;
    }

    public void appWrapper(){
        try {
            List<Orders> wholeOrders = multiUnMarshal();
            List<List<Order>> extractedOrdersList = extractListOrder(wholeOrders);
            List<Order> orderList = extractListOrder2(extractedOrdersList);
            List<Product> productList = extractProducts(orderList);
            marshall(productList);
        } catch (JAXBException exception) {
            exception.printStackTrace();
        }
    }
}
