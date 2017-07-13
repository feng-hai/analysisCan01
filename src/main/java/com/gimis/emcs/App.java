package com.gimis.emcs;

import com.gimis.emcs.listener.SystemStartUpListener;

public class App 
{
    public static void main( String[] args )
    {
        new Thread(new SystemStartUpListener()).start();
    }
}
