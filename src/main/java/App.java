import Utils.Utils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;

public class App {
    public static void main(String[] args) {
        Utils utils = new Utils();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            NodeList orderNodes = utils.selectTagNodes("src/main/resources/input/Order01.xml", "order", factory);
            System.out.println(orderNodes.getLength());

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.parse("src/main/resources/input/Order01.xml");
//            NodeList orderList = document.getElementsByTagName("order");
//            for (int i = 0; i < orderList.getLength(); i++) {
//                Node node = orderList.item(i);
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element order = (Element) node;
//                    String date = order.getAttribute("created");
//                    String id = order.getAttribute("ID");
//                    System.out.println(date);
//                    System.out.println(id);
//                    NodeList nodeList = order.getChildNodes();
//                    for (int j = 0; j < nodeList.getLength(); j++) {
//                        Node child = nodeList.item(j);
//                        if (child.getNodeType() == Node.ELEMENT_NODE) {
//                            Element product = (Element) child;
//                            System.out.println(product.getTagName());
//                            NodeList productChildren = product.getChildNodes();
//                            for(int k = 0;k<productChildren.getLength();k++){
//                                Node productChild = productChildren.item(i);
//                                System.out.println(productChild.getTextContent());
//                            }
////                            System.out.println("Product" + id + ":" + product.getTagName() + "is" + product.getTextContent());
//
//
//                        }
//                    }
//
//                }
//            }
//        } catch (ParserConfigurationException | SAXException | IOException exception) {
//            exception.printStackTrace();
//        }
//    }
}
