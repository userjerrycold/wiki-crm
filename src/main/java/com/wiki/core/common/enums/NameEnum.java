package com.wiki.core.common.enums;

import javax.validation.constraints.NotNull;

/**
 * NameEnum
 *
 * @author qian.hu
 * @date 2023/2/22 16:48
 */
public interface NameEnum extends CodeEnum{

    @NotNull
    String getName();

    default Boolean getVisible(){
        return Boolean.TRUE;
    }
}
