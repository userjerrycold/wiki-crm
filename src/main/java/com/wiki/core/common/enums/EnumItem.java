package com.wiki.core.common.enums;

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
@NoArgsConstructor
@AllArgsConstructor
public class EnumItem {

    private Integer code;

    private String name;

    private String label;

}
