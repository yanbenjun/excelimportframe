package com.yanbenjun.file.config.element.xml;

/**
 * 行属性KEY和VALUE的取值位置类型
 * @author Administrator
 *
 */
public enum PropertyKeyValueGetterType
{
    TAG(0),
    ATTR_NAME(1),
    ATTR_VALUE(2),
    TAG_VALUE(3);
    
    private int value;
    
    private PropertyKeyValueGetterType(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
