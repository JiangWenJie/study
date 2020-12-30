package com.jwj.study.data.structure.array;

/**
 * @author jwj
 * @date 2020/12/25 09:28
 * @description 数组接口
 * @since 1.0
 */
public interface IMyArray {
    void insert(int element,int index);
    int update(int element,int index);
    int delete(int index);
    int select(int index);
}
