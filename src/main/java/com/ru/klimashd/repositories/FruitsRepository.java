package com.ru.klimashd.repositories;

import com.ru.klimashd.entities.Fruits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitsRepository extends JpaRepository<Fruits, Integer> {
    Optional<Fruits> findFruitsById(int id);
}
