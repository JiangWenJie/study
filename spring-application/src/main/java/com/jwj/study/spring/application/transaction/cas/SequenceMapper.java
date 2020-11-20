package com.jwj.study.spring.application.transaction.cas;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author jwj
 * @date 2020/11/18 16:05
 * @description CAS实现启动类
 * @since 1.0
 */
@Repository
public interface SequenceMapper {

    Integer selectCurrentValueByTime(@Param("currentTime") Date currentTime,@Param("isLock") Boolean isLock);

    int initNew(@Param("currentTime")Date currentTime);

    int compareAndSet(@Param("currentTime")Date currentTime, @Param("oldValue")int oldValue, @Param("newValue")int newValue);
}
