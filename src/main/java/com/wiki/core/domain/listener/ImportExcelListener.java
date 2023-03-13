package com.wiki.core.domain.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wiki.core.domain.dao.QuestionBankMapper;
import com.wiki.core.domain.model.pojo.QuestionBank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;

/**
 * ImportExcelListener
 *
 * @author qian.hu
 * @date 2023/3/10 16:27
 */
@Slf4j
public class ImportExcelListener extends AnalysisEventListener<QuestionBank> {
    /**
     * 每隔1000条存储数据库，然后清理list，方便内存回收
     */
    private static final int BATCH_COUNT = 1000;
    /**
     * 临时存储
     */
    private List<QuestionBank> cachedData = new ArrayList<>(BATCH_COUNT);
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private final QuestionBankMapper questionBankMapper;

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public ImportExcelListener(QuestionBankMapper questionBankMapper) {
        this.questionBankMapper = questionBankMapper;
    }

    /**
     * 这个每一条数据解析都会来调用
     * @param t
     * @param analysisContext
     */
    @Override
    public void invoke(QuestionBank t, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(t));
        cachedData.add(t);
        if(cachedData .size() >= BATCH_COUNT){
            batchSaveData();
            cachedData = new ArrayList<>(BATCH_COUNT);
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //这里也要保存数据，确保最后遗留的数据也存储到数据库
        batchSaveData();
    }

    @Async
    public void batchSaveData() {
        log.info("{}条数据，开始存储数据库!", cachedData.size());
        questionBankMapper.batchInsertData(cachedData);
        log.info("存储数据库成功!");
    }

}
