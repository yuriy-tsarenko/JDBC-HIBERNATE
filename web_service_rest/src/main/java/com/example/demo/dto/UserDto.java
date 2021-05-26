package com.example.demo.dto;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Integer id;

    private String name;

    private String email;

    private String gender;

    private String status;

    private Date createdAt;

    private Date updatedAt;

    @JsonCreator
    public UserDto(@JsonProperty(value = "id") Integer id,
                   @JsonProperty(value = "name") String name,
                   @JsonProperty(value = "email") String email,
                   @JsonProperty(value = "gender") String gender,
                   @JsonProperty(value = "status") String status,
                   @JsonProperty(value = "created_at") Date createdAt,
                   @JsonProperty(value = "updated_at") Date updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
