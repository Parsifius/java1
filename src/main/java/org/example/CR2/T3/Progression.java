package org.example.CR2.T3;

public abstract class Progression {
    double first, diff;

    public Progression(double first, double diff) {
        this.first = first;
        this.diff = diff;
    }

    public abstract double sumProression(int n);
}
