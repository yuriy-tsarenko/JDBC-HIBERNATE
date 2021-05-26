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
public class PaginationDto {

    private Integer total;

    private Integer pages;

    private Integer page;

    private Integer limit;

    @JsonCreator
    public PaginationDto(@JsonProperty(value = "total") Integer total,
                         @JsonProperty(value = "pages") Integer pages,
                         @JsonProperty(value = "page") Integer page,
                         @JsonProperty(value = "limit") Integer limit) {
        this.total = total;
        this.pages = pages;
        this.page = page;
        this.limit = limit;
    }
}

