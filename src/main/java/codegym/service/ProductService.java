package codegym.service;

import codegym.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = new ArrayList<>();

    public static void add(Product product) {
        products.add(product);
    }

    public static void delete(int id) {
        products.remove(findByid(id));
    }

    public static Product findByid(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return products.get(i);
            }
        }
        return null;
    }



}
