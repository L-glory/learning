package com.glory.learning.obserabale;

import java.util.Properties;

/**
 * @author Glory
 * @create 2020-06-17 23:03
 **/
public class GloryOb implements IOb {

    public void print() {
        Properties properties = System.getProperties();
        properties.forEach((key, val) -> {
            System.out.println(String.format("%s=%s", key,val));
        });
    }
}
