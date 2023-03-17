package com.wiki.core.domain.service;

import com.wiki.core.common.enums.EnumItem;
import com.wiki.core.common.enums.NamedEnum;
import com.wiki.core.domain.dto.EnumDTO;
import com.wiki.core.domain.model.pojo.QuestionBank;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * EnumService
 *
 * @author qian.hu
 * @date 2023/3/17 15:07
 */
@Service
public class EnumService {

    public EnumDTO getEnumMap() {
        return EnumDTO.builder()
                .questionType(converter(QuestionBank.QuestionType.class))
                .build();
    }

    @NonNull
    private <T extends Enum<T> & NamedEnum> List<EnumItem> converter(Class<T> enumType) {
        Enum[] enums = enumType.getEnumConstants();
        List<EnumItem> list = new ArrayList<>();

        for (Enum anEnum : enums) {
            if (((NamedEnum) anEnum).getVisible()) {
                list.add(new EnumItem(((NamedEnum) anEnum).getName(), anEnum.toString(), ((NamedEnum) anEnum).getCode()));
            }
        }

        return list;
    }

    @NonNull
    private <T extends Enum<T> & NamedEnum> List<EnumItem> converter(EnumSet<T> enumSet) {
        List<EnumItem> list = new ArrayList<>();

        for (Enum anEnum : enumSet) {
            list.add(new EnumItem(((NamedEnum) anEnum).getName(), anEnum.toString(), ((NamedEnum) anEnum).getCode()));
        }

        return list;
    }
}
