/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int320.ec.driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import sit.int320.ec.dao.ConnectionBuilder;
import sit.int320.ec.model.Product;

/**
 *
 * @author INT320
 */
public class Driver {

    public static void main(String args[]) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String searchKey = "Java";
        do {
            System.out.print("Please enter product description (stop to exit) : ");
            searchKey = sc.next();
            if (!searchKey.equalsIgnoreCase("stop")) {
                List<Product> products = Product.findByDesc(searchKey);

                if (products != null) {
                    for (Product p : products) {
                        System.out.printf("%6d%-50s%-10s%10.2f\n",
                                p.getProductId(), p.getDescription(), p.getProductType(), p.getPrice());
                    }
                } else {
                    System.out.println(searchKey + " doest not exist ... Please try agsin !!!");
                }
            }
        } while (!searchKey.equalsIgnoreCase("stop"));
    }
}
