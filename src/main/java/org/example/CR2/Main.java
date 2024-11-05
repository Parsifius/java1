package org.example.CR2;
import org.example.CR2.extra1.RationalFraction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RationalFraction> list = new ArrayList<>();
        list.add(new RationalFraction(1,2));
        list.add(new RationalFraction(3,2));
        list.add(new RationalFraction(2,2));
        list.add(new RationalFraction(-9,2));
        list.add(new RationalFraction(12,2));
        list.add(new RationalFraction(2,2));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
