package sit.int320.ec.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import sit.int320.ec.dao.ProductDAO;

public class Product extends ProductDAO {

    private int productId;
    private String description;
    private double price;
    private String productCode;
    private String productType;

    public Product(ResultSet rs) throws SQLException {
        this.productId = rs.getInt("PRODUCT_ID");
        this.description = rs.getString("DESCRIPTION");
        this.price = rs.getDouble("PURCHASE_COST") + rs.getDouble("MARKUP");
        this.productType = rs.getString("PRODUCT_TYPE");
        this.productCode = rs.getString("PRODUCT_CODE");
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

}
