package com.github.sdcxy.wechat.util;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.util.ParseXmlUtils;
import com.github.sdcxy.wechat.constant.MessageType;
import com.github.sdcxy.wechat.entity.message.event.*;
import com.github.sdcxy.wechat.entity.message.receive.*;
import com.github.sdcxy.wechat.entity.message.response.RespTextMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MessageUtils
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 10:52
 **/
public class MessageUtils {

    /**
     * xml 文本信息转换成map
     * @param request
     * @return
     */
    public static Map<String,Object> xmlToMap(HttpServletRequest request) {
        Map<String,Object> resultMap = new HashMap<>();
        try{
            SAXReader saxReader = new SAXReader();

            Document document = saxReader.read(request.getInputStream());
            System.out.println(document.asXML());
            // 获取根节点
            Element root = document.getRootElement();
            // 遍历根节点
            List<Element> elementList = root.elements();
            for (Element e: elementList) {
                resultMap.put(e.getName(), e.getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }


    /**
     *  默认的回复信息 如需修改 直接实现对应的消息接口 进行覆盖即可
     * @param FromUserName
     * @param ToUserName
     * @param object
     * @param <T>
     * @return
     */
    public static<T> String replyTextMessage(String FromUserName,String ToUserName,T object){
        RespTextMessage respTextMessage = JSON.parseObject(JSON.toJSONString(object), RespTextMessage.class);
        respTextMessage.setFromUserName(FromUserName);
        respTextMessage.setToUserName(ToUserName);
        respTextMessage.setMsgType(MessageType.text.toString());
        if (object.getClass().equals(VideoMessage.class)) {
            respTextMessage.setContent("这是视频回复");
        }
        if (object.getClass().equals(TextMessage.class)) {
            respTextMessage.setContent("这是文本回复");
        }
        if (object.getClass().equals(ImageMessage.class)) {
            respTextMessage.setContent("这是图片信息回复");
        }
        if (object.getClass().equals(VoiceMessage.class)) {
            respTextMessage.setContent("这是语音信息回复");
        }
        if (object.getClass().equals(LocationMessage.class)) {
            respTextMessage.setContent("这是地理信息回复");
        }
        if (object.getClass().equals(LinkMessage.class)) {
            respTextMessage.setContent("这是链接信息回复");
        }
        if (object.getClass().equals(SubscribeEvent.class)) {
            respTextMessage.setContent("感谢你的关注！！！");
        }
        if (object.getClass().equals(UnSubscribeEvent.class)) {
            respTextMessage.setContent(respTextMessage.getToUserName() + "取消了关注！！！");
        }
        if (object.getClass().equals(ScanEvent.class)) {
            respTextMessage.setContent("扫描二维码事件");
        }
        if (object.getClass().equals(LocationEvent.class)) {
            respTextMessage.setContent("上报地理位置事件");
        }
        if (object.getClass().equals(ClickMenuEvent.class)) {
            respTextMessage.setContent("点击菜单拉取消息事件");
        }
        if (object.getClass().equals(ViewMenuEvent.class)) {
            respTextMessage.setContent("点击菜单跳转事件");
        }
        //返回xml信息
        String xml = ParseXmlUtils.beanToXml(respTextMessage);
        System.out.println(xml);
        return xml;
    }
}
