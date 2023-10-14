package org.example;

import java.text.DecimalFormat;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        double[] origin = {51.1792, 73.1894}; // Bridgeport CT USA
        double[] destination = {41.0772, 73.4687}; // Darien CT USA

        double distanceInKm = calculateDistance(origin, destination);
        double distanceInMiles = distanceInKm * 0.621371;
        final int averageSpeed = 60;
        final double traffic = -0.5 + (random.nextDouble());
        DecimalFormat df = new DecimalFormat("#.##");
        double time = Double.parseDouble(df.format(distanceInKm/((traffic*averageSpeed)+averageSpeed)));
        String output = time+"h";
        if(time<1){
            output = Double.parseDouble(df.format(time*60)) + " minutes";
        }
        System.out.println("Distance in KM: " + distanceInKm);
        System.out.println("Estimate time: " +  output);
//        System.out.println("Distance in MI: " + distanceInMiles);
    }

    public static double calculateDistance(double[] origin, double[] destination) {
        double lat1 = origin[0];
        double lon1 = origin[1];
        double lat2 = destination[0];
        double lon2 = destination[1];
        double radius = 6371; // Earth's radius in kilometers

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = radius * c;

        return distance;
    }
}