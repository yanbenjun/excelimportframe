package com.yanbenjun.file.parse.impl.post;

import com.yanbenjun.file.config.element.ToParseFile;
import com.yanbenjun.file.model.RowHandleException;
import com.yanbenjun.file.model.parse.ParsedRow;
import com.yanbenjun.file.parse.api.PostRowHandler;
import com.yanbenjun.file.parse.impl.post.must.AbstractPostRowHandler;
import com.yanbenjun.file.parse.info.ParseMessage;

public class ModelWrapHandler extends AbstractPostRowHandler
{
    public ModelWrapHandler(ToParseFile toParseFile)
    {
    }
    
    
    public ModelWrapHandler(ToParseFile toParseFile, PostRowHandler next)
    {
        super(next);
    }


    @Override
    public void processOne(ParsedRow parsedRow, ParseMessage parseMessage) throws RowHandleException
    {
        // TODO Auto-generated method stub
        if(next != null)
        {
            next.processOne(parsedRow, parseMessage);
        }
    }

}
