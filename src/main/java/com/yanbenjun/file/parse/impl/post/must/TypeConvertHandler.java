package com.yanbenjun.file.parse.impl.post.must;

import java.util.List;

import com.yanbenjun.file.config.element.ToParseTemplate;
import com.yanbenjun.file.model.RowHandleException;
import com.yanbenjun.file.model.parse.ColumnEntry;
import com.yanbenjun.file.model.parse.ParsedRow;
import com.yanbenjun.file.model.type.TypeConvertor;
import com.yanbenjun.file.model.type.TypeHandleException;
import com.yanbenjun.file.parse.api.PostRowHandler;
import com.yanbenjun.file.parse.info.CellParseMessage;
import com.yanbenjun.file.parse.info.ParseMessage;
import com.yanbenjun.file.parse.info.RowParseMessage;

public class TypeConvertHandler extends AbstractPostRowHandler
{
    public TypeConvertHandler()
    {
        super();
    }
    
    public TypeConvertHandler(PostRowHandler next)
    {
        super(next);
    }

    @Override
    public void processOne(ParsedRow parsedRow, ParseMessage parseMessage) throws RowHandleException
    {
        int sheetIndex = parsedRow.getSheetIndex();
        int rowIndex = parsedRow.getRowIndex();
        ToParseTemplate toParseTemplate = parsedRow.getCurTemplate();
        List<ColumnEntry> cells = parsedRow.getCells();
        RowParseMessage rowParseMessage = new RowParseMessage(sheetIndex);
        for(int i=0; i< cells.size(); i++)
        {
            ColumnEntry ce = cells.get(i);
            String title = ce.getTitle();
            TypeConvertor<?> typeConvertor = toParseTemplate.getTypeConvertor(title);
            try
            {
                Object obj = typeConvertor.convert(ce.getValue());
                ce.setModelValue(obj);
            }
            catch (TypeHandleException e)
            {
                String errorMsg = e.getErrorInfo();
                CellParseMessage cpm = new CellParseMessage(errorMsg, ce.getKey(), rowIndex, sheetIndex);
                rowParseMessage.add(cpm);
                rowParseMessage.setHasError(true);
            }
        }
        next.processOne(parsedRow, rowParseMessage);
    }
}
