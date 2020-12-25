package com.yzd;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.SneakyThrows;

import java.io.InputStream;

/**
 * @Author: yaozh
 * @Description:
 */
public class MiniUtil {
    @SneakyThrows(Exception.class)
    public static void uploadFile(MinioClient minioClient, String bucketName,
                                  String fileName, InputStream inputStream) {
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(fileName)
                .stream(inputStream, -1, 10485760).build());
    }

    /**
     * 创建 bucket
     */
    @SneakyThrows(Exception.class)
    public static void createBucket(MinioClient minioClient, String bucketName) {
        boolean isExist = bucketExists(minioClient, bucketName);
        if (!isExist) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    @SneakyThrows(Exception.class)
    public static boolean bucketExists(MinioClient minioClient, String bucketName) {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }
}
