[TOC]

# idea使用Junit

对项目使用Junit主要有两个步骤：

- 添加Junit依赖，即添加Junit jar包
- 使用Junit



**方法一**：idea自带的快捷方法

对要测试的类的方法，在该类中，右键鼠标呼出菜单，选择`Generate`，快捷键是`Alt+Insert`

选择`Test`选项，对应如下：

![image-20230412231616918](images/image-20230412231616918.png)

这步之前可能会说你缺少Junit依赖，因此点击默认安装即可，默认会下载在项目的lib目录下，可能要自己手动添加一下依赖才会生效。添加方式见方法二。

对应的依赖有(我的java版本是1.8)：

```bash
apiguardian-api-1.1.2.jar
junit-jupiter-5.8.1.jar
junit-jupiter-api-5.8.1.jar
junit-jupiter-engine-5.8.1.jar
junit-jupiter-params-5.8.1.jar
junit-platform-commons-1.8.1.jar
junit-platform-engine-1.8.1.jar
opentest4j-1.2.0.jar
```



**方法二**：自己添加依赖并手动写

首先下载jar包，点击`jar`位置即可下载

新版的Junit在这里：https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api

旧版的Junit在这里：https://mvnrepository.com/artifact/junit/junit（旧版有到新版的传送门）

![image-20230412231939140](images/image-20230412231939140.png)

其次，在项目中添加依赖，依赖在项目栏的` External Libraries`这个位置，选中**红色箭头**位置，按`F4`可以快捷进入。

或者，依次点击`File`、`Project Structure`、`Libraries`，进入设置。

![image-20230412232404529](images/image-20230412232404529.png)

选择中间栏的`+`按钮进入jar包所在目录添加jar包。