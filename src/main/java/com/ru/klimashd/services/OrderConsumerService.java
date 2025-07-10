package com.ru.klimashd.services;


import com.ru.klimashd.dto.BasketDTO;
import com.ru.klimashd.entities.CustomerOrder;
import com.ru.klimashd.mappers.MapperToOrder;
import com.ru.klimashd.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderConsumerService {

    private final static Logger log_service = LoggerFactory.getLogger(OrderConsumerService.class);
    private final RestTemplate restTemplate;

    private final OrderRepository orderRepository;

    @Autowired
    public OrderConsumerService(OrderRepository orderRepository,
                                RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    @Transactional
    public void processOrder(List<BasketDTO> basketList) {
        try {
            CustomerOrder order = new MapperToOrder().mapListBasketToOrder(
                    basketList);
            orderRepository.save(order);

            String uiServiceUrl = "http://localhost:8080/main_menu/getOrder";
            ResponseEntity<String> consumerResponse = restTemplate.postForEntity(uiServiceUrl,
                    basketList,
                    String.class);
            log_service.info("Processing order complete");
        } catch (Exception e) {
            log_service.error("Error in processing an order");
            log_service.error("Exception: ", e);
        }
    }
}
