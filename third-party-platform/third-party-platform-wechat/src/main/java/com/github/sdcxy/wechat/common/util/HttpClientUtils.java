package com.github.sdcxy.wechat.common.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HttpClientUtils
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/29 13:27
 **/
public class HttpClientUtils {


    /**
     *  无参Get请求
     * @param url
     * @param header
     * @param token
     * @return
     */
    public static String doGet(String url,String header,String token) {

        // 返回结果
        String resultStr = null;
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 声明GET请求
        HttpGet httpGet = new HttpGet(url);
        // 是否添加请求头token
        if (StringUtils.isNotEmpty(header) && StringUtils.isNotEmpty(token)){
            httpGet.setHeader(header,token);
        }
        CloseableHttpResponse response = null;
        try{
            response  = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                // 从响应模型中获取响应实体
                HttpEntity httpEntity = response.getEntity();
                // 返回响应内容
                resultStr =  EntityUtils.toString(httpEntity,"UTF-8");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(httpClient,response);
        }
        return resultStr;
    }

    /**
     *  带参Get请求
     * @param url
     * @param parameterMap
     * @param header
     * @param token
     * @return
     */
    public static String doGet(String url, Map<String,Object> parameterMap, String header, String token){
        String resultStr = null;
        try {
            // 封装 url参数
           URIBuilder uriBuilder = new URIBuilder(url);
            if (parameterMap != null) {
                for (Map.Entry<String,Object> entry:parameterMap.entrySet()) {
                    uriBuilder.setParameter(entry.getKey(),entry.getValue().toString());
                }
            }
            resultStr =  doGet(uriBuilder.build().toString(),header,token);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return resultStr;
    }

    /**
     *  发送post请求     * @param url
     * @param parameterMap
     * @param header
     * @param token
     * @return
     */
    public static String doPost(String url,Map<String,Object> parameterMap,String header,String token) {

        String resultStr = null;
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(url);

        CloseableHttpResponse response = null;

        if (StringUtils.isNotEmpty(header) && StringUtils.isNotEmpty(token)){
            httpPost.setHeader(header,token);
        }
        try{
            // 判断map是否为空，不为空则进行遍历，封装from表单对象
            if (parameterMap != null) {
                List<NameValuePair> valuePairs = new ArrayList<>();
                for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
                    valuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
                // 构造from表单对象
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(valuePairs, "UTF-8");
                // 把form 放到post
                httpPost.setEntity(urlEncodedFormEntity);

                // 发送请求
                response = httpClient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == 200) {
                    resultStr = EntityUtils.toString(response.getEntity(), "utf-8");
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(httpClient,response);
        }
        return resultStr;
    }

    public static String doPost(String url,String header,String token) {
        Map<String,Object> map = new HashMap<>();
        return doPost(url,map,null,null);
    }

    public static String doPost(String url,String parameJson,String header,String token) {
        String resultStr = null;
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(url);

        if (StringUtils.isNotEmpty(header) && StringUtils.isNotEmpty(token)){
            httpPost.setHeader(header,token);
        }
        CloseableHttpResponse response = null;
        try{
            StringEntity stringEntity = new StringEntity(parameJson);
            httpPost.setEntity(stringEntity);
            // 发送请求
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                resultStr = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultStr;
    }
    /**
     *  释放资源
     * @param httpClient
     * @param response
     */
    private static void close(CloseableHttpClient httpClient,CloseableHttpResponse response) {
        try{
            if (httpClient != null ) {
                httpClient.close();
            }
            if (response != null ) {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
