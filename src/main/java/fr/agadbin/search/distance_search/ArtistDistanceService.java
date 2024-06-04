package fr.agadbin.search.distance_search;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.agadbin.search.common.Artist;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ArtistDistanceService {

    private final ArtistDistanceRepository artistDistanceRepository;

    public List<Artist> search(String name) {
        return artistDistanceRepository.findByNameDistance(name);
    }
}
