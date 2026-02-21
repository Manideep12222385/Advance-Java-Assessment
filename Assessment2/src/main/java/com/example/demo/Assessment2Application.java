package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Assessment2Application {

    public static void main(String[] args) {

    	ConfigurableApplicationContext context =SpringApplication.run(Assessment2Application.class, args);

        StorageService storageService = context.getBean(StorageService.class);
        storageService.storeFile("Marks.pdf");
        
        StorageService local1 = context.getBean("localStorage",StorageService.class);
        local1.storeFile("Selfie.png");

        StorageService local2 =(StorageService) context.getBean("localStorage",StorageService.class);
        local2.storeFile("Wallpaper.png");
        
        context.close();
    }
}