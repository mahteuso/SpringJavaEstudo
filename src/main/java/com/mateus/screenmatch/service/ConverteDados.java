package com.mateus.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {

    private ObjectMapper mapper = new ObjectMapper();

    public <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException {
        return mapper.readValue(json, classe);
    }
}
