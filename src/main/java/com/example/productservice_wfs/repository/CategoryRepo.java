package com.example.productservice_wfs.repository;

import com.example.productservice_wfs.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category save(Category category);

    Optional<Category> findById(Long id);

    // nativeSQL QUERY.
    // I want to get category by categoryNAme
    @Query(value = "select c.name from Category c where c.name=?1 and c.description=?2")
    String findByNameAndDescription(String name, String description);

    @Query(value = "select c.name from Category c where c.description=?1")
    String findByDescription(String description);


    @Query(value = "SELECT firstname, lastname FROM SD_User WHERE id = ?1", nativeQuery = true)
    String[][] findByNativeQuery(Integer id);

}
