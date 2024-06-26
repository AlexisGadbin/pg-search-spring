package fr.agadbin.search.common;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.agadbin.search.distance_search.ArtistDistanceService;
import fr.agadbin.search.phonetic_search.ArtistPhoneticService;
import fr.agadbin.search.trigram_search.ArtistTrigramService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistTrigramService artistTrigramService;
    private final ArtistPhoneticService artistPhoneticService;
    private final ArtistDistanceService artistDistanceService;

    @GetMapping("/trigram")
    public List<Artist> search(@RequestParam(required = false, value = "q") String query) {
        return artistTrigramService.search(query);
    }

    @GetMapping("/phonetic")
    public List<Artist> searchPhonetic(@RequestParam(required = false, value = "q") String query) {
        return artistPhoneticService.search(query);
    }

    @GetMapping("/distance")
    public List<Artist> searchDistance(@RequestParam(required = false, value = "q") String query) {
        return artistDistanceService.search(query);
    }
}
