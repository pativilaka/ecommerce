package com.vilaka.ecommerce.controllers;

import com.vilaka.ecommerce.dto.ProductDTO;
import com.vilaka.ecommerce.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductServices service;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){
        ProductDTO dto = service.findById(id);
        return dto;
    }

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){
        return service.findAll(pageable);

    }

    @PostMapping
    public ProductDTO insert(@RequestBody ProductDTO dto){
        dto = service.insert(dto);
        return dto;
    }
}
