package pro.sky.java.course2.newStore.model;

import java.util.Objects;

public class Product {

    private final String id;
    private final String nameOfProduct;
    private int quantity;

    public Product(String id, String nameOfProduct, int quantity) {
        this.id = id;
        this.nameOfProduct = nameOfProduct;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) && nameOfProduct.equals(product.nameOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
