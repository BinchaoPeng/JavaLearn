# JavaEE认识

> https://www.liaoxuefeng.com/wiki/1252599548343744/1255945497738400

JavaEE：JavaEE是Java Platform Enterprise Edition的缩写，即Java企业平台。--------------------------------------**基于JavaSE，只是多了一大堆服务器相关的库以及API接口**

JavaSE：基于标准JDK的开发都是JavaSE，即Java Platform Standard Edition-----------------------------**基于标准JDK的开发**

JavaME：Java Platform Micro Edition，是Java移动开发平台（非Android）------------------------**一个裁剪后的“微型版”JDK，基本不用可以忽略**

****

JavaEE并不是一个软件产品，它更多的是一种软件架构和设计思想。我们可以把JavaEE看作是在JavaSE的基础上，开发的一系列基于服务器的组件、API标准和通用架构。

JavaEE

- JavaSE
- Web Server（基于Servlet标准）
  - Servlet API
  - User App



# Web基础

> https://www.liaoxuefeng.com/wiki/1252599548343744/1304265903570978

Browser/Server模式，简称BS架构

基本过程是：

浏览器请求一个URL，服务器就把生成的HTML网页发送给浏览器，而浏览器和服务器之间的传输协议是HTTP。浏览器根据网页的url继续请求获取网页需要的资源，比如图片等

HTTP协议是一个基于TCP协议之上的请求-响应协议



也就是说，本质是一个TCP连接，然后根据HTTP协议的规定，处理交互的内容，就是分析HTTP body 和 header，实现就是使用`ServeSocket`



而HTML网页浏览器会自己解析，因此我们只要保证通信、负责传输HTML内容到客户端本地就行



# Servlet入门

> https://www.liaoxuefeng.com/wiki/1252599548343744/1304265949708322

为了提高效率，程序员只要注重自己的业务逻辑就行，其他的底层工作都交给`Web Server`去执行，也即是我们只需要把自己的应用程序跑在Web服务器上

这中间的桥梁就是：Servlet API

JavaEE提供了Servlet API，我们使用Servlet API编写自己的Servlet来处理HTTP请求，Web服务器实现Servlet API接口，实现底层功能



一个Servlet总是继承自`HttpServlet`，然后覆写`doGet()`或`doPost()`方法。



Servlet API是一个jar包，我们需要通过Maven来引入它，才能正常编译



打包类型不是`jar`，而是`war`，表示Java Web Application Archive







