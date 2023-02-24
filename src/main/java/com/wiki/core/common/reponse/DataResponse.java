package com.wiki.core.common.reponse;

import lombok.Data;

/**
 * DataResponse
 *
 * @author qian.hu
 * @date 2023/2/9 16:31
 */
@Data
public class DataResponse<T> {

    private Integer code;

    private T data;

    private String message;

    public DataResponse(){}

    public DataResponse(T data){
        this.code = 200;
        this.data = data;
        this.message = "success";
    }

    public static <T> DataResponse<T> of(T t){
        return new DataResponse<>(t);
    }
}
