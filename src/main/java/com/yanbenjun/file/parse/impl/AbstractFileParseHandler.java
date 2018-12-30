package com.yanbenjun.file.parse.impl;

import com.yanbenjun.file.config.element.BaseParseFileInfo;
import com.yanbenjun.file.parse.api.PostRowHandler;
import com.yanbenjun.file.parse.api.Reader;
import com.yanbenjun.file.parse.info.HeadParseMessage;

public abstract class AbstractFileParseHandler extends AbstractParseHandler implements PostRowHandler
{
    @Override
    public HeadParseMessage handle(BaseParseFileInfo baseFileInfo)
    {
        try
        {
            Reader reader = ReaderFactory.getReader(baseFileInfo, this);
            return (HeadParseMessage)reader.read();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
