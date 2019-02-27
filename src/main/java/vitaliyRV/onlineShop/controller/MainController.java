package vitaliyRV.onlineShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vitaliyRV.onlineShop.service.ProductService;
import vitaliyRV.onlineShop.utils.CartContainer;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CartContainer cartContainer;

    @RequestMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @RequestMapping("/cart/add/{id}")
    public String cartAddProduct(@PathVariable(value = "id") int id) {
        cartContainer.addItem(productService.getProduct(id));
        System.out.println(cartContainer);
        return "redirect:/";
    }

    @RequestMapping("/cart/remove/{id}")
    public String cartRemoveProduct(@PathVariable(value = "id") int id) {
        cartContainer.removeItem(id);
        return "redirect:/cart";
    }

    @RequestMapping("/cart/clear")
    public String cartClear() {
        cartContainer.clear();
        return "redirect:/cart";
    }

    @RequestMapping("/cart")
    public String cartView() {
        return "cart";
    }

}
