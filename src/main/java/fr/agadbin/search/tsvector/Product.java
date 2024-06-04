package fr.agadbin.search.tsvector;

import java.time.Instant;

import org.hibernate.annotations.Type;

import io.hypersistence.utils.hibernate.type.search.PostgreSQLTSVectorType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(ProductListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Instant createdAt;
    @Type(PostgreSQLTSVectorType.class)
    @Column(columnDefinition = "tsvector", name = "title_search_vector")
    private String titleSearchVector;
}
