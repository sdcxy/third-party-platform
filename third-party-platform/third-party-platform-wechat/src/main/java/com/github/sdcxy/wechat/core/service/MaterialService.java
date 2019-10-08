package com.github.sdcxy.wechat.core.service;

import com.github.sdcxy.wechat.core.entity.material.*;
import com.github.sdcxy.wechat.core.entity.material.list.NewsMaterialList;
import com.github.sdcxy.wechat.core.entity.material.list.OtherTypeMaterialList;
import com.github.sdcxy.wechat.core.entity.material.list.QueryMaterial;

/**
 * @ClassName MaterialService
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/6 1:30
 **/
public interface MaterialService {
    // 新增临时素材
    Material addTemporaryMaterial(String filePath, String accessToken, String fileType);
    // 下载临时素材到本地
    void getTemporaryMaterial(String accessToken,String mediaId,String saveFilePath,String fileName);
    // 新增永久图文素材
    Material uploadPermanentNewsMaterial(NewsMaterial material,String accessToken);
    // 上传图文消息内的图片获取URL
    String uploadNewsMessageUrl(String fileName,String accessToken);
    // 新增永久图片素材
    Material uploadImageMaterial(String fileName, String accessToken);
    // 新增永久语音素材
    Material uploadVoiceMaterial(String fileName, String accessToken);
    // 新增永久缩略图素材
    Material uploadThumbMaterial(String fileName, String accessToken);
    // 新增永久视频素材
    Material uploadVideoMaterial(String filePath, String accessToken,VideoMaterialDescription description);

    // 获取永久图文素材列表
    ReturnNewsMaterial getNewsMaterial(String accessToken,String mediaId);
    // 获取永久视频素材
    VideoMaterial getVideoMaterial(String accessToken,String mediaId);
    // 获取其他类型的永久素材
    void getOtherMaterial(String filePath,String fileName,String accessToken,String mediaId);

    // 删除永久素材
    String deleteMaterial(String accessToken,String mediaId);
    // 更新永久图文消息
    String updateNewsMaterial(String accessToken,NewsMaterial material);

    // 获取永久素材的总数
    MaterialTotal getMaterialTotal(String accessToken);

    // 获取图文素材的所有列表
    NewsMaterialList getNewsMaterialList(String accessToken,QueryMaterial queryMaterial);

    // 获取其他类型的素材列表
    OtherTypeMaterialList getOtherMaterialList(String accessToken,QueryMaterial queryMaterial);


}
