package com.yanbenjun.file.parse.api;

import com.yanbenjun.file.config.element.BaseParseFileInfo;
import com.yanbenjun.file.controller.ICanRegist;
import com.yanbenjun.file.parse.info.ParseMessage;

public interface ParseHandler extends ICanRegist
{
    public ParseMessage handle(BaseParseFileInfo baseFileInfo);
    
    public PostRowHandler next();
}
