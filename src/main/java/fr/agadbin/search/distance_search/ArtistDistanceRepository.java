package fr.agadbin.search.distance_search;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.agadbin.search.common.Artist;

public interface ArtistDistanceRepository extends JpaRepository<Artist, Integer> {

    @Query(value = "SELECT * FROM artists ORDER BY levenshtein(name, :name) ASC LIMIT 10", nativeQuery = true)
    List<Artist> findByNameDistance(@Param("name") String name);
}
