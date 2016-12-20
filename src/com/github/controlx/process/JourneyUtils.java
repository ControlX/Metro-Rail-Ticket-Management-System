package com.github.controlx.process;

import com.github.controlx.stations.Constants;

/**
 * Created by Abhishek Verma on 9/2/2016.
 *
 * Todo: Only works for one line
 */
public class JourneyUtils {

    public static boolean isConnectingStation(String stationCode){
        return Constants.connectingStationMap.containsKey(stationCode);
    }

    public static String resolveStationCodeForDbOperations(String sourceStnCode, String destinationStnCode){
        if(sourceStnCode.toLowerCase().startsWith("x")) {
            if (destinationStnCode.toLowerCase().startsWith("a")) {
                sourceStnCode = sourceStnCode + "A";
            } else if (destinationStnCode.toLowerCase().startsWith("b")) {
                sourceStnCode = sourceStnCode + "B";
            } else if (destinationStnCode.toLowerCase().startsWith("c")) {
                sourceStnCode = sourceStnCode + "C";
            } else {
                //Todo: resolve for x
            }
            return stationCodeResolver(sourceStnCode);
        }

        return sourceStnCode;
    }

    private static String stationCodeResolver(String code){
        return Constants.connectingStationMapReverseLookup.get(code);
    }

    public static boolean isOnwardJourney(String src, String dstn){
        int i = src.compareToIgnoreCase(dstn);

        if(i<0)
            return true;
        else
            return false;
    }
}
