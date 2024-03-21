package com.ecommerce.shoppingapp.controller;

import com.ecommerce.shoppingapp.model.User;
import com.ecommerce.shoppingapp.model.loginAuth;
import com.ecommerce.shoppingapp.model.productData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignupForm(@ModelAttribute("user") User user){
        System.out.println(user.toString());
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute loginAuth user){
        System.out.println(user.toString());
        return "redirect:/productadd";
    }

    @GetMapping("/productadd")
    public String addProduct(){
        return "productadd";
    }

    @GetMapping("/productDisplay")
    public String displayProduct(){
        return "productDisplay";
    }

    @PostMapping("/submitProduct")
    @ResponseBody
    public String submitProduct(@RequestBody productData product) {
        System.out.println("Received product:");
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Description: " + product.getDescription());

        return "Product received successfully!";
    }
}
