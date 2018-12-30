package com.yanbenjun.file.parse.api;

public interface Filter
{
    public <S,R> R map(S s);
}
