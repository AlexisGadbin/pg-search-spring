package fr.agadbin.search.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "artists")
@NoArgsConstructor
public class Artist {

    @Id
    private Integer artistId;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String nationality;

    @Column(nullable = true)
    private String gender;

    @Column(nullable = true)
    private Integer birthYear;

    @Column(nullable = true)
    private Integer deathYear;
}
