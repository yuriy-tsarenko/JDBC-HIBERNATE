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
public class ResponseDtoOne {

    private Integer code;

    private MetaDto meta;

    private UserDto user;

    @JsonCreator
    public ResponseDtoOne(
            @JsonProperty(value = "code") Integer code,
            @JsonProperty(value = "meta") MetaDto meta,
            @JsonProperty(value = "data") UserDto user) {
        this.code = code;
        this.meta = meta;
        this.user = user;
    }
}
