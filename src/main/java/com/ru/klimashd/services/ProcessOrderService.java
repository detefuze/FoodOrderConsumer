package com.ru.klimashd.services;

import com.ru.klimashd.dto.BasketDTO;
import com.ru.klimashd.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessOrderService {
    private final FruitsRepository fruitsRepository;
    private final DairyRepository dairyRepository;
    private final BakeryRepository bakeryRepository;
    private final VegetablesRepository vegetablesRepository;


    public ProcessOrderService(BasketRepository basketRepository,
                               FruitsRepository fruitsRepository,
                               DairyRepository dairyRepository,
                               BakeryRepository bakeryRepository,
                               DairyRepository dairyRepository1,
                               VegetablesRepository vegetablesRepository) {
        this.fruitsRepository = fruitsRepository;
        this.bakeryRepository = bakeryRepository;
        this.dairyRepository = dairyRepository1;
        this.vegetablesRepository = vegetablesRepository;
    }

    @Transactional
    public boolean processProducts(List<BasketDTO> basketList) {
        for (BasketDTO pos : basketList) {
            if (pos.getProduct_type().equals("fruits")) {
                int current_amount = fruitsRepository.findFruitsById(pos.getId_product())
                        .get().getAmount();
                int new_amount = current_amount - pos.getAmount();
                if (new_amount < 0)
                    return false;
                fruitsRepository.findFruitsById(pos.getId_product())
                        .ifPresent(p -> p.setAmount(new_amount));
            }
            else if (pos.getProduct_type().equals("dairy")) {
                int current_amount = dairyRepository.findDairyById(pos.getId_product())
                        .get().getAmount();
                int new_amount = current_amount - pos.getAmount();
                if (new_amount < 0)
                    return false;
                dairyRepository.findDairyById(pos.getId_product())
                        .ifPresent(p -> p.setAmount(new_amount));
            }
            else if (pos.getProduct_type().equals("vegetables")) {
                int current_amount = vegetablesRepository.findVegetablesById(pos.getId_product())
                        .get().getAmount();
                int new_amount = current_amount - pos.getAmount();
                if (new_amount < 0)
                    return false;
                vegetablesRepository.findVegetablesById(pos.getId_product())
                        .ifPresent(p -> p.setAmount(new_amount));
            }
            else if (pos.getProduct_type().equals("bakery")) {
                int current_amount = bakeryRepository.findBakeryById(pos.getId_product())
                        .get().getAmount();
                int new_amount = current_amount - pos.getAmount();
                if (new_amount < 0)
                    return false;
                bakeryRepository.findBakeryById(pos.getId_product())
                        .ifPresent(p -> p.setAmount(new_amount));
            }
        }
        return true;
    }
}