package com.entertainment;

import java.util.Comparator;

public class TelevisionBrandChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television t1, Television t2) {
        int brandComparison = t1.getBrand().compareTo(t2.getBrand());
        if (brandComparison == 0) {
            return Integer.compare(t1.getCurrentChannel(), t2.getCurrentChannel());
        }

        return brandComparison;
    }
}