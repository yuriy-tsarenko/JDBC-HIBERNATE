package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {

    private Integer code;

    private MetaDto meta;

    private List<UserDto> users;

    @JsonCreator
    public ResponseDto(
            @JsonProperty(value = "code") Integer code,
            @JsonProperty(value = "meta") MetaDto meta,
            @JsonProperty(value = "data") List<UserDto> users) {
        this.code = code;
        this.meta = meta;
        this.users = users;
    }
}
