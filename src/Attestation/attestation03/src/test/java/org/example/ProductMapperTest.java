package org.example;

import org.example.dto.ProductDTO;
import org.example.entity.Product;
import org.example.util.ProductMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductMapperTest {
    @Test
    void testToDto() {
        Product product = Product.builder()
                .id(1L)
                .name("Test")
                .price(10.0)
                .stock(3)
                .build();

        ProductDTO dto = ProductMapper.toDto(product);
        assertEquals("Test", dto.getName());
        assertEquals(10.0, dto.getPrice());
    }

    @Test
    void testToEntity() {
        ProductDTO dto = new ProductDTO(1L, "Test", "Desc", "SURF", "Brand", 15.0, 5);
        Product entity = ProductMapper.toEntity(dto);
        assertEquals("Test", entity.getName());
        assertFalse(entity.getDeleted());
    }
}
