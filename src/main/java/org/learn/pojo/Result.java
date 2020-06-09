package org.learn.pojo;

import lombok.Data;
import org.learn.enums.Message;

@Data
public class Result {
    private int code;
    private String msg;
    private Object data;

    public Result(Message msg) {
        this(msg.getCode(), msg.getMsg());
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
