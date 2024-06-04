package fr.agadbin.search.trigram_search;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.agadbin.search.common.Artist;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ArtistTrigramService {

    private final ArtistTrigramRepository artistTrigramRepository;

    public List<Artist> search(String query) {
        return artistTrigramRepository.findByNameSimilarity(query);
    }
}
