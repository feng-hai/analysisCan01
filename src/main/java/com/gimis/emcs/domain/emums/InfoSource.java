
package com.gimis.emcs.domain.emums;

public enum InfoSource
{
    MANUAL("手动"),SYNC("同步");

    private String text;

    private InfoSource(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return this.text;
    }
}
