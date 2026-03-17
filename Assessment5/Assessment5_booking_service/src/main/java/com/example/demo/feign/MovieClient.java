package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "movie-service")
public interface MovieClient {

    @GetMapping("/movies/{id}")
    Map<String, Object> getMovie(@PathVariable Long id);

}