package service;

import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = new ArrayList<>();


//    static {
//        products.add(new Product(1,"Hehe","https://tnmthcm.edu.vn/hinh-anh-body-nu-dep-che-mat/imager_19_457_700.jpg", 10000.0));
//        products.add(new Product(2,"Haha","https://tnmthcm.edu.vn/hinh-anh-body-nu-dep-che-mat/imager_19_457_700.jpg", 10000.0));
//        products.add(new Product(3,"Hihi","https://tnmthcm.edu.vn/hinh-anh-body-nu-dep-che-mat/imager_19_457_700.jpg", 10000.0));
//        products.add(new Product(4,"Kkk","https://tnmthcm.edu.vn/hinh-anh-body-nu-dep-che-mat/imager_19_457_700.jpg", 10000.0));
//    }
    public static void add(Product product){
        products.add(product);
    }
    public  static void delete(int id){
        products.remove(findByid(id));
    }
    public static Product findByid(int id){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId()==id){
                return products.get(i) ;
            }
        }
        return null;
    }

}
