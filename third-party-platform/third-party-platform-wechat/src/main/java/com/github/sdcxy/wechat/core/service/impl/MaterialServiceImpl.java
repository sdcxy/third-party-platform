package com.github.sdcxy.wechat.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.wechat.common.util.HttpClientUtils;
import com.github.sdcxy.wechat.core.constants.Constants;
import com.github.sdcxy.wechat.core.constants.FileType;
import com.github.sdcxy.wechat.core.constants.UrlConstants;
import com.github.sdcxy.wechat.core.entity.material.*;
import com.github.sdcxy.wechat.core.entity.material.list.NewsMaterialList;
import com.github.sdcxy.wechat.core.entity.material.list.OtherTypeMaterialList;
import com.github.sdcxy.wechat.core.entity.material.list.QueryMaterial;
import com.github.sdcxy.wechat.core.exception.MaterialException;
import com.github.sdcxy.wechat.core.service.MaterialService;
import com.github.sdcxy.wechat.core.util.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MaterialServiceImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/6 1:32
 **/
@Service
public class MaterialServiceImpl implements MaterialService {

    @Override
    public Material addTemporaryMaterial(String filePath, String accessToken, String fileType) {
        String url = UrlConstants.POST_ADD_TEMPORARY_MATERIAL
                                .replace(Constants.ACCESS_TOKEN,accessToken)
                                .replace(Constants.TYPE,fileType);
        Map<String,Object> parameterMap = new HashMap<>();
        parameterMap.put(Constants.MEDIA,filePath);
        String result =  HttpClientUtils.doPost(url, parameterMap);
        return (Material) defaultReturn(result,Material.class);
    }

    @Override
    public void getTemporaryMaterial(String accessToken, String mediaId,String saveFilePath,String fileName) {
        String url = UrlConstants.GET_GET_TEMPORARY_MATERIAL
                .replace(Constants.ACCESS_TOKEN,accessToken)
                .replace(Constants.MEDIA_ID,mediaId);
        if (StringUtils.isNotEmpty(fileName)){
            FileUtils.download(url,saveFilePath,fileName);
        }else{
            FileUtils.download(url,saveFilePath,mediaId);
        }
    }

    @Override
    public Material uploadPermanentNewsMaterial(NewsMaterial material, String accessToken) {
        String url = UrlConstants.POST_ADD_PERMANENT_NEWS_MATERIAL
                                .replace(Constants.ACCESS_TOKEN,accessToken);
        String json = JSON.toJSONString(material);
        String result = HttpClientUtils.doPost(url,json,null,null);
        return (Material) defaultReturn(result,Material.class);
    }

    @Override
    public String uploadNewsMessageUrl(String fileName, String accessToken) {
        String url = UrlConstants.POST_ADD_PERMANENT_NEWS_IMAGE_GET_URL
                                .replace(Constants.ACCESS_TOKEN,accessToken);
        Map<String,Object> parameterMap = new HashMap<>();
        parameterMap.put(Constants.MEDIA,fileName);
        String result = HttpClientUtils.doPost(url,parameterMap);
        return (String) defaultReturn(result,null);
    }

    @Override
    public Material uploadImageMaterial(String fileName, String accessToken) {
        String url = UrlConstants.POST_ADD_PERMANENT_OTHER_MATERIAL
                                    .replace(Constants.ACCESS_TOKEN,accessToken)
                                    .replace(Constants.TYPE, FileType.IMAGE);
        Map<String,Object> parameterMap = new HashMap<>();
        parameterMap.put(Constants.MEDIA,fileName);
        return uploadMaterial(url,parameterMap);
    }

    @Override
    public Material uploadVoiceMaterial(String fileName, String accessToken) {
        String url = UrlConstants.POST_ADD_PERMANENT_OTHER_MATERIAL
                .replace(Constants.ACCESS_TOKEN,accessToken)
                .replace(Constants.TYPE, FileType.VOICE);
        Map<String,Object> parameterMap = new HashMap<>();
        parameterMap.put(Constants.MEDIA,fileName);
        return uploadMaterial(url,parameterMap);
    }

    @Override
    public Material uploadThumbMaterial(String fileName, String accessToken) {
        String url = UrlConstants.POST_ADD_PERMANENT_OTHER_MATERIAL
                .replace(Constants.ACCESS_TOKEN,accessToken)
                .replace(Constants.TYPE, FileType.THUMB);
        Map<String,Object> parameterMap = new HashMap<>();
        parameterMap.put(Constants.MEDIA,fileName);
        return uploadMaterial(url,parameterMap);
    }

    @Override
    public Material uploadVideoMaterial(String fileName, String accessToken, VideoMaterialDescription description) {
        String url = UrlConstants.POST_ADD_PERMANENT_OTHER_MATERIAL
                .replace(Constants.ACCESS_TOKEN,accessToken)
                .replace(Constants.TYPE, FileType.VIDEO);
        Map<String,Object> parameterMap = new HashMap<>();
        parameterMap.put(Constants.MEDIA,fileName);
        parameterMap.put(Constants.DESCRIPTION,JSON.toJSONString(description));
        return uploadMaterial(url,parameterMap);
    }

    @Override
    public ReturnNewsMaterial getNewsMaterial(String accessToken, String mediaId) {
        String url = UrlConstants.POST_GET_PERMANENT_MATERIAL.replace(Constants.ACCESS_TOKEN,accessToken);
        Map<String,Object> parameterMap = new HashMap<>();
        parameterMap.put(Constants.media_id,mediaId);
        String result = HttpClientUtils.doPost(url,JSON.toJSONString(parameterMap),null,null);
        return (ReturnNewsMaterial) defaultReturn(result,ReturnNewsMaterial.class);
    }

    @Override
    public VideoMaterial getVideoMaterial(String accessToken, String mediaId) {
        Map<String,Object> parameterMap = new HashMap<>();
        String url = UrlConstants.POST_GET_PERMANENT_MATERIAL.replace(Constants.ACCESS_TOKEN,accessToken);
        parameterMap.put(Constants.media_id,mediaId);
        String result = HttpClientUtils.doPost(url,JSON.toJSONString(parameterMap),null,null);
        return (VideoMaterial) defaultReturn(result,VideoMaterial.class);
    }

    @Override
    public void getOtherMaterial(String filePath, String fileName, String accessToken, String mediaId) {
        String url = UrlConstants.POST_GET_PERMANENT_MATERIAL.replace(Constants.ACCESS_TOKEN,accessToken);
        Map<String,Object> parameterMap =new HashMap<>();
        parameterMap.put(Constants.media_id,mediaId);
        FileUtils.download(url,JSON.toJSONString(parameterMap),filePath,fileName);
    }

    @Override
    public String deleteMaterial(String accessToken, String mediaId) {
        String url = UrlConstants.POST_DELETE_PERMANENT_MATERAIL
                                .replace(Constants.ACCESS_TOKEN,accessToken);
        Map<String,Object> parameterMap =new HashMap<>();
        parameterMap.put(Constants.media_id,mediaId);
        String result = HttpClientUtils.doPost(url,parameterMap,null,null);
        return (String) defaultReturn(result,null);
    }

    @Override
    public String updateNewsMaterial(String accessToken, NewsMaterial material) {
        String url = UrlConstants.POST_UPDATE_PERMANENT_NEWS_MATERAIL
                                    .replace(Constants.ACCESS_TOKEN,accessToken);
        String result =  HttpClientUtils.doPost(url,JSON.toJSONString(material),null,null);
        return (String) defaultReturn(result,null);
    }

    @Override
    public MaterialTotal getMaterialTotal(String accessToken) {
        String url = UrlConstants.GET_GET_MATERAIL_TOTAL
                                    .replace(Constants.ACCESS_TOKEN,accessToken);
        String result = HttpClientUtils.doGet(url,null,null);
        return (MaterialTotal)defaultReturn(result,MaterialTotal.class);
    }

    @Override
    public NewsMaterialList getNewsMaterialList(String accessToken, QueryMaterial queryMaterial) {
        String url = UrlConstants.POST_GET_MATERAIL_LIST
                                .replace(Constants.ACCESS_TOKEN,accessToken);
        String result = HttpClientUtils.doPost(url,JSON.toJSONString(queryMaterial),null,null);
        return (NewsMaterialList)defaultReturn(result,NewsMaterialList.class);
    }

    @Override
    public OtherTypeMaterialList getOtherMaterialList(String accessToken, QueryMaterial queryMaterial) {
        String url = UrlConstants.POST_GET_MATERAIL_LIST
                .replace(Constants.ACCESS_TOKEN,accessToken);
        String result = HttpClientUtils.doPost(url,JSON.toJSONString(queryMaterial),null,null);
        return (OtherTypeMaterialList)defaultReturn(result,OtherTypeMaterialList.class);
    }

    /**
     *  上传永久素材
     * @param url
     * @param parameterMap
     * @return
     */
    private Material uploadMaterial(String url,Map<String,Object> parameterMap) {
        String result = HttpClientUtils.doPost(url,parameterMap);
        return (Material) defaultReturn(result,Material.class);
    }

    private Object defaultReturn(String result,Class<? extends Object> clazz){
        String errmsg = JSON.parseObject(result).getString(Constants.errMsg);
        if (StringUtils.isEmpty(errmsg)) {
           if (clazz != null) {
               return JSON.parseObject(result,clazz);
           }else {
               return result;
           }
        }else {
            String msg = JSON.parseObject(result).getString(Constants.errMsg);
            int code = JSON.parseObject(result).getInteger(Constants.errCode);
            throw new MaterialException(code,msg);
        }
    }
}
