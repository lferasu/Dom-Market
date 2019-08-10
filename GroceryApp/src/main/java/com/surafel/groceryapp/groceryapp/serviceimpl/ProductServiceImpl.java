package com.surafel.groceryapp.groceryapp.serviceimpl;

import com.surafel.groceryapp.groceryapp.model.Product;
import com.surafel.groceryapp.groceryapp.repository.ProductRepository;
import com.surafel.groceryapp.groceryapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product registerProduct(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Page<Product> getAllProducts(int pageNo) {
       return productRepository.findAll(PageRequest.of(pageNo,5, Sort.by("productName")));
    }
}
