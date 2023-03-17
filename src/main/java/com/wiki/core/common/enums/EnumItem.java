package com.wiki.core.common.enums;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EnumItem
 *
 * @author qian.hu
 * @date 2023/2/22 16:47
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnumItem {
    @ApiModelProperty("枚举键")
    private String label;

    @ApiModelProperty("枚举值")
    private String value;

    @ApiModelProperty("枚举code值")
    private Integer code;

}
