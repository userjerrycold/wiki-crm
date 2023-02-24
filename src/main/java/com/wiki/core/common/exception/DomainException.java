package com.wiki.core.common.exception;

import lombok.Data;

/**
 * DomainException
 *
 * @author qian.hu
 * @date 2023/2/22 16:40
 */
@Data
public class DomainException extends RuntimeException{
    private final Integer code;

    public DomainException(Integer code) {
        this.code = code;
    }

    public DomainException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public DomainException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public DomainException(Throwable cause, Integer code) {
        super(cause);
        this.code = code;
    }

    public DomainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

}
