import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/main/resources/input/Order01.xml");
            NodeList orderList = document.getElementsByTagName("order");
            for (int i = 0; i < orderList.getLength(); i++) {
                Node node = orderList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element order = (Element) node;
                    String date = order.getAttribute("created");
                    String id = order.getAttribute("ID");
                    System.out.println(date);
                    System.out.println(id);
                    NodeList nodeList = order.getChildNodes();
                    for (int j = 0; j < nodeList.getLength(); j++) {
                        Node child = nodeList.item(j);
                        if (child.getNodeType() == Node.ELEMENT_NODE) {
                            Element product = (Element) child;
                            System.out.println("Product" + id + ":" + product.getTagName() + "is" + product.getTextContent());
                            String description = product.get

                        }
                    }

                }
            }
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            exception.printStackTrace();
        }
    }
}
