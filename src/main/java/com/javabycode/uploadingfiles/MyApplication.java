package com.javabycode.uploadingfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) throws IOException {
        new File(UploadController.uploadDir).mkdirs();
        SpringApplication.run(MyApplication.class, args);
    }
}