/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    @Test
    public void getLoudestTelevision_shouldReturnLoudestTelevision() {
        Collection<Television> tvs = Catalog.getInventory();
        Television loudest = tvs.iterator().next();

        for (Television tv : tvs) {
            if (tv.getVolume() > loudest.getVolume()) {
                loudest = tv;
            }
        }

        assertEquals(94, loudest.getVolume());
    }

    @Test
    public void getUnique_shouldReturnUniqueCollection() {
        Collection<Television> items = Catalog.getInventory();
        Collection<Television> unique = new HashSet<>(items);

        assertEquals(23, unique.size());
    }

    @Test
    public void getInventory_shouldReturnCollection() {
        assertEquals(30, Catalog.getInventory().size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getInventory_shouldThrowUnsupportedOperationException_whenModified() {
        Television tv = new Television();
        Catalog.getInventory().add(tv);
    }

    @Test
    public void findByBrand_shouldReturnCollectionWithMatchingBrand_BrandFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");

        assertEquals(7, tvs.size());

        for (Television tv : tvs) {
            assertEquals(tv.getBrand(), "Sony");
        }
    }

    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void findByBrand_shouldReturnEmptyCollection_BrandNotFound() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");

        assertTrue(tvs.isEmpty());
    }

    @Test
    public void findByBrands_shouldReturnPopulatedMap_oneRowPerBrandPassed_severalBrands() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony", "Zenith", "Hitachi");

        assertEquals(3, tvMap.size());
    }

    @Test
    public void findByBrands_shouldReturnEmptyMap_BrandsNotFound() {
        Map<String, Collection<Television>> tvs = Catalog.findByBrands("NO-MATCHES");

        assertTrue(tvs.isEmpty());
    }
}