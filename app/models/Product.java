package models;

/**
 * Created by rupesh on 06/02/17.
 */
public class Product {

    private String productID;

    /**
     * Constructor to instantiate the product object
     * @param productID
     */
    public Product(final String productID) {
        this.productID = productID;
    }

    /**
     * Constructor to get the productID of the object
     * @return
     */
    public String getProductID() {
        return productID;
    }

}
