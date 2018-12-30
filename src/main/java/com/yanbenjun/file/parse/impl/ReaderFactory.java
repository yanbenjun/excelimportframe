package com.yanbenjun.file.parse.impl;

import com.yanbenjun.file.config.element.BaseParseFileInfo;
import com.yanbenjun.file.config.element.xml.XmlParseFileInfo;
import com.yanbenjun.file.parse.api.Reader;
import com.yanbenjun.file.parse.impl.excel.XlsxReader;
import com.yanbenjun.file.parse.impl.xml.XmlReader;

public class ReaderFactory
{
    public static Reader getReader(BaseParseFileInfo baseFileInfo, AbstractFileParseHandler fileParseHandler)
    {
        if(baseFileInfo.getPath().endsWith(".xlsx"))
        {
            return new XlsxReader(baseFileInfo, fileParseHandler);
        }
        else if(baseFileInfo.getPath().endsWith(".xml"))
        {
            if(baseFileInfo instanceof XmlParseFileInfo)
            {
                return new XmlReader((XmlParseFileInfo)baseFileInfo, fileParseHandler);
            }
            else
            {
                throw new RuntimeException("xml解析需要传入XmlParseFileInfo类型的文件");
            }
        }
        return null;
    }
}
