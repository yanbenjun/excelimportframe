package com.yanbenjun.file.parse.impl.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.yanbenjun.file.config.element.xml.XmlParseFileInfo;
import com.yanbenjun.file.parse.impl.AbstractFileParseHandler;
import com.yanbenjun.file.parse.impl.AbstractReader;
import com.yanbenjun.file.parse.info.HeadParseMessage;
import com.yanbenjun.file.parse.info.ParseMessage;

public class XmlReader extends AbstractReader
{
    private  XmlParseFileInfo xmlFileInfo;
    public XmlReader(XmlParseFileInfo xmlFileInfo, AbstractFileParseHandler fileParseHandler)
    {
        this.xmlFileInfo = xmlFileInfo;
        this.fileParseHandler = fileParseHandler;
    }

    @Override
    public ParseMessage read() throws Exception
    {
        SAXParserFactory sParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = sParserFactory.newSAXParser();
        String fileName = xmlFileInfo.getPath();
        String tagName = xmlFileInfo.getRowTag();
        XmlHandler handler = new XmlHandler(tagName, xmlFileInfo.getToParseFile(), fileParseHandler);
        HeadParseMessage hpMsg = new HeadParseMessage();
        try
        {
            parser.parse(fileName, handler);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("配置的模板与实际上传的模板不匹配，请检查！");
        }
        return hpMsg;
    }

}
