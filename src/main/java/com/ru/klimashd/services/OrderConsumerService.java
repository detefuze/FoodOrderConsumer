package com.ru.klimashd.services;

import com.ru.klimashd.dto.BasketDTO;
import com.ru.klimashd.entities.CustomerOrder;
import com.ru.klimashd.mappers.MapperToOrder;
import com.ru.klimashd.repositories.BasketRepository;
import com.ru.klimashd.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderConsumerService {

    private final static Logger log_service = LoggerFactory.getLogger(OrderConsumerService.class);

    private final BasketRepository basketRepository;
    private final OrderRepository orderRepository;
    private final ProcessOrderService processOrderService;

    public OrderConsumerService(OrderRepository orderRepository,
                                BasketRepository basketRepository,
                                ProcessOrderService processOrderService) {
        this.orderRepository = orderRepository;
        this.basketRepository = basketRepository;
        this.processOrderService = processOrderService;
    }

    @Transactional
    public void processOrder(List<BasketDTO> basketList) {
        if (processOrderService.processProducts(basketList)) {
            List<CustomerOrder> orders = new MapperToOrder().mapListBasketToListOrder(
                    basketList);
            orderRepository.saveAll(orders);
            basketRepository.deleteAll();
            log_service.info("Processing order complete");
        }
        else
            log_service.error("Error in processing an order");
    }
}
