package com.surafel.groceryapp.groceryapp.repository;

import com.surafel.groceryapp.groceryapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
