package com.feelthebeats.js.ftb2om;

/**
 * JSNexen
 * 10/9/12
 * 9:05 PM
 */
public class BPM {
    private final int time;
    private final double value;

    public BPM(int time, double value) {
        this.time = time;
        this.value = value;
    }

    public int getTime() {
        return time;
    }

    public double getValue() {
        return value;
    }
}
