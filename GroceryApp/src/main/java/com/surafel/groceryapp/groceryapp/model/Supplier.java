package com.surafel.groceryapp.groceryapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String supplierNumber;
    private String supplierName;
    private String supplierPhoneNumber;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    List<Product> productList = new ArrayList<>();

    public Supplier(String supplierNumber, String supplierName, String supplierPhoneNumber, List<Product> productList) {
        this.supplierNumber = supplierNumber;
        this.supplierName = supplierName;
        this.supplierPhoneNumber = supplierPhoneNumber;
        this.productList = productList;
    }

    public Supplier() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierPhoneNumber() {
        return supplierPhoneNumber;
    }

    public void setSupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
