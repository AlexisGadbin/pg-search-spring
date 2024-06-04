package fr.agadbin.search.phonetic_search;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.agadbin.search.common.Artist;

public interface ArtistPhoneticRepository extends JpaRepository<Artist, Integer> {

    @Query(value = "SELECT * FROM artists WHERE SOUNDEX(name) = SOUNDEX(:name)", nativeQuery = true)
    List<Artist> findByNamePhonetic(@Param("name") String name);

}
