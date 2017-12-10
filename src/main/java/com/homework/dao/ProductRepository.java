package com.homework.dao;

import com.homework.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByName(String name);

    void deleteByName(String name);

    List<Product> findAllByManufacturerId(final UUID manufacturerId);
}
