package com.mateus.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSeriado (@JsonAlias("Title") String titulo,
                           @JsonAlias("Season") String temporada,
                           @JsonAlias("Episodes") List<DadosTemporada> episodios){
}
