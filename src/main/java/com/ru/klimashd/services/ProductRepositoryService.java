package com.ru.klimashd.services;

import com.ru.enums.ProductType;
import com.ru.foodshop_entities.Product;
import com.ru.klimashd.repositories.BakeryRepository;
import com.ru.klimashd.repositories.DairyRepository;
import com.ru.klimashd.repositories.FruitsRepository;
import com.ru.klimashd.repositories.VegetablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductRepositoryService {
    private final Map<String, JpaRepository<? extends Product, Integer>> repositories;

    public ProductRepositoryService(BakeryRepository bakeryRepository,
                                    DairyRepository dairyRepository,
                                    FruitsRepository fruitsRepository,
                                    VegetablesRepository vegetablesRepository) {
        this.repositories = Map.of(
                ProductType.FRUIT.getProductTypeString(), fruitsRepository,
                ProductType.VEGETABLE.getProductTypeString(), vegetablesRepository,
                ProductType.DAIRY.getProductTypeString(), dairyRepository,
                ProductType.BAKERY.getProductTypeString(), bakeryRepository
        );
    }

    public JpaRepository<? extends Product, Integer> getRepositoryByProductType(
            String productType) {
        return repositories.get(productType);
    }

    public Product getProductById(Integer id, String productType) {
        JpaRepository<? extends Product, Integer> current_repository = repositories.get(productType);
        return current_repository.findById(id).orElse(null);
    }
}
