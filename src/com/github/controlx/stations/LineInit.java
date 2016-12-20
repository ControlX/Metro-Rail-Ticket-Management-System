package com.github.controlx.stations;

import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Created by Abhishek Verma on 9/1/2016.
 *
 * - Initialises all lines data and fills into Maps
 */
public class LineInit {
    private LinkedHashMap<String, String> lineASeriesMap = new LinkedHashMap<>();
    private LinkedHashMap<String, String> lineBSeriesMap = new LinkedHashMap<>();
    private LinkedHashMap<String, String> lineCSeriesMap = new LinkedHashMap<>();

    private LinkedHashMap<String, String> lineAllMap = new LinkedHashMap<>();

    public LineInit(){
        lineASeriesMap = LineUtils.getMapFromString(Constants.CONSTANT_LINE_1);
        lineBSeriesMap = LineUtils.getMapFromString(Constants.CONSTANT_LINE_2);
        lineCSeriesMap = LineUtils.getMapFromString(Constants.CONSTANT_LINE_3);

        lineAllMap.putAll(lineASeriesMap);
        lineAllMap.putAll(lineBSeriesMap);
        lineAllMap.putAll(lineCSeriesMap);
    }

    public LinkedHashMap getASeriesStationMap(){
        return lineASeriesMap;
    }

    public LinkedHashMap getBSeriesStationMap(){
        return lineBSeriesMap;
    }

    public LinkedHashMap getCSeriesStationMap(){
        return lineCSeriesMap;
    }

    public LinkedHashMap getAllDataMap(){
        return lineAllMap;
    }
}
