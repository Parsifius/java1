package org.example.CR2.T3;

public class Geometric extends Progression{
    double first, diff;

    public Geometric(double first, double diff) {
        super(first, diff);
    }

    //Сумма геометрической прогрессии первых н членов
    public double sumProression(int n){
        double start = first;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += start;
            start *= diff;
        }
        return sum;
    }
}
