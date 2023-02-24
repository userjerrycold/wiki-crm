package com.wiki.core.common.enums;

import javax.validation.constraints.NotNull;

/**
 * CodeEnum
 *
 * @author qian.hu
 * @date 2023/2/22 16:49
 */
public interface CodeEnum {

    @NotNull
    Integer getCode();

}
