package com.github.controlx;

import com.github.controlx.process.JourneyDataResolver;
import com.github.controlx.stations.Constants;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Abhishek Verma on 9/2/2016.
 *
 * Init class to run Ticket System
 *
 */
public class InitMain {

    public static void main(String[] args) {
        String source;
        String destination;
        System.out.println("\n\n=============Note: This system currently works for only one line==============\n\n");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Source Station Code: ");
        source = in.nextLine();
        System.out.println("Enter Destination Station Code: ");
        destination = in.nextLine();

        if(source != null && destination != null && !source.isEmpty() && !destination.isEmpty()) {
            Constants.bootStrapMaps();
            JourneyDataResolver journeyDataResolver = new JourneyDataResolver();
            try {
                journeyDataResolver.processJourneyData(source, destination);
                System.out.println("\n\n\n************Hyderabad Metro Rail******************\n");
                System.out.println("Source Station: " + journeyDataResolver.getSourceStationName());
                System.out.println("Destination Station: " + journeyDataResolver.getDestinationStationName());
                System.out.println("Distance(stations): " + journeyDataResolver.getDistance());
                System.out.println("Cost INR: " + journeyDataResolver.getCost());
                System.out.println("\n************Happy Journey******************\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
        else{
            System.out.println("Either Source: "+source +" or Destination: "+ destination +" found to be null or empty.");
        }
    }
}
