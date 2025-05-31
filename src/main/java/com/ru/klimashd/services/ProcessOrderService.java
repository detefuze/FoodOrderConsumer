package com.ru.klimashd.services;

import com.ru.foodshop_entities.Product;
import com.ru.klimashd.dto.BasketDTO;
import com.ru.klimashd.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessOrderService {
    private final ProductRepositoryService productRepositoryService;


    public ProcessOrderService(ProductRepositoryService productRepositoryService) {
        this.productRepositoryService = productRepositoryService;
    }

    @Transactional
    public boolean processProducts(List<BasketDTO> basketList) {
        for (BasketDTO pos : basketList) {
            JpaRepository<? extends Product, Integer> repository = productRepositoryService
                    .getRepositoryByProductType(pos.getProduct()
                                    .getProductType()
                                    .getProductTypeString());
            repository.findById(pos.getProduct_id()).ifPresent(p -> p.setAmount(
                    repository.findById(pos.getProduct_id()).get().getAmount() - pos.getOrder_amount())
            );
        }
        return true;
    }
}