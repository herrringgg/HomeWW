package org.example.util;

import org.example.dto.ProductDTO;
import org.example.entity.Product;

public class ProductMapper {
    public static ProductDTO toDto(Product p) {
        if (p == null) return null;
        return ProductDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .description(p.getDescription())
                .productType(p.getProductType())
                .brand(p.getBrand())
                .price(p.getPrice())
                .stock(p.getStock())
                .build();
    }

    public static Product toEntity(ProductDTO dto) {
        if (dto == null) return null;
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .productType(dto.getProductType())
                .brand(dto.getBrand())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .deleted(false)
                .build();
    }

    public static void updateEntityFromDto(ProductDTO dto, Product entity) {
        if (dto.getName() != null) entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setProductType(dto.getProductType());
        entity.setBrand(dto.getBrand());
        entity.setPrice(dto.getPrice());
        entity.setStock(dto.getStock());
    }
}

