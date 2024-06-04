package fr.agadbin.search.phonetic_search;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.agadbin.search.common.Artist;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ArtistPhoneticService {

    private final ArtistPhoneticRepository artistPhoneticRepository;

    public List<Artist> search(String query) {
        return artistPhoneticRepository.findByNamePhonetic(query);
    }
}
