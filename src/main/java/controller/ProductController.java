package controller;

import Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import repository.ISProduct;
import service.ProductService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ISProduct isProduct;

    @GetMapping("/show")
    public ModelAndView showProduct() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", isProduct.findAll());
        return modelAndView;


    }

    @GetMapping("/edit")
    public ModelAndView editPage(Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = isProduct.findById(id).get();
        modelAndView.addObject("product", product);
        return modelAndView;
    }


    @PostMapping(value = "/edit")
    public String editProduct(@ModelAttribute Product product, @RequestParam MultipartFile imgFile) throws IOException {
        String name = imgFile.getOriginalFilename();
        Product product1 = isProduct.findById(product.getId()).get();
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        if (!name.equals("")) {
            FileCopyUtils.copy(imgFile.getBytes(), new File("C:\\C0722G1\\Modun_4\\Ngay_1\\CRUD\\src\\main\\webapp\\WEB-INF\\img\\" + name));
            product1.setImg(name);
        }

        isProduct.save(product1);
        return "redirect:/show";
    }

    @GetMapping("/create")
    public String createProduct() {
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, @RequestParam MultipartFile imgFile) throws IOException {
        String name = imgFile.getOriginalFilename();

        FileCopyUtils.copy(imgFile.getBytes(), new File("C:\\C0722G1\\Modun_4\\Ngay_1\\CRUD\\src\\main\\webapp\\WEB-INF\\img\\" + name));

        product.setImg(name);
        isProduct.save(product);
        return "redirect:/show";
    }

    @GetMapping("/delete")
    public String deleteProduct(Long id) {
        isProduct.deleteById(id);
        return "redirect:/show";
    }


}
