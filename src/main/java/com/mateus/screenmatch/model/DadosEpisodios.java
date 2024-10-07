package com.mateus.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodios(@JsonAlias("Title") String titulo,
                             @JsonAlias("Year") String ano,

                             @JsonAlias("Season") String temporada,

                             @JsonAlias("Episode") String episodio,

                             @JsonAlias("Runtime") String tempoDuracao){
}
