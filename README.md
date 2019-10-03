# Third-Party-PlatForm

一   微信公众号工具类使用方法
   1.  配置类 继承 com.github.sdcxy.wechat.config.WeChatConfig类
        ```
            配置文件: application.yml
            weixin:
              appId: wxce9******767870
              appSecret: 9********8339
              token: ****
              wechat: ***********
        ```
        ```
            @Configuration
            @ConfigurationProperties(prefix = "weixin")
            public class WeiXinConfig extends com.github.sdcxy.wechat.config.WeChatConfig {
            
            }   
        ```
   2. 接入方法: com.github.sdcxy.wechat.service.impl.WeChatServiceImpl 的weChatIn
        ```
            @Autowired
            private WeiXinConfig weiXinConfig;
                
            @GetMapping(value = "/wechat/in")
            @ResponseBody
            public String WeChatIn(String signature,String timestamp,String nonce,String echostr ){
                WeChatServiceImpl weChatService = new WeChatServiceImpl();
                SignatureConfig signatureConfig = new SignatureConfig(signature,timestamp,nonce,echostr);
                return weChatService.weChatIn(signatureConfig, weiXinConfig.getToken());
            }
           
        ```
   3.  响应消息方法: com.github.sdcxy.wechat.service.impl.WeChatServiceImpl 的weChatCallBack
        ```
            @PostMapping(value = "/wechat/in")
            @ResponseBody
            public String WeChatOut(HttpServletRequest request) {
                WeChatServiceImpl weChatService = new WeChatServiceImpl();
                return weChatService.weChatCallBack(request, weiXinConfig.getToken());
            }
        ```
   4.   消息响应类处理; com.github.sdcxy.wechat.service.impl.MessageServiceImpl
        ```$xslt
            实现那种消息回复，直接实现对应消息类的接口的parseXXXMessage方法即可（XXX之接口类）
            文本消息: Text 接口 
            图片消息: Image 接口
            语音消息: Voice 接口
            视频消息: Video 接口
            短视频消息: ShortVideo 接口
            地理消息: Location 接口
            链接消息: Link 接口     
        ```