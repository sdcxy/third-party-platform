package com.github.sdcxy.wechat.core.constants;

public interface UrlConstants {

    /**
     *  Get请求
     *  获取微信公众号 access_token
     *  参数参看接口文档地址：https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_access_token.html
     */
    String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";


    /**
     * Post请求
     * 创建自定义菜单
     * 参数参看接口文档地址：https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Creating_Custom-Defined_Menu.html
     */
    String POST_CREATE_CUSTOM_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";


    /**
     * Get请求
     * 查询自定义菜单
     * 参数参看接口文档地址：https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Querying_Custom_Menus.html
     */
    String GET_QUERY_CUSTOM_MENU = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";


    /**
     * Get请求
     * 删除自定义菜单
     * 参数参看接口文档地址：https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Deleting_Custom-Defined_Menu.html
     */
    String GET_DELETE_CUSTOM_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";


    /**
     * Post请求
     * 创建个性化菜单 删除个性化菜单
     * 参数参看接口文档地址：https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Personalized_menu_interface.html
     */
    String POST_CREATE_PERSONALISE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";

    String POST_DELETE_PERSONALISE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";


    /**
     * 文档地址 https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Service_Center_messages.html#0
     * post请求
     * 创建客服账号
     */
    String POST_ADD_KFACCOUNT = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";

    /**
     * post请求
     * 更新客服账号
     */
    String POST_UPDATE_KFACCOUNT = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";

    /**
     * post 请求
     * 删除客服账号
     */
    String POST_DELETE_KFACCOUNT = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";

    /**
     * post/form 请求
     * 设置客服账号头像
     */
    String POST_SET_KFACCOUT_IMAGE = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";


    /**
     * get 请求
     * 获取所有的客服账号
     */
    String GET_GET_KFACCOUNT = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
}
