package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VolumeInfo {

    @JsonProperty("title")
    public String titulo;

    @JsonProperty("authors")
    public List<String> autores;

    @JsonProperty("pageCount")
    public int numeroPaginas;

    @JsonProperty("industryIdentifiers")
    public List<IndustryIdentifier> identificadores;

    public String getIsbn() {
        if (identificadores != null) {
            for (IndustryIdentifier id : identificadores) {
                if ("ISBN_13".equals(id.type)) {
                    return id.identifier;
                }
            }
            for (IndustryIdentifier id : identificadores) {
                if ("ISBN_10".equals(id.type)) {
                    return id.identifier;
                }
            }
        }
        return "ISBN não encontrado";
    }
}

