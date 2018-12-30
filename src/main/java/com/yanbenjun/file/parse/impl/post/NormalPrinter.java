package com.yanbenjun.file.parse.impl.post;

import com.yanbenjun.file.model.RowHandleException;
import com.yanbenjun.file.model.parse.ParsedRow;
import com.yanbenjun.file.parse.impl.post.must.AbstractPostRowHandler;
import com.yanbenjun.file.parse.info.ParseMessage;
import com.yanbenjun.file.parse.info.RowParseMessage;

public class NormalPrinter extends AbstractPostRowHandler
{

    public NormalPrinter()
    {
        super(null);
    }

    @Override
    public void processOne(ParsedRow parsedRow, ParseMessage parseMessage) throws RowHandleException
    {
        //System.out.println("sheetIndex:" + parsedRow.getSheetIndex());
        //System.out.println("rowIndex:" + parsedRow.getRowIndex());
        if(parseMessage.isHasError())
        {
            System.out.println(((RowParseMessage)parseMessage).getCellParseMsgs().get(0).getMsg());
        }
        System.out.println("modelRow:" + parsedRow.getModelRow());
    }

}
