package com.jewels;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class JewelSortTest {

    public static void main(String[] args) {
        List<String> jewels = new ArrayList<>();
        jewels.add("opal");
        jewels.add("emerald");
        jewels.add("onyx");
        jewels.add("saphire");

        jewels.sort((j1, j2) -> j1.compareTo(j2));
        dump(jewels);

    }

    private static void dump(List<String> jewels) {
        for (String jewel : jewels) {
            System.out.println(jewel);
        }
    }
}