# Third-Party-PlatForm

一   微信公众号工具类使用方法
   1.  配置类 继承 com.github.sdcxy.wechat.config.WeChatConfig类
        ```
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
   