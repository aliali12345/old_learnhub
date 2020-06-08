package org.learn.enums;

/**
 * 返回前端信息枚举
 */
public enum Message {
    /**
     * 成功 无返回数据
     */
    SUCCESS(200,"操作成功"),
    /**
     * 登录失败
     */
    LOGIN_FAIL(-1,"账号或密码有误"),
    ;

    private int code;
    private String msg;
    private Object data;

    Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    Message(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
