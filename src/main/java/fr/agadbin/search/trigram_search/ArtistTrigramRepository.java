package fr.agadbin.search.trigram_search;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.agadbin.search.common.Artist;

public interface ArtistTrigramRepository extends JpaRepository<Artist, Integer> {

    @Query(value = "SELECT * FROM artists WHERE SIMILARITY(name, :name) > 0.2 ORDER BY SIMILARITY(name, :name) DESC LIMIT 10", nativeQuery = true)
    List<Artist> findByNameSimilarity(@Param("name") String name);
}
