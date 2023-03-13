package com.wiki.core.api.management.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * BaseRequest
 *
 * @author qian.hu
 * @date 2023/3/8 11:26
 */
@Data
public class BaseRequest {

    @NotNull(message = "page is empty")
    private Integer page;

    @NotNull(message = "size is empty")
    private Integer size;

}
