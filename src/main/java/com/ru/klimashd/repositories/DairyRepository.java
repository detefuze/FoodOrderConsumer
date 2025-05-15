package com.ru.klimashd.repositories;

import com.ru.klimashd.entities.Dairy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DairyRepository extends JpaRepository<Dairy, Integer> {
    Optional<Dairy> findDairyById(int id);
}
