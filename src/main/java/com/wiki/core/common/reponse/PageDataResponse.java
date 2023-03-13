package com.wiki.core.common.reponse;
import lombok.Data;

/**
 * PageDataResponse
 *
 * @author qian.hu
 * @date 2023/2/22 16:23
 */
@Data
public class PageDataResponse<T> extends DataResponse<T>{

    private Long page;

    private Long size;

    private Long total;

    public PageDataResponse(T t) {
        super(t);
    }

    public static <T> PageDataResponse<T> of(T data,Long page,Long size,Long total){
        PageDataResponse<T> response = new PageDataResponse<>(data);
        response.setPage(page);
        response.setSize(size);
        response.setTotal(total);
        return response;
    }

}
