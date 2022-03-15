package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryRepositoryTest  extends StudyApplicationTests {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void create(){
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "adminServer";

        Category category = new Category();

        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);
        Assertions.assertNotNull(newCategory);
        Assertions.assertEquals(newCategory.getType(),type);
        Assertions.assertEquals(newCategory.getTitle(),title);


    }

    @Test
    public void read(){
        String type = "COMPUTER";
        Optional<Category> optionalCategory = categoryRepository.findByType(type);

        optionalCategory.ifPresent(selectCategory -> {
            Assertions.assertEquals(selectCategory.getType(),type);
            System.out.println(selectCategory.getId());
            System.out.println(selectCategory.getType());
            System.out.println(selectCategory.getTitle());
        });

        //Assertions.assertTrue(optionalCategory.isPresent());
    }

}
