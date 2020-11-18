package com.jwj.study.spring.application.transaction.cas;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jwj
 * @date 2020/11/18 16:05
 * @since 1.0
 */
public class Sequence implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 时间，年月日
     */
    private Date currentTime;

    /**
     * 递增序列值，最大8位，从0开始
     */
    private Integer currentValue;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }
}
