package com.wiki.core.api.management.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * BaseRequest
 *
 * @author qian.hu
 * @date 2023/3/8 11:26
 */
@Data
public class BaseRequest {

    private Integer page;

    private Integer size;

}
