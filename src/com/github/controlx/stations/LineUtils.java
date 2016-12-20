package com.github.controlx.stations;

import com.github.controlx.supportlibs.CustomProperties;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashMap;

/**
 * Created by Abhishek Verma on 9/2/2016.
 */
public class LineUtils {
    protected static LinkedHashMap getMapFromString(String string){
        String input = string;
        String propertiesFormat = input.replaceAll(",", "\n");
        CustomProperties properties = new CustomProperties();
        try {
            properties.load(new StringReader(propertiesFormat));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new LinkedHashMap<>(properties.toJdkLinkedHashMap());
    }
}
