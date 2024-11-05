package org.example.CR2.T3;

public class Arithmetic extends Progression{

    public Arithmetic(double first, double diff) {
        super(first, diff);
    }

    //Сумма арифметической прогрессии первых н членов
    public double sumProression(int n){
        return (n/2)*(2*first + (n-1)*diff);
    }

}
