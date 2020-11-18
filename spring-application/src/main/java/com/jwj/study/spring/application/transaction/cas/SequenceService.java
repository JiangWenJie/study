package com.jwj.study.spring.application.transaction.cas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jwj
 * @date 2020/11/18 17:39
 * @description 生成序号Service类
 * @since 1.0
 */
@Service
public class SequenceService {
    private SequenceMapper sequenceMapper;

    public SequenceService(@Autowired SequenceMapper sequenceMapper) {
        this.sequenceMapper = sequenceMapper;
    }
}
