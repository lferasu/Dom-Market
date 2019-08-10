package com.surafel.groceryapp.groceryapp.controller;

import com.surafel.groceryapp.groceryapp.model.Product;
import com.surafel.groceryapp.groceryapp.service.ProductService;
import com.surafel.groceryapp.groceryapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    SupplierService supplierService;

    @GetMapping(value={"/showNewProduct"})
    public String newCustomerForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        model.addAttribute("now", LocalDate.now());
        return "product/new";
    }




    @PostMapping(value = {"/registerProduct"})
    public String registerNewCustomer(
            @Valid
            @ModelAttribute("product")
                    Product product,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "product/new";
        }
        productService.registerProduct(product);
        return "redirect:/listProduct";
    }

    @GetMapping(value={"/listProduct"})
    public ModelAndView listCustomers(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("products", productService.getAllProducts(pageno));
        mav.addObject("currentPageNo", pageno);
        mav.addObject("now", LocalDate.now());
        mav.setViewName("product/list");
        return mav;
    }



}
