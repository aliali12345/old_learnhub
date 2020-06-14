package org.learn.exception;

import org.learn.enums.Message;

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

    public CustomizeException(Message message) {
        super(message.toString());
    }
}
