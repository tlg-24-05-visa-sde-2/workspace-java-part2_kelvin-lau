/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collection;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        // testFindById();
        // testFindByKeyword();
        // testFindByCategory();
        testSize();
        testGetAll();
        testAllItemsAtLeastTen();
        testCheapestItemGenre();
        testEightiesItemsLessThan();
        testGetGenreMap();
        testItemsWithGenre();
        testFindRockLessThan();
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem item = catalog.findById(6L);
        System.out.println(item);

        MusicItem notFound = catalog.findById(66L);
        System.out.println(notFound);
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.findByKeyword("Moore"));


    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        int size = catalog.size();
        System.out.println("Size of catalog is: " + size);
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> items = catalog.getAll();
        for (MusicItem item : items) {
            System.out.println(item);
        }
    }

    private static void testAllItemsAtLeastTen() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.atLeastTen());
    }

    private static void testCheapestItemGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        MusicItem cheapest = catalog.cheapestItemGenre(MusicCategory.POP);
        System.out.println(cheapest);
    }

    private static void testEightiesItemsLessThan() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.eightiesItemsLessThan(15));
    }

    private static void testGetGenreMap() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.getGenreMap());
    }

    private static void testItemsWithGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.itemsWithGenre(MusicCategory.ROCK));
    }

    private static void testFindRockLessThan() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.findRockLessThan(12));
    }
}