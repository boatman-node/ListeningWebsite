package com.Service.impl;

import com.Service.Minio;
import com.enumerate.filetype;
import com.pool.PathTool;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@Service
public class MinioImpl implements Minio {
    private static final String Host="http://120.55.74.29:9000/";
    @Value("${minio.bucket}")
    String bucketName;
    @Autowired
    MinioClient minioClient;
    @Override
    public String MinioPath(MultipartFile file) {
        String allpath=null;
        InputStream inputStream = null;
        String contentType=null;
        System.out.println(contentType);
        try {
            inputStream = file.getInputStream();
            String getPath = PathTool.GETPath();
            String originalFilename = file.getOriginalFilename();
            contentType = file.getContentType();
            allpath = getPath +"."+originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            System.out.println(allpath);
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object(contentType+allpath) //文件名词
                    .contentType(contentType) //文件类型
                    .bucket(bucketName) //桶名称  与minio管理界面创建的桶一致即可
                    .stream(inputStream,inputStream.available(),-1).build();
            minioClient.putObject(putObjectArgs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Host+bucketName+"/"+contentType+allpath;
     }
}
