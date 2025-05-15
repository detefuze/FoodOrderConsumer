package com.ru.klimashd.repositories;

import com.ru.klimashd.entities.Vegetables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VegetablesRepository extends JpaRepository<Vegetables, Integer> {
    Optional<Vegetables> findVegetablesById(int id);
}
