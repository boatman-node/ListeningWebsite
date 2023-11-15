package com.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface Minio {
    String MinioPath(MultipartFile file);
}
