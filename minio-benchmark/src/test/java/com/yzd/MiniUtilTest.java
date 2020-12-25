package com.yzd;


import cn.hutool.core.io.IoUtil;
import io.minio.MinioClient;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: yaozh
 * @Description:
 */
public class MiniUtilTest {

    MinioClient minioClient = MinioClient.builder()
            .endpoint("http://192.168.56.112:9000")
            .credentials("minioadmin", "minioadmin")
            .build();
    String bucketName = "abc";
    AtomicLong i = new AtomicLong(0);

    /**
     * install minio
     * https://min.io/download#/linux
     * <p>
     * minio 的处理性能不是很好。 byArvin
     *
     * @throws IOException
     */
    @Test
    public void uploadFile() throws IOException {
        for (int j = 0; j < 10000; j++) {
            ByteArrayInputStream hello = null;
            try {
                hello = IoUtil.toStream("hello", Charset.defaultCharset());
                MiniUtil.uploadFile(minioClient, bucketName, String.valueOf(i.getAndIncrement()), hello);
            } catch (Exception ex) {
                if (hello != null) {
                    hello.close();
                }
                throw ex;
            }
        }
    }
}