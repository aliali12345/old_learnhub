package org.learn.enums;

/**
 * 常量枚举
 */
public enum ConstEnum {
    USER_INFO("userInfo"),
    UPLOAD_ROOT_PATH("/uploadFile")
    ;

    ConstEnum(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
