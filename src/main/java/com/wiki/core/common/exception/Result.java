package com.wiki.core.common.exception;

import lombok.Data;

/**
 * Result
 *
 * @author qian.hu
 * @date 2023/2/22 16:43
 */
@Data
public class Result {

    private Integer code;

    private String message;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
