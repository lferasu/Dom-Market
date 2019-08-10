package com.surafel.groceryapp.groceryapp.service;

import com.surafel.groceryapp.groceryapp.model.Product;
import org.springframework.data.domain.Page;

public interface ProductService {

    public abstract Product registerProduct(Product product);
    Page<Product> getAllProducts(int pageNo);
}
