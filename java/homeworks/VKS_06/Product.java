package homeworks.VKS_06;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Product {
    private String type;
    private double price;
    private boolean discount;
    private LocalDateTime createDate;

    public Product() {
    }

    public Product(String type, int price, boolean discount, LocalDateTime createDate) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", createDate=" + createDate +
                '}';
    }
}
