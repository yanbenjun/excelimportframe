package com.yanbenjun.file.model.type;

import com.yanbenjun.file.controller.ICanRegist;

public interface TypeVerticalMerger<T> extends ICanRegist
{
    public T merge(Object... objects);
}
