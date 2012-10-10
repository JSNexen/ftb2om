package com.feelthebeats.js.ftb2om;

/**
 * JSNexen
 * 10/9/12
 * 9:06 PM
 */
public class Note {
    private final int time;
    private final int column;

    public Note(int time, int column) {
        this.time = time;
        this.column = column;
    }

    public int getTime() {
        return time;
    }

    public int getColumn() {
        return column;
    }
}
