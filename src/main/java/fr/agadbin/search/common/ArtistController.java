package fr.agadbin.search.common;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.agadbin.search.trigram_search.ArtistTrigramService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistTrigramService artistTrigramService;

    @GetMapping("/trigram")
    public List<Artist> search(@RequestParam(required = false, value = "q") String query) {
        return artistTrigramService.search(query);
    }
}
