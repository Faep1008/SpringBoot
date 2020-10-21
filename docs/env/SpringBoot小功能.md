# SpringBoot小功能

## 修改SpringBoot 默认的小叶子图标
Springboot 项目，在浏览器中访问时，浏览器上导航栏的图标是一片绿色的叶子，可以修改。  
将格式为`.ico`的图片放入以下任一项目文件夹即可。但，图片命名必须为`favicon.ico`  
```
1、类路径 根目录 下
2、类路径 META-INF/resources/下
3、类路径 resources/下
4、类路径 static/下
5、类路径 public/下
```

## 修改SpringBoot启动flag
在`resources`目下新建 `banner.txt` 文件，放入flag文字  

```
http://patorjk.com/software/taag
```