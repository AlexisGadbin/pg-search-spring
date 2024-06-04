package fr.agadbin.search.tsvector;

import java.time.Instant;

import lombok.Getter;

@Getter
public class ProductDto {
    private final Long id;
    private final String title;
    private final Instant createdAt;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.createdAt = product.getCreatedAt();
    }
}
