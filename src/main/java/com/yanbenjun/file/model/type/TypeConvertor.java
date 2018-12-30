package com.yanbenjun.file.model.type;

import com.yanbenjun.file.controller.ICanRegist;

public interface TypeConvertor<T> extends ICanRegist
{
    public T convert(String value) throws TypeHandleException;
}
