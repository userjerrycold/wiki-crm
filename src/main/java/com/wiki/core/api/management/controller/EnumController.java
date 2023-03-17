package com.wiki.core.api.management.controller;

import com.wiki.core.common.reponse.DataResponse;
import com.wiki.core.domain.dto.EnumDTO;
import com.wiki.core.domain.service.EnumService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * EnumController
 *
 * @author qian.hu
 * @date 2023/3/17 15:06
 */
@RestController
@RequestMapping("/enum")
public class EnumController {

    @Resource
    private EnumService enumService;

    @ApiOperation("枚举模型")
    @GetMapping
    public DataResponse<EnumDTO> getEnums() {
        return DataResponse.of(enumService.getEnumMap());
    }


}
