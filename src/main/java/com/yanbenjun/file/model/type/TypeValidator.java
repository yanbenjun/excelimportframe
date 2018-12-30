package com.yanbenjun.file.model.type;

import com.yanbenjun.file.controller.ICanRegist;

public interface TypeValidator extends ICanRegist
{
    public String validate(Object value) throws TypeHandleException;
}
