import Utils.Utils;

import javax.xml.bind.JAXBException;

public class App {
    public static void main(String[] args) {
        Utils utils = new Utils();
        try {
            utils.marshall();
            utils.unMarshal();
        } catch (JAXBException exception) {
            exception.printStackTrace();
        }

    }
}
