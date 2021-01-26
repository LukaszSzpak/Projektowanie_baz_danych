package com.library.libraryDB.repositories;

import com.library.libraryDB.entities.PublishHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishHouseRepository extends JpaRepository<PublishHouse, Long> {
    boolean existsByName(String name);
    PublishHouse findByName(String name);
}
