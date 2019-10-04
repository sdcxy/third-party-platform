# Third-Party-PlatForm

一   微信公众号工具类使用方法
   1.   pom 文件添加依赖
        ```$xslt
            <dependency>
                <groupId>com.github.sdcxy</groupId>
                <artifactId>third-party-platform-wechat</artifactId>
                <version>0.0.1</version>
            </dependency>
        ```
   2.  配置类 application.yml 配置文件配置
        ```
         third-party-platform:
           wechat:
             enabled: true
             app-id: wxce9****1767870
             app-secret: 991c******18c526e25508488339
             token: l**
             wechat: gh*****c0432c
        ```
   3. 接入方法: com.github.sdcxy.wechat.service.impl.WeChatServiceImpl 的weChatIn
        ```
            @Autowired
            private WeChatService weChatService;
        
            @GetMapping(value = "/wechat/in")
            @ResponseBody
            public String WeChatIn(String signature,String timestamp,String nonce,String echostr ){
                SignatureConfig signatureConfig = new SignatureConfig(signature,timestamp,nonce,echostr);
                return weChatService.weChatIn(signatureConfig);
            }
           
        ```
   4.  响应消息方法: com.github.sdcxy.wechat.service.impl.WeChatServiceImpl 的weChatCallBack
        ```
            @PostMapping(value = "/wechat/in")
            @ResponseBody
            public String WeChatOut(HttpServletRequest request) {
                return weChatService.weChatCallBack(request);
            }
        ```
   5.   消息响应类处理: com.github.sdcxy.wechat.service.impl.MessageServiceImpl
        ```$xslt
            实现那种消息回复，直接实现对应消息类的接口的parseXXXMessage方法即可（XXX之接口类）
            文本消息: Text 接口 
            图片消息: Image 接口
            语音消息: Voice 接口
            视频消息: Video 接口
            短视频消息: ShortVideo 接口
            地理消息: Location 接口
            链接消息: Link 接口     
            .....event 事件处理方法与消息处理方法一致。详细请查看源码
        ```