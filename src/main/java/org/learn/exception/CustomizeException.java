package org.learn.exception;

import org.learn.enums.MessageEnum;

/**
 * 自定义异常处理
 */
public class CustomizeException extends RuntimeException {

    public CustomizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomizeException(String message) {
        super(message);
    }

    public CustomizeException(MessageEnum messageEnum) {
        super(messageEnum.toString());
    }
}
