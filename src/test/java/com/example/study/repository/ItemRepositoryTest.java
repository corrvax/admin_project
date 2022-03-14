package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.ls.LSOutput;

import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();
        item.setName("note book3");
        item.setTitle("title is 3cnote book");
        item.setContent("sam sung NoteBook");
        item.setPrice(300000);
        item.setPartnerId(3L);

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
    }

    @Test
    public void read(){
        Long id = 406L;

        Optional<Item> item = itemRepository.findById(id);

        Assertions.assertTrue(item.isPresent());
    }
}