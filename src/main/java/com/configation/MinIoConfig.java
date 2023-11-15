package com.configation;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinIoConfig {
    /**
     * 访问密钥
     */
    @Value("${minio.accesskey}")
    private String accessKey;

    /**
     * 密钥
     */
    @Value("${minio.secretKey}")
    private String secretKey;

    /**
     * 访问api Url
     */
    @Value("${minio.endpoint}")
    private String endpoint;

    /**
     * 捅名称
     */
    @Value("${minio.bucket}")
    private String bucketName;

    /**
     * 创建MinIo客户端
     *
     * @return
     */
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().credentials(accessKey,secretKey).endpoint(endpoint).build();
    }
}
