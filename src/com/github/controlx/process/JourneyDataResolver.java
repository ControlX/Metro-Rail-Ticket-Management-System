package com.github.controlx.process;

import com.github.controlx.stations.Constants;
import com.github.controlx.stations.EnumLine;
import com.github.controlx.stations.LineInit;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static com.github.controlx.stations.EnumLine.LineA;

/**
 * Created by Abhishek Verma on 9/2/2016.
 *
 * This class interacts with InitMain class and further connects to Constants/Db for operations
 * It fetches data and computes according to Station Code.
 *
 * Todo: Currently working for only one particular line
 * Todo: Need to remove check of startsWith as it is not a scalable approach, implemented temporarily
 */
public class JourneyDataResolver {
    private LinkedHashMap<String, String> lineA;
    private LinkedHashMap<String, String> lineB;
    private LinkedHashMap<String, String> lineC;

    private LinkedHashMap<String, String> lineARev;
    private LinkedHashMap<String, String> lineBRev;
    private LinkedHashMap<String, String> lineCRev;

    private LinkedHashMap<String, String> lineAll;

    private String sourceStationName;
    private String destinationStationName;
    private BigDecimal cost;
    private int distance;

    private EnumLine enumLine;
    private NavigableMap subMap;

    private TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
        public int compare(String o1, String o2) {
            return Integer.valueOf(o1.substring(1, o1.length())).compareTo(Integer.valueOf(o2.substring(1, o2.length())));
        }
    });

    public JourneyDataResolver(){
        LineInit lineInit = new LineInit();

        lineA = lineInit.getASeriesStationMap();
        lineB = lineInit.getBSeriesStationMap();
        lineC = lineInit.getCSeriesStationMap();

        lineARev = lineInit.getASeriesStationMap();
        lineBRev = lineInit.getBSeriesStationMap();
        lineCRev = lineInit.getCSeriesStationMap();

        lineAll = lineInit.getAllDataMap();
    }

    public void processJourneyData(String sourceStationCode, String destinationStationCode)throws IOException{

        if(sourceStationCode.equalsIgnoreCase(destinationStationCode)){
            throw new IOException("Destination can't be same as source station");
        }

        sourceStationCode = JourneyUtils.resolveStationCodeForDbOperations(sourceStationCode, destinationStationCode);
        destinationStationCode = JourneyUtils.resolveStationCodeForDbOperations(destinationStationCode, sourceStationCode);

        if(sourceStationCode.toLowerCase().startsWith("a")){
            if(destinationStationCode.toLowerCase().startsWith("a")) {
                if (JourneyUtils.isOnwardJourney(sourceStationCode, destinationStationCode)) {
                    treeMap.putAll(lineA);
                    subMap = treeMap.subMap(sourceStationCode, true, destinationStationCode, true);
                } else {
                    treeMap.putAll(lineARev);
                    subMap = treeMap.subMap(sourceStationCode, true, destinationStationCode, true);
                }

                enumLine = LineA;
            }
        }
        else if(sourceStationCode.toLowerCase().startsWith("b")){
            if(destinationStationCode.toLowerCase().startsWith("b")) {
                if (JourneyUtils.isOnwardJourney(sourceStationCode, destinationStationCode)) {
                    treeMap.putAll(lineB);
                    subMap = treeMap.subMap(sourceStationCode, true, destinationStationCode, true);
                } else {
                    treeMap.putAll(lineBRev);
                    subMap =treeMap.subMap(sourceStationCode, true, destinationStationCode, true);
                }

                enumLine = EnumLine.LineB;
            }
        }
        else if(sourceStationCode.toLowerCase().startsWith("c")){
            if(destinationStationCode.toLowerCase().startsWith("c")) {
                if (JourneyUtils.isOnwardJourney(sourceStationCode, destinationStationCode)) {
                    treeMap.putAll(lineC);
                    subMap = treeMap.subMap(sourceStationCode, true, destinationStationCode, true);
                } else {
                    treeMap.putAll(lineCRev);
                    subMap = treeMap.subMap(sourceStationCode, true, destinationStationCode, true);
                }

                enumLine = EnumLine.LineC;
            }
        }
        /*else if(sourceStationCode.toLowerCase().startsWith("x")){
            //Todo resolve for x
        }*/
        else{
            throw new IOException("Not a valid Source Station code: "+sourceStationCode);
        }

        setSourceStationName(lineAll.get(sourceStationCode));
        setDestinationStationName(lineAll.get(destinationStationCode));
        analyzeCostAndDistance(subMap);
    }

    private int processForIndex(TreeMap hashMap, String stationCode){
        return new ArrayList<>(hashMap.keySet()).indexOf(stationCode);
    }

    private void analyzeCostAndDistance(NavigableMap subMap){
        int stops = subMap.size();
        double fixedRate = 10;
        int remainingStops = stops - 3;
        double fare = fixedRate;

        if(remainingStops <= 0)
            setCost(new BigDecimal(fare));
        else {
            switch (enumLine) {
                case LineA:
                    fare = fare + remainingStops * Constants.LINE_1_FARE;
                    setCost(new BigDecimal(fare));
                    break;
                case LineB:
                    fare = fare + remainingStops * Constants.LINE_2_FARE;
                    setCost(new BigDecimal(fare));
                    break;
                case LineC:
                    fare = fare + remainingStops * Constants.LINE_3_FARE;
                    setCost(new BigDecimal(fare));
                    break;
            }
        }
        setDistance(stops);
    }

    public String getSourceStationName() {
        return sourceStationName;
    }

    public void setSourceStationName(String sourceStationName) {
        this.sourceStationName = sourceStationName;
    }

    public String getDestinationStationName() {
        return destinationStationName;
    }

    public void setDestinationStationName(String destinationStationName) {
        this.destinationStationName = destinationStationName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
