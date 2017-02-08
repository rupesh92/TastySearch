package models;

/**
 * Created by rupesh on 06/02/17.
 */
public class Product {

    private String productID;

    public Product(final String productID) {
        this.productID = productID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(final String productID) {
        this.productID = productID;
    }

}
