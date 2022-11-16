package controller;

import Model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.ProductService;

@Controller
public class ProductController {
    @GetMapping("/show")
    public String showProduct(Model model){
        model.addAttribute("products", ProductService.products);
        return "index";


    }
    @GetMapping("/edit")
    public String editPage(int id, Model model){
        model.addAttribute("product", ProductService.findByid(id));
        return "edit";
    }


    @PostMapping("/editsp")
    public String editProduct(@ModelAttribute Product product){
        for (Product p : ProductService.products) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setImg(product.getImg());
                break;
            }
        }
        return "redirect:/show";

    }
    @GetMapping("/create")
    public String createProduct(@ModelAttribute Product product){
        ProductService.products.add(product);
        return "redirect:/show";
    }
    @GetMapping("/delete")
    public String deleteProduct(int id){
        ProductService.products.remove(ProductService.findByid(id));

        return "redirect:/show";
    }




}
