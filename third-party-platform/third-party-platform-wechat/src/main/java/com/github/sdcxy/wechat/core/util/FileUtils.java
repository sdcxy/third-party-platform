package com.github.sdcxy.wechat.core.util;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.wechat.core.exception.GlobalException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;

/**
 * @ClassName FileUtils
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/6 12:49
 **/
public class FileUtils {

    public static void download(String url,String filePath,String fileName){
            CloseableHttpResponse response = null;
            // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();

            // 声明GET请求
            HttpGet httpGet = new HttpGet(url);

            try{
                response  = httpClient.execute(httpGet);
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    // 从响应模型中获取响应实体
                    HttpEntity httpEntity = response.getEntity();
                    String contentType = httpEntity.getContentType().getValue();
                    String type = contentType.substring(contentType.indexOf("/") + 1);
                    if (contentType.equals("image/jpeg")|| contentType.equals("image/gif") || contentType.equals("image/png")){
                        // 图片处理
                        saveImageFile(httpEntity,filePath,fileName,type);
                    }
                    if (contentType.equals("text/plain")){
                        // 视频处理
                        saveVideo(httpEntity,filePath,fileName,type);
                    }
                    if (contentType.equals("voice/speex") || contentType.equals("audio/amr")){
                        // 语音处理
                        saveVoice(httpEntity,filePath,fileName,type);
                    }
                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static void download(String url,String json,String filePath,String fileName){
        CloseableHttpResponse response = null;
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(url);
        try{
            StringEntity stringEntity = new StringEntity(json);
            httpPost.setEntity(stringEntity);
            response  = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 从响应模型中获取响应实体
                Header header = response.getFirstHeader("Content-Disposition");
                if (header != null) {
                    String name = header.getValue();
                    HttpEntity httpEntity = response.getEntity();
                    if (StringUtils.isNotEmpty(fileName)) {
                        String type = name.substring(name.indexOf(".") + 1,name.length()-1);
                        fileName = fileName + "." + type;
                    }else {
                        fileName = name.substring(name.indexOf("=") + 2,name.length()-1);
                    }
                    saveFile(httpEntity,filePath,fileName);
                } else {
                    throw new GlobalException(-1,"微信下载素材文件失败");
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveFile(HttpEntity entity,String filePath,String name){
        String fileName = filePath + "/"+ name;
        try {
            InputStream is = entity.getContent();
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            save(is,file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void saveImageFile(HttpEntity entity,String filePath,String name,String type){
            String fileName = filePath + "/"+ name + "."+ type;
            try {
                File file = new File(fileName);
                if(!file.exists()){
                    file.createNewFile();
                }
                InputStream is = entity.getContent();
                save(is,file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void saveVideo(HttpEntity entity,String filePath,String name,String type){
            String fileName = filePath + "/"+ name + "." + type;
            try{
                File file = new File(fileName);
                if(!file.exists()){
                    file.createNewFile();
                }
                String result = EntityUtils.toString(entity,"UTF-8");
                String video_url = JSON.parseObject(result).getString("video_url");

                CloseableHttpResponse response = null;
                // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                // 声明GET请求
                HttpGet httpGet = new HttpGet(video_url);

                response  = httpClient.execute(httpGet);
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity httpEntity = response.getEntity();
                    InputStream is = httpEntity.getContent();
                    save(is,file);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void saveVoice(HttpEntity entity,String filePath,String name,String type){
            String fileName = filePath + "/"+ name + "." + type;
            try {
                File file = new File(fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
                InputStream is = entity.getContent();
                save(is,file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void save(InputStream is,File file){

            try {
                OutputStream os = new FileOutputStream(file);
                int bytesRead = 0;
                byte[] buffer = new byte[4096];
                while ((bytesRead = is.read(buffer, 0, 4096)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                os.flush();
                os.close();
                is.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
