import Utils.Utils;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Utils utils = new Utils();
        try {
            utils.marshal();
            utils.unMarshal();
        } catch (JAXBException | IOException exception) {
            exception.printStackTrace();
        }

    }
}
