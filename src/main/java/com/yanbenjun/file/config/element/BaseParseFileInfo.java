package com.yanbenjun.file.config.element;

public class BaseParseFileInfo
{
    protected String path;
    
    
    private ToParseFile toParseFile;
    
    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public ToParseFile getToParseFile()
    {
        return toParseFile;
    }

    public void setToParseFile(ToParseFile toParseFile)
    {
        this.toParseFile = toParseFile;
    }
}
