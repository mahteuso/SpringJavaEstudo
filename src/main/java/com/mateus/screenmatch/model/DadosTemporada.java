package com.mateus.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada (@JsonAlias("Title") String titulo,
                             @JsonAlias("Released") String data,

                             @JsonAlias("Episode") String episodio,

                             @JsonAlias("imdbRating") String nota) {
}
