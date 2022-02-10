# umeng-upload-symbol

**友盟API上传符号表工具**

符号表生成方式请参考友盟官方文档

[友盟网官方文档地址](https://developer.umeng.com/docs/193624/detail/194577)

### 项目说明
umeng-upload-symbol 工具源码
release.zip 编译生成后的工具(可直接使用)



### 使用方法

```
java -jar umeng-upload-symbol.jar \
                -appkey 1801000 \
                -seckey XXXXXXX \
                -sourceid 6087772f9e3333b6f6664a21 \
                -type 3 \
                -version 1.0.0 \
                -symbolfile ./symbol.zip
```


### 参数说明

|参数|说明|
|:-|:-|
|-appkey|OpenApi 生成的 appKey|
|-appkey|OpenApi 生成的 secKey|
|-sourceid|友盟统计 App项目 的appKey|
|-type|文件类型(1 mapping文件；2 so文件；3 dSYM文件压缩包)|
|-version|App版本号|
|-symbolfile|本地符号表文件地址|