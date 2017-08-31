/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int320.ec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sit.int320.ec.model.Product;

/**
 *
 * @author INT320
 */
public class ProductDAO {

    private final static String FIND_BY_DESC = "SELECT p.* , pc.description as PRODUCT_TYPE "
            + "FROM PRODUCT p, PRODUCT_CODE pc WHERE p.PRODUCT_CODE = pc.PROD_CODE AND "
            + "(p.DESCRIPTION LIKE ? OR pc.DESCRIPTION LIKE ?)";
    public static List<Product> findByDesc(String key) {
        List<Product> products = null;
        Connection conn = ConnectionBuilder.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(FIND_BY_DESC);
            pstm.setString(1, key + "%");
            pstm.setString(2, key + "%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                Product p = new Product(rs);
                if(products == null) {
                    products = new LinkedList();
                }
                products.add(p);
            }
            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return products;
    }

}
