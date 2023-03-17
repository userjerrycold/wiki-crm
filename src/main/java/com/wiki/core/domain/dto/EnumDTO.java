package com.wiki.core.domain.dto;

import com.wiki.core.common.enums.EnumItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * EnumDTO
 *
 * @author qian.hu
 * @date 2023/3/17 15:08
 */
@ApiModel("EnumDTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnumDTO {

    @ApiModelProperty(value = "题目类型", required = true)
    @NotNull
    private List<EnumItem> questionType;

}
