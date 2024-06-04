package fr.agadbin.search.tsvector;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query(value = "SELECT * FROM product p WHERE p.title_search_vector @@ plainto_tsquery('french', :search) OR p.title_search_vector @@ plainto_tsquery('english', :search) OR p.title ILIKE %:search% OR p.description ILIKE %:search% ORDER BY ts_rank(p.title_search_vector, plainto_tsquery('french', :search)) DESC, ts_rank(p.title_search_vector, plainto_tsquery('english', :search)) DESC", nativeQuery = true)
    List<Product> findBySearch(String search);
}
