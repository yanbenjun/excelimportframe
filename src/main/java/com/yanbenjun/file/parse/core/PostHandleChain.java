package com.yanbenjun.file.parse.core;

import com.yanbenjun.file.config.element.BaseParseFileInfo;
import com.yanbenjun.file.parse.api.ParseHandler;
import com.yanbenjun.file.parse.api.PostRowHandler;
import com.yanbenjun.file.parse.extract.FileParseExtractor;
import com.yanbenjun.file.parse.impl.post.CacheHandler;
import com.yanbenjun.file.parse.impl.post.ExcludeFiltHandler;
import com.yanbenjun.file.parse.impl.post.MapWrapHandler;
import com.yanbenjun.file.parse.impl.post.NormalPrinter;
import com.yanbenjun.file.parse.impl.post.must.SameTitleMergeHandler;
import com.yanbenjun.file.parse.impl.post.must.TypeConvertHandler;

public class PostHandleChain
{
    private ParseHandler startHandler;

    public PostHandleChain(ParseHandler startHandler)
    {
        this.startHandler = startHandler;
    }

    public static PostHandleChain getDefaultChain()
    {
        NormalPrinter np = new NormalPrinter();
        MapWrapHandler mwh = new MapWrapHandler();
        ExcludeFiltHandler efh = new ExcludeFiltHandler();
        SameTitleMergeHandler stmh = new SameTitleMergeHandler();
        stmh.next(efh).next(mwh).next(np);
        TypeConvertHandler tch = new TypeConvertHandler(stmh);

        FileParseExtractor extrator = new FileParseExtractor(tch);
        return new PostHandleChain(extrator);
    }

    public static PostHandleChain getXmlDefaultChain()
    {
        CacheHandler cache = new CacheHandler();
        FileParseExtractor extrator = new FileParseExtractor(cache);
        return new PostHandleChain(extrator);
    }

    public void run(BaseParseFileInfo baseFileInfo)
    {
        this.startHandler.handle(baseFileInfo);
    }

    public CacheHandler getCacheHandler()
    {
        PostRowHandler prHandler = null;
        while ((prHandler = this.startHandler.next()) != null)
        {
            if (prHandler instanceof CacheHandler)
            {
                return (CacheHandler) prHandler;
            }
        }
        return null;
    }
}
