package org.example;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            String randomID = UUID.randomUUID().toString();
            System.out.println(randomID);
        }

        // Print the random ID
//        System.out.println("Random ID: " + randomID);


        Random random = new Random();
        double[] origin = {7.484403, 80.367822}; // Bridgeport CT USA
        double[] destination = {7.333438, 79.845349}; // Darien CT USA

        double distanceInKm = calculateDistance(origin, destination);
        double distanceInMiles = distanceInKm * 0.621371;
        final int baseSpeed = 60;
        final double traffic = -0.5 + (random.nextDouble());
        DecimalFormat df = new DecimalFormat("#.##");
        double averageSpeed = (traffic*baseSpeed)+baseSpeed;
        double time = Double.parseDouble(df.format(distanceInKm/(averageSpeed)));
        String output = time+"h";
        if(time<1){
            output = Double.parseDouble(df.format(time*60)) + " minutes";
        }
        System.out.println("Distance in KM: " + distanceInKm);
        System.out.println("Average speed: " +  averageSpeed);
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