package com.customerrecords.dublinlunch;

import org.springframework.stereotype.Component;

@Component
class DistanceCalculator
{
    public static double distanceInKm(double sourceLat, double sourceLong, double targetLat, double targetLong) {

        sourceLat = Math.toRadians(sourceLat);
        sourceLong = Math.toRadians(sourceLong);
        targetLat = Math.toRadians(targetLat);
        targetLong = Math.toRadians(targetLong);

        double theta = sourceLong - targetLong;
        double distance = (Math.sin(sourceLat) * Math.sin(targetLat)) + (Math.cos(sourceLat) * Math.cos(targetLat) * Math.cos(theta));

        distance = Math.acos(distance);
        distance = Math.toDegrees(distance);

        distance = convertDistanceInDegreesToNauticalMiles(distance);
        distance = convertDistanceInNauticalMilesToKm(distance);

        return distance;
    }

    private static double convertDistanceInDegreesToNauticalMiles(double distanceInDegrees) {
        return distanceInDegrees * 60 * 1.1515;
    }

    private static double convertDistanceInNauticalMilesToKm(double distanceInNauticalMiles) {
        return distanceInNauticalMiles * 1.609344;
    }
}