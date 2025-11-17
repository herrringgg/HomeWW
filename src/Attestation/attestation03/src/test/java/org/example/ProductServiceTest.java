package org.example;

import org.example.dto.ProductDTO;
import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class ProductServiceTest {
    private ProductRepository repo;
    private ProductService service;

    @BeforeEach
    void setup() {
        repo = Mockito.mock(ProductRepository.class);
        service = new ProductService(repo);
    }

    @Test
    void testCreateProduct() {
        ProductDTO dto = new ProductDTO(null, "Board", "Desc", "SKATE", "Brand", 99.0, 5);
        when(repo.save(any(Product.class))).thenAnswer(i -> {
            Product p = i.getArgument(0);
            p.setId(1L);
            return p;
        });

        ProductDTO result = service.create(dto);

        assertNotNull(result.getId());
        assertEquals("Board", result.getName());
        verify(repo, times(1)).save(any());
    }

    @Test
    void testSoftDelete() {
        Product product = new Product();
        product.setId(1L);
        product.setDeleted(false);

        when(repo.findByIdAndDeletedFalse(1L)).thenReturn(Optional.of(product));

        boolean result = service.softDelete(1L);
        assertTrue(result);
        assertTrue(product.getDeleted());
    }
}
