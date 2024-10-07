package com.mateus.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSeries (@JsonAlias("Title") String titulo,
                          @JsonAlias("totalSeasons") Integer totalTemporadas,
                          @JsonAlias("Year") String ano,
                          @JsonAlias("imdbRating") String avaliacao) {
}
