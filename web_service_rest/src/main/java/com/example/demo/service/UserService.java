package com.example.demo.service;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.ResponseDtoOne;
import com.example.demo.dto.UserDto;
import com.example.demo.proxy.Proxy;
import com.example.demo.proxy.ProxyFactory;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;


@Service
@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
public class UserService {

    @Value("${api.token}")
    private String token;

    @Value("${base.url}")
    private String baseUrl;

    private static final String TOKEN_PREFIX = "Bearer ";

    private final ProxyFactory proxyFactory;

    public ResponseEntity<List<UserDto>> getAllUsers() {
        Proxy proxy = proxyFactory.getProxy(baseUrl);
        Response response = proxy.getAll();
        if (response.getStatus() != HttpStatus.SC_OK) {
            return ResponseEntity.status(response.getStatus()).build();
        }
        ResponseDto responseDto = response.readEntity(ResponseDto.class);
        return ResponseEntity.ok()
                .body(responseDto.getUsers());
    }

    public ResponseEntity<UserDto> getUserById(Integer id) {
        Proxy proxy = proxyFactory.getProxy(baseUrl);
        Response response = proxy.getById(id, TOKEN_PREFIX + token);
        if (response.getStatus() != HttpStatus.SC_OK) {
            return ResponseEntity.status(response.getStatus()).build();
        }
        ResponseDtoOne responseDto = response.readEntity(ResponseDtoOne.class);
        return ResponseEntity.ok()
                .body(responseDto.getUser());
    }

    public ResponseEntity<UserDto> createUser(UserDto dto) {
        Proxy proxy = proxyFactory.getProxy(baseUrl);
        Response response = proxy.create(dto, TOKEN_PREFIX + token);
        if (response.getStatus() != HttpStatus.SC_OK) {
            return ResponseEntity.status(response.getStatus()).build();
        }
        ResponseDtoOne responseDto = response.readEntity(ResponseDtoOne.class);
        return ResponseEntity.ok().body(responseDto.getUser());
    }

    public ResponseEntity<UserDto> updateUser(Integer id, UserDto dto) {
        Proxy proxy = proxyFactory.getProxy(baseUrl);
        Response response = proxy.update(id, dto, TOKEN_PREFIX + token);
        if (response.getStatus() != HttpStatus.SC_OK) {
            return ResponseEntity.status(response.getStatus()).build();
        }
        ResponseDtoOne responseDto = response.readEntity(ResponseDtoOne.class);
        return ResponseEntity.ok().body(responseDto.getUser());
    }

    public ResponseEntity<?> deleteUser(Integer id) {
        Proxy proxy = proxyFactory.getProxy(baseUrl);
        Response response = proxy.delete(id, TOKEN_PREFIX + token);
        if (response.getStatus() != HttpStatus.SC_NO_CONTENT) {
            return ResponseEntity.status(response.getStatus()).build();
        }
        return ResponseEntity.ok().build();
    }
}
