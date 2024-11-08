package org.example.CR2;

import org.example.CR2.extra1.RationalFraction;

public class Main {
    public static void main(String[] args) {
        RationalFraction f1 = new RationalFraction(1, 2);
        RationalFraction f2 = new RationalFraction(3, 4);
        System.out.println(f1.add(f2).toString());
    }
}
