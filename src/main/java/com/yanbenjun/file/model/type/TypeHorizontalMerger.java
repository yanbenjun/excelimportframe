package com.yanbenjun.file.model.type;

import com.yanbenjun.file.controller.ICanRegist;

public interface TypeHorizontalMerger<T> extends ICanRegist
{
    public T merge(Object... values) throws TypeHandleException;
}
