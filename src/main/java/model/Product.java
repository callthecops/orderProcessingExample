package model;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;


public class Product {
    private String description;
    private long gtin;
    private BigDecimal price;
    private String supplier;
    private String currency;
    private int orderId;
    public Product() {
    }

    public Product(String description, long gtin, BigDecimal price, String supplier) {
        this.description = description;
        this.gtin = gtin;
        this.price = price;
        this.supplier = supplier;
    }

    public Product(String description, long gtin, BigDecimal price, String supplier, String currency, int orderId) {
        this.description = description;
        this.gtin = gtin;
        this.price = price;
        this.supplier = supplier;
        this.currency = currency;
        this.orderId = orderId;
    }

    public String getCurrency() {
        return currency;
    }

    @XmlAttribute(name = "currency")
    public void setCurrency(String currency) {
        this.currency = currency;
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

    public int getOrderId() {
        return orderId;
    }

    @XmlElement
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
