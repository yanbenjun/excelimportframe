package com.yanbenjun.file.parse.impl.post;

import java.util.Map;

import com.yanbenjun.file.config.element.ToParseTemplate;
import com.yanbenjun.file.model.RowHandleException;
import com.yanbenjun.file.model.parse.ParsedRow;
import com.yanbenjun.file.parse.api.PostRowHandler;
import com.yanbenjun.file.parse.impl.post.must.AbstractPostRowHandler;
import com.yanbenjun.file.parse.info.ParseMessage;

public class MapWrapHandler extends AbstractPostRowHandler
{

    public MapWrapHandler()
    {
    }
    
    public MapWrapHandler(PostRowHandler next)
    {
        super(next);
    }

    /**
     * 上路对接SameTitleMergeHandler
     */
    @Override
    public void processOne(ParsedRow parsedRow, ParseMessage parseMessage) throws RowHandleException
    {
        ToParseTemplate toParseTemplate = parsedRow.getCurTemplate();
        Map<String, Object> modelRowMap = toParseTemplate.getFullFieldEmptyMap();
        parsedRow.getCells().stream().forEach(ce->modelRowMap.put(ce.getTitle(), ce.getModelValue()));
        parsedRow.setModelRow(modelRowMap);
        next.processOne(parsedRow, parseMessage);
    }

}
