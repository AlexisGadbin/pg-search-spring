package fr.agadbin.search.tsvector;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDto> getAll(String filter) {
        List<Product> products = productRepository.findBySearch(filter);

        return products.stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }
}
