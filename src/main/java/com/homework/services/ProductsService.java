package com.homework.services;

import com.homework.dao.ProductRepository;
import com.homework.exceptions.ResourceNotFoundException;
import com.homework.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductsService implements CrudService<Product> {

    private final ProductRepository productRepository;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Product create(final Product entity) {
        return productRepository.save(entity);
    }

    public List<Product> findByManufacturerId(final UUID manufacturerId) {
        return productRepository.findAllByManufacturerId(manufacturerId);
    }

    @Override
    public Product findById(final UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

}
