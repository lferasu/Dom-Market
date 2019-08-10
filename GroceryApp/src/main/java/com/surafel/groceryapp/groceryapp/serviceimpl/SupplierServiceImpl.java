package com.surafel.groceryapp.groceryapp.serviceimpl;

import com.surafel.groceryapp.groceryapp.model.Supplier;
import com.surafel.groceryapp.groceryapp.repository.SupplierRepository;
import com.surafel.groceryapp.groceryapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepository supplierRepository;
    @Override
    public List<Supplier> getAllSuppliers() {
        return  supplierRepository.findAll();
    }
}
