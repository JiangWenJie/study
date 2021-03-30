package com.jwj.study.spring.application.transaction.cas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

/**
 * @author jwj
 * @date 2020/11/18 17:39
 * @description 生成序号Service类
 * @since 1.0
 */
@Service
public class SequenceService implements BeanPostProcessor {

    private static final int INIT_VALUE = 1;
    private static final int INCR_VALUE = 1;

    private SequenceMapper sequenceMapper;
    private TransactionTemplate transaction;

    @Autowired
    public SequenceService(SequenceMapper sequenceMapper,TransactionTemplate transaction) {
        this.sequenceMapper = sequenceMapper;
        this.transaction=transaction;
    }

    public Integer compareAndSet(Date date) {
        Integer currentValue = sequenceMapper.selectCurrentValueByTime(date,false);
        if (null == currentValue) {
            // 如果当前不存在序列号，则建立一个为1的序列号
            Integer rsu = init(date);
            return rsu != null ? INIT_VALUE : compareAndSet(date);
        } else {
            int oldValue = currentValue;
            int newValue = oldValue + INCR_VALUE;
            while (0 > sequenceMapper.compareAndSet(date, oldValue, newValue)) {
                oldValue = sequenceMapper.selectCurrentValueByTime(date,false);
                newValue = oldValue + INCR_VALUE;
            }
            return newValue;
        }
    }

    public Integer init(Date date) {
        return transaction.execute(status -> {
            Integer currentValue = sequenceMapper.selectCurrentValueByTime(date, true);
            if (currentValue == null) {
                sequenceMapper.initNew(date);
                return INIT_VALUE;
            } else {
                return null;
            }
        });
    }

}
