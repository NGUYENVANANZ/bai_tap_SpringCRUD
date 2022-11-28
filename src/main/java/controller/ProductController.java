package controller;

import Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import repository.ISProduct;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {

    @Autowired
    ISProduct isProduct;

    @GetMapping("/show")
    public ModelAndView showProduct(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "name") String option) {
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("products", isProduct.findAll(PageRequest.of(page, 3)));
        modelAndView.addObject("option", option);
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
        if (!name.equals("")) {
            FileCopyUtils.copy(imgFile.getBytes(), new File("C:\\C0722G1\\Modun_4\\Ngay_1\\CRUD\\src\\main\\webapp\\WEB-INF\\img\\" + name));
            product1.setImg(name);
        }

        isProduct.save(product1);
        return "redirect:/show";
    }

    @GetMapping("/create")
    public ModelAndView createProduct() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, @RequestParam MultipartFile imgFile, Model model) throws IOException {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        if (imgFile.getSize()==0 ){
            model.addAttribute("imgFile", "chưa chọn file");
            return "create";
        }
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
