package org.learn.pojo;

import lombok.Data;
import org.learn.enums.MessageEnum;

@Data
public class Result {
    private int code;
    private String msg;
    private Object data;

    public Result(MessageEnum msg) {
        this(msg.getCode(), msg.getMsg());
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(MessageEnum msg, Object data) {
        this(msg.getCode(), msg.getMsg());
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
