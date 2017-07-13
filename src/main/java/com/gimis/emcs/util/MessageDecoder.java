package com.gimis.emcs.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import kafka.serializer.Decoder;
import kafka.utils.VerifiableProperties;

public class MessageDecoder<T> implements Decoder<T> {

	public MessageDecoder(VerifiableProperties props) {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public T fromBytes(byte[] bytes) {
		// TODO Auto-generated method stub
		T obj = null;
        if (null != bytes && 0 < bytes.length)
        {
            ByteArrayInputStream bis = null;
            ObjectInputStream ois = null;
            try
            {
                bis = new ByteArrayInputStream(bytes);
                ois = new ObjectInputStream(bis);
                obj = (T) ois.readObject();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
            catch (ClassNotFoundException ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                try
                {
                    if (null != bis)
                    {
                        bis.close();
                    }
                    if (null != ois)
                    {
                        ois.close();
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return obj;
	}

}
