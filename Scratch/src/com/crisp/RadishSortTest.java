package com.crisp;

import java.util.ArrayList;
import java.util.List;

class RadishSortTest {

    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<Radish>();

        radishes.add(new Radish("red", 3.3, 2.1, 5));
        radishes.add(new Radish("pink", 1.9, 1.1, 1));
        radishes.add(new Radish("white", 2.75, 3.0, 7));
        radishes.add(new Radish("red", 1.22, 1.9, 0));

        System.out.println("Original list");
        dump(radishes);

        System.out.println();

        System.out.println("Sort by natural order (size)");
        radishes.sort(null);    // null means natural order
        dump(radishes);

        System.out.println();

        System.out.println("Sort by guysOnTop, via Comparator");
        radishes.sort(new RadishGuysOnTopComparator());
        dump(radishes);

        System.out.println();

        System.out.println("Sort by color, via Comparator");
        radishes.sort(new RadishColorComparator());
        dump(radishes);
    }

    private static void dump(List<Radish> radishList) {
        for (Radish r : radishList) {
            System.out.println(r);
        }
    }
}