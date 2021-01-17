package model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
public class Product {
    private String description;
    private long gtin;
    private BigDecimal price;
    private String supplier;

    public Product() {
    }

    public Product(String description, long gtin, BigDecimal price, String supplier) {
        this.description = description;
        this.gtin = gtin;
        this.price = price;
        this.supplier = supplier;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public long getGtin() {
        return gtin;
    }

    @XmlElement
    public void setGtin(long gtin) {
        this.gtin = gtin;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    @XmlElement
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
