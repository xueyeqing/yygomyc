package com.winorout.yygo.myc.http.exception;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/11/4 上午9:53
 */
public class ServerException extends RuntimeException {
    private int code;
    private String msg;

    public ServerException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
