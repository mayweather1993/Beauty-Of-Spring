package com.homework.services;

import com.homework.dao.ManufacturerRepository;
import com.homework.exceptions.ResourceNotFoundException;
import com.homework.models.Manufacturer;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ManufacturerService implements CrudService<Manufacturer> {

    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Manufacturer create(final Manufacturer entity) {
        return manufacturerRepository.save(entity);
    }

    @Override
    public Manufacturer findById(final UUID id) {
        return manufacturerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Manufacturer Not found"));
    }

}
