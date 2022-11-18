package controller;

import Model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {
    @GetMapping("/show")
    public ModelAndView showProduct() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", ProductService.products);
        return modelAndView;


    }

    @GetMapping("/edit")
    public ModelAndView editPage(int id, Model model) {
        ModelAndView modelAndView = new ModelAndView("edit");
        model.addAttribute("product", ProductService.findByid(id));
        return modelAndView;
    }


    @PostMapping(value = "/edit")
    public String editProduct(@ModelAttribute Product product, @RequestParam MultipartFile imgFile) throws IOException {
        String name = imgFile.getOriginalFilename();

        for (Product p : ProductService.products) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                if (!name.equals("")) {
                    FileCopyUtils.copy(imgFile.getBytes(), new File("C:\\C0722G1\\Modun_4\\Ngay_1\\CRUD\\src\\main\\webapp\\WEB-INF\\img\\" + name));
                    p.setImg(name);
                }
                break;
            }
        }


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
        ProductService.products.add(product);
        return "redirect:/show";
    }

    @GetMapping("/delete")
    public String deleteProduct(int id) {
        ProductService.products.remove(ProductService.findByid(id));

        return "redirect:/show";
    }


}
