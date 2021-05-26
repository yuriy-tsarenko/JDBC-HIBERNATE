package com.example.demo.dto;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class MetaDto {

    private PaginationDto pagination;

    @JsonCreator
    private MetaDto(@JsonProperty(value = "pagination") PaginationDto pagination) {
        this.pagination = pagination;
    }
}
