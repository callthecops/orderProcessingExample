package adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IdAdapter extends XmlAdapter<String,Integer> {
    @Override
    public Integer unmarshal(String s) throws Exception {
        return Integer.parseInt(s);
    }

    @Override
    public String marshal(Integer integer) throws Exception {
        return null;
    }
}
