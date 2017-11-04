package com.winorout.yygo.myc.http.retrofit;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 构建Api请求参数
 * @Author: zyzhang
 * @Date: 17/11/3 下午4:51
 */
public class HttpRequest {

    public static final String appKey = "ahyycx";
    private static final String k_key = "key";

    /**
     * 获取基础request
     *
     * @author ZhongDaFeng
     */
    public static final Map<String, Object> getRequest() {
        Map<String, Object> map = new HashMap<>();
        map.put(k_key, appKey);
        return map;
    }
}
