/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog;

import java.util.*;

// OF COURSE THIS CLASS DOESN'T COMPILE
// Your first job is to fulfill the contract that this class has signed.
public class InMemoryCatalog implements Catalog {

    private final List<MusicItem> catalogData = new ArrayList<>(List.of(
                   /* id    title                        artist                       releaseDate  price  musicCategory */
        new MusicItem(1L,  "Diva",                      "Annie Lennox",              "1992-01-04", 13.99, MusicCategory.POP),
        new MusicItem(2L,  "Dream of the Blue Turtles", "Sting",                     "1985-02-05", 14.99, MusicCategory.POP),
        new MusicItem(3L,  "Trouble is...",             "Kenny Wayne Shepherd Band", "1997-08-08", 14.99, MusicCategory.BLUES),
        new MusicItem(4L,  "Lie to Me",                 "Jonny Lang",                "1997-08-26", 17.97, MusicCategory.BLUES),
        new MusicItem(5L,  "Little Earthquakes",        "Tori Amos",                 "1992-01-18", 14.99, MusicCategory.ALTERNATIVE),
        new MusicItem(6L,  "Seal",                      "Seal",                      "1991-08-18", 17.97, MusicCategory.POP),
        new MusicItem(7L,  "Ian Moore",                 "Ian Moore",                 "1993-12-05",  9.97, MusicCategory.CLASSICAL),
        new MusicItem(8L,  "So Much for the Afterglow", "Everclear",                 "1997-01-19", 13.99, MusicCategory.ROCK),
        new MusicItem(9L,  "Surfacing",                 "Sarah McLachlan",           "1997-12-04", 17.97, MusicCategory.ALTERNATIVE),
        new MusicItem(10L, "Hysteria",                  "Def Leppard",               "1987-06-20", 17.97, MusicCategory.ROCK),
        new MusicItem(11L, "A Life of Saturdays",       "Dexter Freebish",           "2000-12-06", 16.97, MusicCategory.RAP),
        new MusicItem(12L, "Human Clay",                "Creed",                     "1999-10-21", 18.97, MusicCategory.ROCK),
        new MusicItem(13L, "My, I'm Large",             "Bobs",                      "1987-02-20", 11.97, MusicCategory.COUNTRY),
        new MusicItem(14L, "So",                        "Peter Gabriel",             "1986-10-03", 17.97, MusicCategory.POP),
        new MusicItem(15L, "Big Ones",                  "Aerosmith",                 "1994-05-08", 18.97, MusicCategory.ROCK),
        new MusicItem(16L, "90125",                     "Yes",                       "1983-10-16", 11.97, MusicCategory.ROCK),
        new MusicItem(17L, "1984",                      "Van Halen",                 "1984-08-19", 11.97, MusicCategory.ROCK),
        new MusicItem(18L, "Escape",                    "Journey",                   "1981-02-25", 11.97, MusicCategory.CLASSIC_ROCK))
    );

    @Override
    public MusicItem findById(Long id) {
        MusicItem item = null;
        for (MusicItem currItem : catalogData) {
            if (currItem.getId().equals(id)) {
                item = currItem;
            }
        }

        if (item == null) {
            System.out.println("Item with id " + id + " not found");
        }

        return item;
    }

    @Override
    public Collection<MusicItem> findByKeyword(String keyword) {
        Collection<MusicItem> items = new ArrayList<>();
        for (MusicItem currItem : catalogData) {
            if (currItem.getTitle().contains(keyword) || currItem.getArtist().contains(keyword)) {
                items.add(currItem);
            }
        }
        return items;
    }

    @Override
    public Collection<MusicItem> findByCategory(MusicCategory category) {
        Collection<MusicItem> items = new ArrayList<>();

        for (MusicItem currItem : catalogData) {
            if (currItem.getMusicCategory().equals(category)) {
                items.add(currItem);
            }
        }

        return items;
    }

    @Override
    public int size() {
        return catalogData.size();
    }

    @Override
    public Collection<MusicItem> getAll() {
        return Collections.unmodifiableCollection(catalogData);
    }

    /**
     * After you've satisfied your contractual obligations above, do these additional tasks.
     *
     * NOTES:
     * 0. You can tackle them in any order, each one is independent of the others.
     *    They generally get harder as you go further down.
     *
     * 1. None of these methods should print to stdout (the console).  Instead, return a value.
     *    Each one should be tested by a test method in InMemoryCatalogTest,
     *    and there you *can* print your results, to verify that your code works correctly.
     *
     * 2. You may need to research a few things, that's to be expected.  Life Is Open-Book...
     *    The Javadoc is a good first place to look.
     *
     * 3. Keep a lookout for redundant code.  There is a high probability that you will write a chunk
     *    of code more than once.  When you see that, you should strongly consider refactoring that
     *    repeated code into a private method, and then calling that method from where it's needed.
     *    IntelliJ helps a lot here.  Select the repeated code in question, then
     *    right-click -> Refactor -> Extract Method.
     *    It's not just about removing redundancies - it will make the more complicated methods easier to write!
     */

    /**
     * TASK: find all MusicItems where title is same as artist.
     * For example, Madonna's first album is simply titled, "Madonna."
     */
    public Collection<MusicItem> findSelfTitled() {
        Collection<MusicItem> result = new ArrayList<>();

        for (MusicItem currItem : catalogData) {
            if (currItem.getTitle().equals(currItem.getArtist())) {
                result.add(currItem);
            }
        }
        return result;
    }


    /**
     * TASK: find all "rock" items whose price is less than or equal to the specified price.
     */
    public Collection<MusicItem> findRockLessThan(double price) {
        Collection<MusicItem> result = new ArrayList<>();
        for (MusicItem currItem : catalogData) {
            if ((currItem.getMusicCategory().equals(MusicCategory.ROCK)
                    || currItem.getMusicCategory().equals(MusicCategory.CLASSIC_ROCK))
                    && currItem.getPrice() <= price) {
                result.add(currItem);
            }
        }

        return result;
    }

    /**
     * TASK: how many items of the specified genre (MusicCategory) do we sell?
     */
    public int genreCount(MusicCategory category) {
        return findByCategory(category).size();
    }

    /**
     * TASK: determine average price of our low-cost, extensive catalog of music.
     */
    public double averagePrice() {
        double total = 0;
        for (MusicItem currItem : catalogData) {
            total += currItem.getPrice();
        }
        return total / catalogData.size();
    }

    /**
     * TASK: find the cheapest item with the specified genre (MusicCategory).
     */
    public MusicItem cheapestItemGenre(MusicCategory category) {
        double cheapest = Double.MAX_VALUE;
        MusicItem cheapestItem = null;

        for (MusicItem currItem : catalogData) {
            if (currItem.getMusicCategory().equals(category) && currItem.getPrice() < cheapest) {
                cheapest = currItem.getPrice();
                cheapestItem = currItem;
            }
        }

        return cheapestItem;
    }

    /**
     * TASK: find the average price of items in the specified genre (MusicCategory).
     */
    public double averageGenrePrice(MusicCategory category) {
        Collection<MusicItem> items = findByCategory(category);
        double total = 0;
        for (MusicItem currItem : items) {
            total += currItem.getPrice();
        }

        return total / items.size();
    }

    /**
     * TASK: are all items priced at least $10?
     * This is a yes/no answer.
     */
    public boolean atLeastTen() {
        for (MusicItem currItem : catalogData) {
            if (currItem.getPrice() < 10) {
                return false;
            }
        }

        return true;
    }

    /**
     * TASK: do we sell any items with the specified genre (MusicCategory)?
     * Another yes/no answer.
     */
    public boolean hasItemWithGenre(MusicCategory category) {
        for (MusicItem currItem : catalogData) {
            if (currItem.getMusicCategory().equals(category)) {
                return true;
            }
        }

        return false;
    }

    /**
     * TASK: find the titles of all "pop" items, sorted by natural order.
     * Just the titles!
     */
    public Collection<String> itemsWithGenre(MusicCategory category) {
        Collection<MusicItem> items = findByCategory(category);
        Collection<String> result = new TreeSet<>();
        for (MusicItem currItem : items) {
            result.add(currItem.getTitle());
        }

        return result;
    }

    /**
     * TASK: find all items released in the 80s whose price is less than or equal to the specified price.
     */
    public Collection<MusicItem> eightiesItemsLessThan(double price) {
        Collection<MusicItem> result = new ArrayList<>();

        for (MusicItem currItem : catalogData) {
            String yearString = currItem.getReleaseDate().toString().substring(0, 4);
            int year = Integer.parseInt(yearString);
            if ((year > 1979 && year < 1990) && (currItem.getPrice() <= price)) {
                result.add(currItem);
            }
        }
        return result;
    }


    /**
     * TASK: return a map whose keys are all the genres (categories), and each key's associated value
     * is a collection of items in that genre.  If there is a genre that we don't currently
     * sell, that key's associated value should be an empty collection, not null.
     */
    public Map<MusicCategory, Collection<MusicItem>> getGenreMap() {
        Map<MusicCategory, Collection<MusicItem>> genres = new HashMap<>();

        for (MusicItem currItem : catalogData) {
            if (genres.get(currItem.getMusicCategory()) == null) {
                genres.put(currItem.getMusicCategory(), new ArrayList<>());
            } else {
                genres.get(currItem.getMusicCategory()).add(currItem);
            }
        }

        return genres;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(getClass().getSimpleName() + ": \n");
        for (MusicItem item: catalogData) {
            builder.append(item).append("\n");
        }
        return builder.toString();
    }
}