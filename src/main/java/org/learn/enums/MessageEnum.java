package org.learn.enums;

/**
 * 返回前端信息枚举
 */
public enum MessageEnum {
    /**
     * 成功 无返回数据
     */
    SUCCESS(200,"操作成功"),
    /**
     * 登录失败
     */
    LOGIN_FAIL(-1,"账号或密码有误"),
    FAIL(500, "操作失败"),
    FILE_NOT_FOUND(-2, "文件找不到"),
    PAGE_NOT_FOUND(404, "页面找不到"),
    FILE_UPLOAD_FAIL(-3, "上传文件失败"),
    DIR_CREATE_FAIL(-4, "文件夹创建失败")
    ;

    private int code;
    private String msg;

    MessageEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

    public MessageEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
