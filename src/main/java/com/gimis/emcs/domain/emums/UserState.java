
package com.gimis.emcs.domain.emums;

public enum UserState
{
    NORMAL("正常"), LOCKED("锁定"), INVALID("无效");

    private String text;

    private UserState(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return this.text;
    }
}
