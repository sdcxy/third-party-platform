package com.github.sdcxy.wechat.common.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.commons.lang3.StringUtils;

import java.io.Writer;

/**
 * @ClassName ParseXmlUtils
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 13:49
 **/
public class ParseXmlUtils {
    /**
    *  xstream扩展,bean转xml自动加上![CDATA[]]
    * @return
    */
    private static XStream getXStream(){
        return new XStream(new XppDriver(){
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out){
                    // 对所有xml节点都增加CDATA标记
                    boolean cdata = true;

                    @Override
                    public void startNode(String name, Class clazz) {
                        super.startNode(name, clazz);
                    }

                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
                        } else {
                            writer.write(text);
                        }
                    }
                };
            }
        });
    }


    /**
     *  bean 转换成xml
     * @param bean
     * @param <T>
     * @return
     */
    public static <T>  String beanToXml(T bean) {
        XStream xStream = getXStream();
        xStream.alias("xml",bean.getClass());
        xStream.processAnnotations(bean.getClass());
        String xml = xStream.toXML(bean);
        if (StringUtils.isNotEmpty(xml)){
            return xml;
        } else{
            return null;
        }
    }

    /**
     * xml转成bean泛型方法
     * @param xml
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T xmlToBean (String xml, Class<? extends Object> clazz){
        // XStream对象设置默认安全防护，同时设置允许的类
        XStream xStream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xStream);
        xStream.processAnnotations(clazz);
        xStream.alias("xml",clazz);
        return (T)xStream.fromXML(xml);
    }
}
