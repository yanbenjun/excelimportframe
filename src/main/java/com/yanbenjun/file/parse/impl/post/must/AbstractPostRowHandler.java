package com.yanbenjun.file.parse.impl.post.must;

import com.yanbenjun.file.parse.api.PostRowHandler;

/**
 * 文件解析行信息后处理器抽象父类
 * @author Administrator
 *
 */
public abstract class AbstractPostRowHandler implements PostRowHandler
{
    /**
     * 下一个行处理器
     */
    protected PostRowHandler next;
    
    public AbstractPostRowHandler()
    {
    }
    
    public AbstractPostRowHandler(PostRowHandler next)
    {
        this.next = next;
    }
    
    public PostRowHandler next()
    {
        return next;
    }

    public PostRowHandler getNext()
    {
        return next;
    }

    public void setNext(PostRowHandler next)
    {
        this.next = next;
    }
    
    /**
     * 给当前行处理器设置下一个行处理器，并返回下一个行处理器
     */
    public PostRowHandler next(PostRowHandler next)
    {
        this.next = next;
        return this.next;
    }
}
