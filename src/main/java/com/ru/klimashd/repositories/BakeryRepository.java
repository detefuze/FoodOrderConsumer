package com.ru.klimashd.repositories;

import com.ru.klimashd.entities.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BakeryRepository extends JpaRepository<Bakery, Integer> {
    Optional<Bakery> findBakeryById(int id);
}
