/**
 * 
 */
package com.gimis.emcs.ps.msg.end.impl;

import java.io.Serializable;

import com.gimis.emcs.ps.msg.end.End;

/**
 * [5系列尾校验]<p>
 * [功能详细描述]<p>
 * @author zjm
 * @version 1.0, 2011-11-30

 * @since gms-v100
 */
public class DefaultEnd implements End , Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 6573567259512334794L;
    
    private Short crcCode;

    public Short getCrcCode()
    {
        return crcCode;
    }

    public void setCrcCode(Short crcCode)
    {
        this.crcCode = crcCode;
    }
    
}
