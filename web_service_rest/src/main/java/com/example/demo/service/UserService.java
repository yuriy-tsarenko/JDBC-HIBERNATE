package com.example.demo.service;

import com.example.demo.dto.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

@Service
public class UserService {

    public Response loadInfo() {
        try {
            URL url = new URL("https://gorest.co.in/public-api/users");
            InputStream inputStream = url.openConnection().getInputStream();
            Scanner scanner = new Scanner(inputStream);
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine());
                builder.append("\n");
            }

            String json = builder.toString();
            System.out.println(json);
            Gson gson = new GsonBuilder().serializeNulls().create();
            return gson.fromJson(json, Response.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
