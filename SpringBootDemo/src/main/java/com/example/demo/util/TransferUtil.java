package com.example.demo.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TransferUtil<K,V> {
    public void transfer(K airLineData, V infoXml){
        Class ac = airLineData.getClass();
        Class ic = infoXml.getClass();
        Field[] ifields = ic.getDeclaredFields();

        for(Field field:ifields){
            String fname = field.getName();
            if(!fname.equals("price")){
                char c = fname.charAt(0);
                if(c<='z'&&c>='a'){
                    c = (char)(c-32);
                    fname = c+fname.substring(1);
                }
                try {
                    ac.getDeclaredMethod("set"+fname,String.class).invoke(airLineData,
                            (String)(ic.getDeclaredMethod("get"+fname).invoke(infoXml)));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
