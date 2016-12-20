package com.github.controlx.supportlibs;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Abhishek Verma on 9/2/2016.
 *
 * - Created custom method to return LinkedHashMap as integrated class returns normal Maps which removes the order of insertions.
 */
public class CustomProperties extends OrderedProperties{

    /** @author Abhishek Verma
     * Convert this instance to a {@link LinkedHashMap} instance.
     *
     * @return the {@link LinkedHashMap} instance
     */
    public LinkedHashMap toJdkLinkedHashMap() {
        LinkedHashMap jdkMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : this.entrySet()) {
            jdkMap.put(entry.getKey(), entry.getValue());
        }
        return jdkMap;
    }
}
