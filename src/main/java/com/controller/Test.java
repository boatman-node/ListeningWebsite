package com.controller;

import com.Service.impl.MinioImpl;
import com.enumerate.filetype;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class Test {
    @Autowired
    MinioClient minioClient;
    @Autowired
    MinioImpl minio;
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        System.out.println(file.getContentType());
        return minio.MinioPath(file);

    }
}
