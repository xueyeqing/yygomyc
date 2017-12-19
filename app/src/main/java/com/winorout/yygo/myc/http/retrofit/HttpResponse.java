package com.winorout.yygo.myc.http.retrofit;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * @Description: http响应参数实体类
 * @Author: zyzhang
 * @Date: 17/11/3 下午4:51
 * 通过Gson解析属性名称需要与服务器返回字段对应,或者使用注解@SerializedName
 * 备注:这里与服务器约定返回格式
 */
public class HttpResponse {

    /**
     * 描述信息
     */
    @SerializedName("msg")
    private String msg;

    /**
     * 状态码
     */
    @SerializedName("code")
    private String code;

    /**
     * 数据对象[成功返回对象,失败返回错误说明]
     */
    @SerializedName("res")
    private Object res;

    /**
     * 是否成功(这里约定200)
     *
     * @return
     */
    public boolean isSuccess() {
        int codes = Integer.parseInt(code);
        return codes == 1 ? true : false;
    }

    public String toString() {
        String response = "[http response]" + "{\"code\": " + code + ",\"msg\":" + msg + ",\"result\":" + new Gson().toJson(res) + "}";
        return response;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return Integer.parseInt(code);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResult() {
        return res;
    }

    public void setResult(Object res) {
        this.res = res;
    }
}
