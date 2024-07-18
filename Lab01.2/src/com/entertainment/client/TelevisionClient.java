package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {

    public static void main(String[] args) {
        Television tv1 = new Television();
        Television tv2 = new Television("RCA", 10);
        System.out.println(tv1);
        System.out.println();
        System.out.println(tv2);

        tv2.changeChannel(9);
        System.out.println();

        System.out.println(tv2);

        System.out.println("-------------");

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);

        Set<Television> televisions = new TreeSet<>();

        televisions.add(tvA);
        televisions.add(tvB);
        televisions.add(tvC);
        televisions.add(tvD);

        System.out.println(televisions.size());

        for (Television tv : televisions) {
            System.out.println(tv);
        }
    }
}