package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findByCategory_shouldReturnCollectionWithCategory() {
        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);

        assertEquals(4, popItems.size());
    }

    @Test
    public void findById_shouldReturnNull_idNotFound() {
        MusicItem item = catalog.findById(1001L);

        assertNull(item);
    }

    @Test
    public void findById_shouldReturnMusicItemWithId_idFound() {
        MusicItem item = catalog.findById(18L);

        assertEquals(Long.valueOf(18), item.getId());
    }
}