package com.rs.basickafkaproducer.entity;

/**
 * created by rs 5/2/2022.
 */
public class SimpleNumber {

    private int number;

    public SimpleNumber() {
    }

    public SimpleNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "SimpleNumber{" +
                "number=" + number +
                '}';
    }
}
