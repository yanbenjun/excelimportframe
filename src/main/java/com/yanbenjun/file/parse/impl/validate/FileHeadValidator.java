package com.yanbenjun.file.parse.impl.validate;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.yanbenjun.file.config.element.BaseParseFileInfo;
import com.yanbenjun.file.config.element.ColumnHead;
import com.yanbenjun.file.config.element.ToParseTemplate;
import com.yanbenjun.file.model.ErrorMessage;
import com.yanbenjun.file.model.RowHandleException;
import com.yanbenjun.file.model.parse.ParsedRow;
import com.yanbenjun.file.parse.api.PostRowHandler;
import com.yanbenjun.file.parse.impl.AbstractFileParseHandler;
import com.yanbenjun.file.parse.info.HeadParseMessage;
import com.yanbenjun.file.parse.info.ParseMessage;

public class FileHeadValidator extends AbstractFileParseHandler implements HeadValidator
{
    private BaseParseFileInfo baseFileInfo;
    
    public FileHeadValidator(BaseParseFileInfo baseFileInfo)
    {
        this.baseFileInfo = baseFileInfo;
    }
    
    @Override
    public HeadParseMessage validate() throws Exception
    {
        return handle(baseFileInfo);
    }

    @Override
    public void processOne(ParsedRow parsedRow, ParseMessage parseMessage) throws RowHandleException
    {
        validate(parsedRow);
    }

    @Override
    public void validate(ParsedRow dataRow) throws RowHandleException
    {
        ToParseTemplate toParseTemplate = dataRow.getCurTemplate();
        if(toParseTemplate.getHeadRow() == dataRow.getRowIndex())
        {
            HeadParseMessage hpMsg = new HeadParseMessage();
            HeadParseException hpe = new HeadParseException(hpMsg);
            List<String> keyHeads = toParseTemplate.getToParseHead().getColumnHeads().stream()
                    .filter(ColumnHead::isRequired)
                    .map(ColumnHead::getTitleName)
                    .collect(Collectors.toList());
            List<String> allDataHeads = dataRow.getCells().stream()
                    .map(Entry<Integer,String>:: getValue)
                    .collect(Collectors.toList());
            for(String keyHead : keyHeads)
            {
                if(!allDataHeads.contains(keyHead))
                {
                    ErrorMessage error = new ErrorMessage("表头：“" + keyHead + "”必须包含。");
                    hpMsg.add(error);
                    hpMsg.setHasError(true);
                }
            }
            if(hpMsg.isHasError())
            {
                throw hpe;
            }
        }
        if(toParseTemplate.getHeadRow() < dataRow.getRowIndex())
        {
            System.out.println("no error");
            throw new RowHandleException();
        }
    }

    @Override
    public PostRowHandler next(PostRowHandler next)
    {
        throw new UnsupportedOperationException("不支持next操作");
    }

    @Override
    public PostRowHandler next()
    {
        throw new UnsupportedOperationException("不支持next操作");
    }

}
