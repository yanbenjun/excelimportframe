package com.yanbenjun.file.parse.api;

public interface Mapper<S,R>
{
    public R map(S s);
}
