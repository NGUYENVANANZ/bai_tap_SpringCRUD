package service;

import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = new ArrayList<>();


    static {
        products.add(new Product(1,"Phong","https://thethaovanhoa.mediacdn.vn/Upload/BLtvcXjb72tSqs1jiHr8g/files/2018/12/Jungkook13.jpg", 10000.0));
        products.add(new Product(2,"Toàn","https://img.meta.com.vn/Data/image/2022/02/17/anh-jungkook-1.jpg", 10000.0));
        products.add(new Product(3,"Yến","https://i.pinimg.com/originals/06/91/15/069115aea5fc95a5548b4562da55c680.jpg", 10000.0));
        products.add(new Product(4,"Linh","https://i.pinimg.com/originals/af/87/5c/af875cab80721bb5ee5e5143bc46a998.png", 10000.0));
    }
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
