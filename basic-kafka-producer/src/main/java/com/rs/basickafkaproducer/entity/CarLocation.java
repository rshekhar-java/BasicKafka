package com.rs.basickafkaproducer.entity;

/**
 * created by rs 5/1/2022.
 */
public class CarLocation {

    private String carId;
    private long timestamp;
    private int distance;

    public CarLocation() {
    }

    public CarLocation(String carId, long timestamp, int distance) {
        this.carId = carId;
        this.timestamp = timestamp;
        this.distance = distance;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "CarLocation{" +
                "carId='" + carId + '\'' +
                ", timestamp=" + timestamp +
                ", distance=" + distance +
                '}';
    }
}
