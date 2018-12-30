package com.yanbenjun.file.controller;

public interface Register
{
    public boolean regist(ICanRegist t);
    
    public void setDefault();
    
    public ICanRegist getDefault();
}
