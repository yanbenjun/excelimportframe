package com.yanbenjun.file.parse.impl;

import com.yanbenjun.file.parse.api.ParseHandler;

public abstract class AbstractParseHandler implements ParseHandler
{
    protected String handlerKey;
    
    @Override
    public String getRegistKey()
    {
        return this.handlerKey;
    }
    
}
