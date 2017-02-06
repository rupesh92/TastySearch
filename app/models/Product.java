package models;

/**
 * Created by rupesh on 06/02/17.
 */
public class Product {

    private String productID;

    public Product(String productID) {
        this.productID = productID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

}
