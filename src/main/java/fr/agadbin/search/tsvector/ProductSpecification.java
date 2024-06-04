package fr.agadbin.search.tsvector;

import java.time.Instant;

import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<Product> search(String search) {
        return (root, query, cb) -> {
            if (search == null || search.isBlank())
                return null;

            return cb.isTrue(
                    cb.function(
                            "tsvector_match",
                            Boolean.class,
                            root.get("titleSearchVector"),
                            cb.function("plainto_tsquery", String.class, cb.literal(search))));
        };
    }

    public static Specification<Product> createdAtFrom(Instant createdAtFrom) {
        return (root, query, cb) -> createdAtFrom == null ? null
                : cb.greaterThanOrEqualTo(root.get("createdAt"), createdAtFrom);
    }

    public static Specification<Product> createdAtTo(Instant createdAtTo) {
        return (root, query, cb) -> createdAtTo == null ? null
                : cb.lessThanOrEqualTo(root.get("createdAt"), createdAtTo);
    }
}
