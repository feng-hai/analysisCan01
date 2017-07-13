
package com.gimis.emcs.domain.emums;

public enum DistributorType {
    ALL("销售售服"), SALES("仅销售"), SERVICE("仅售服");

    private String text;
    private DistributorType(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return this.text;
    }
}
