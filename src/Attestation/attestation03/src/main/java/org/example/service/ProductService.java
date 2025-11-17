package org.example.service;

import org.example.dto.ProductDTO;
import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.example.util.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<ProductDTO> getAll() {
        return repo.findByDeletedFalse().stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }

    public ProductDTO getById(Long id) {
        return repo.findByIdAndDeletedFalse(id).map(ProductMapper::toDto).orElse(null);
    }

    public ProductDTO create(ProductDTO dto) {
        Product p = ProductMapper.toEntity(dto);
        Product saved = repo.save(p);
        return ProductMapper.toDto(saved);
    }

    public ProductDTO update(Long id, ProductDTO dto) {
        return repo.findByIdAndDeletedFalse(id).map(entity -> {
            ProductMapper.updateEntityFromDto(dto, entity);
            Product updated = repo.save(entity);
            return ProductMapper.toDto(updated);
        }).orElse(null);
    }

    public boolean softDelete(Long id) {
        return repo.findByIdAndDeletedFalse(id).map(entity -> {
            entity.setDeleted(true);
            repo.save(entity);
            return true;
        }).orElse(false);
    }
}
