## 测试-swagger
- [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

## 上传文件到Minio
```
1.
切换到grpc-streamServerDemo.jar文件的当前目录
2.
执行curl
curl -X POST "http://localhost:8081/minio/upload" -H "accept: */*" -H "Content-Type: multipart/form-data" -F "file=@grpc-streamServerDemo.jar;type="
PS:此命令windows下有效
```

## 问题
- [多文件上传中上传文件大小的问题](https://blog.csdn.net/lehek/article/details/104576416)